package graphics;

import java.awt.Graphics;

public interface IDrawable {
	
	public final static String PICTURE_PATH = "…";
	/**
	 * this method load the images using the path file nm
	 * @param nm - the String representation of the file path location
	 */
	public void loadImages(String nm);
	/**
	 * this method draw the object on the screen
	 * @param g 
	 */
	public void drawObject (Graphics g);


}
