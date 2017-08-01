package main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import controller.Resizer;

public class Main {

	
	//Converts Image to BufferedImage
	public static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
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
	
	public static void main(String[] args){
		Resizer resizer = new Resizer();
		resizer.init();
		/*
		BufferedImage image = null;
		
		try {
		    image = ImageIO.read(new File("C:/Users/Shantnu/Desktop/image/ml_icon512.png")); // eventually C:\\ImageTest\\pic2.jpg
		} 
		catch (IOException e) {
		    e.printStackTrace();
		}
		
		//192px X 192px 
		Image image192 = image.getScaledInstance(192, 192, Image.SCALE_SMOOTH);
		BufferedImage img = Main.toBufferedImage(image192);
		
		try {
		    // retrieve image
		    File outputfile = new File("C:/Users/Shantnu/Desktop/image/ml_icon192.png");
		    ImageIO.write(img, "png", outputfile);
		} 
		catch (IOException e) {
		    e.printStackTrace();
		}
		*/
	}
	
}
