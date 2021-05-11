/**
 * 
 */
package mobility;

/**
 * @author Shai Shitrit 307874065 & Amit Amir 311527329
 *
 */
public interface ILocatable {
	/**
	 * 
	 * @return the location of the object
	 */
	public Point getLocation();

	/**
	 * 
	 * @param p - the x & y coordinates of the object to set
	 * @return true for success, false otherwise.
	 */
	public boolean setLocation(Point p);
}
