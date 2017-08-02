package controller;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Resizer {
	
	//Converts Image to BufferedImage
	public static BufferedImage toBufferedImage(Image img){
		if (img instanceof BufferedImage){
			return (BufferedImage) img;
		}

		// Create a buffered image with transparency
		BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

		// Draw the image on to the buffered image
		Graphics2D bGr = bimage.createGraphics();
		bGr.drawImage(img, 0, 0, null);
		bGr.dispose();

		// Return the buffered image
		return bimage;
	}
	
	public static BufferedImage resizeImage(BufferedImage img, int newWidth, int newHeight){
		Image newImage = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
		BufferedImage resizedImage = Resizer.toBufferedImage(newImage);
		
		return resizedImage;
	}
	
	public static void resizeAndSave(String fullFilePath, String filePath, String fileName){
		BufferedImage image = null;

		try {
			image = ImageIO.read(new File(fullFilePath)); // eventually C:\\ImageTest\\pic2.jpg
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		//192px
		BufferedImage image192 = Resizer.resizeImage(image, 192, 192);
		
		//144px
		BufferedImage image144 = Resizer.resizeImage(image, 144, 144);
		
		//96px
		BufferedImage image96 = Resizer.resizeImage(image, 96, 96);
		
		//72px
		BufferedImage image72 = Resizer.resizeImage(image, 72, 72);
		
		//48px
		BufferedImage image48 = Resizer.resizeImage(image, 48, 48);


		//192px
		try {
			//Write image
			File outputFile = new File(filePath + "/" + "mipmap-xxxhdpi" + "/" + fileName);
			outputFile.getParentFile().mkdirs();
			ImageIO.write(image192, "png", outputFile);
		} 
		catch (IOException e) {
			System.err.println("Could not save 192px");
			e.printStackTrace();
		}
		
		//144px
		try {
			//Write image
			File outputFile = new File(filePath + "/" + "mipmap-xxhdpi" + "/" + fileName);
			outputFile.getParentFile().mkdirs();
			ImageIO.write(image144, "png", outputFile);
		} 
		catch (IOException e) {
			System.err.println("Could not save 144px");
			e.printStackTrace();
		}
		
		//96px
		try {
			//Write image
			File outputFile = new File(filePath + "/" + "mipmap-xhdpi" + "/" + fileName);
			outputFile.getParentFile().mkdirs();
			ImageIO.write(image96, "png", outputFile);
		} 
		catch (IOException e) {
			System.err.println("Could not save 96px");
			e.printStackTrace();
		}
		
		//72px
		try {
			//Write image
			File outputFile = new File(filePath + "/" + "mipmap-hdpi" + "/" + fileName);
			outputFile.getParentFile().mkdirs();
			ImageIO.write(image72, "png", outputFile);
		} 
		catch (IOException e) {
			System.err.println("Could not save 72px");
			e.printStackTrace();
		}
		
		//48px
		try {
			//Write image
			File outputFile = new File(filePath + "/" + "mipmap-mdpi" + "/" + fileName);
			outputFile.getParentFile().mkdirs();
			ImageIO.write(image48, "png", outputFile);
		} 
		catch (IOException e) {
			System.err.println("Could not save 48px");
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "Resized icons created!");
	}
}
