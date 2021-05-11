package mobility;

import graphics.IClonable;

/**
 * 
 * @author Shai Shitrit 307874065 & Amit Amir 311527329
 *
 */
public class Point implements IClonable {
	private int x;
	private int y;

	/**
	 * Point constructor with parameters
	 * 
	 * @param x non-negative integer value
	 * @param y non-negative integer value
	 */
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Point constructor with default parameters(0,0)
	 */
	public Point() {
		this.setX(0);
		this.setY(0);
	}

	/**
	 * Point copy ctor
	 * @param p - the Point object to copy
	 */
	public Point(Point p) {
		this.setX(p.getX());
		this.setY(p.getY());
	}

	/**
	 * 
	 * @return the x coordinate of the object
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * 
	 * @param x the x coordinate to set
	 * @return true for success, false otherwise
	 */
	public boolean setX(int x) {
		if (x >= 0) {
			this.x = x;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return the y coordinate of the objects
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * 
	 * @param y - the y coordinate to set
	 * @return true for success, false otherwise
	 */
	public boolean setY(int y) {
		if (y >= 0) {
			this.y = y;
			return true;
		}
		return false;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Overriding Object toString
	 */
	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}

}
