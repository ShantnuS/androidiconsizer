package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Resizer;

public class ResizeFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private JButton chooseIcon;
	private JButton createIcons;
	private JLabel pathLabel;
	private JFileChooser locationChooser;
	
	private String fullFilePath;
	private String filePath;
	private String fileName;

	public ResizeFrame() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Android Icon Resizer");
        
        myPanel = new JPanel();
        myPanel.setBorder(new EmptyBorder(20,20,20,20));
        myPanel.setLayout(new FlowLayout());
        myPanel.setBackground(Color.white);
        this.setContentPane(myPanel);        
	}
	
	public void init(){
		chooseIcon = new JButton("Choose Icon");
		createIcons = new JButton("Create Icons");
		pathLabel = new JLabel("Choose an image...");
		
		myPanel.add(pathLabel);
		myPanel.add(chooseIcon);
		myPanel.add(createIcons);	
		
		chooseIcon.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
				locationChooser = new JFileChooser();
				locationChooser.setAcceptAllFileFilterUsed(false);
				locationChooser.addChoosableFileFilter(imageFilter);
				
				if(locationChooser.showDialog(null, "Select") == JFileChooser.APPROVE_OPTION){
					boolean isDir = locationChooser.getSelectedFile().isDirectory();
					File chosenDirectory = isDir ? locationChooser.getSelectedFile() : locationChooser.getCurrentDirectory();
					File chosenFile = locationChooser.getSelectedFile();
					pathLabel.setText(chosenFile.getAbsolutePath());

					filePath = chosenDirectory.getAbsolutePath();
					fullFilePath = chosenFile.getPath();
					fileName = chosenFile.getName();
				}
			} 
		} );
		
		createIcons.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				if(filePath != null && fullFilePath != null && fileName != null){
					Resizer.resizeAndSave(fullFilePath, filePath, fileName);
				}
				else{
					JOptionPane.showMessageDialog(null, "Please select an image first!");
				}
			} 
		} );
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
}
