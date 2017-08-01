package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class ResizeFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private JButton chooseIcon;
	private JButton createIcons;
	private JLabel pathLabel;

	public ResizeFrame() {
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Welcome!");
        
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
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
}
