/**
 * 
 */
package mobility;

/**
 * @author Shai Shitrit 307874065 & Amit Amir 311527329
 *
 */
public abstract class Mobile implements ILocatable {
	private Point location;
	private double totalDistance;

	/**
	 * Constructor with parameter
	 * 
	 * @param location - the location of the object
	 */
	public Mobile(Point location) {
		this.setLocation(new Point(location.getX(), location.getY()));
		this.setTD(0);
	}

	/**
	 * Constructor with default values
	 */
	public Mobile() {
		this.setLocation(new Point(0, 0));
		this.setTD(0);
	}

	public Point getLocation() {
		return this.location;
	}

	public boolean setLocation(Point loc) {
		if (loc != null) {
			this.location = new Point();
			this.location.setX(loc.getX());
			this.location.setY(loc.getY());
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return the total distance the object has covered.
	 */
	public double getTD() {
		return this.totalDistance;
	}

	/**
	 * 
	 * @param td - the total distance to set
	 * @return true for success, false otherwise
	 */
	public boolean setTD(double td) {
		if (td >= 0) {
			this.totalDistance = td;
			return true;
		}
		return false;
	}

	/**
	 * add the distance(td) to the object's total distance.
	 * 
	 * @param td - the total distance to add
	 */
	public void addTotalDistance(double td) {
		this.setTD(this.getTD() + td);
	}

	/**
	 * calculate the distance between point a to point b using the distance formula.
	 * 
	 * @param p - the point to calculate the distance to
	 * @return the distance from this to p.
	 */
	public double calcDistance(Point p) {
		double tempX = Math.pow(this.location.getX() - p.getX(), 2);
		double tempY = Math.pow(this.location.getY() - p.getY(), 2);
		return Math.sqrt(tempX + tempY);

	}

	/**
	 * 
	 * @param p - the point to move to
	 * @return distance traveled, 0 if none
	 */
	public double move(Point p) {
		double distance = this.calcDistance(p);
		if (distance > 0) {
			return distance;
		} else
			return 0;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Location:" + this.location.toString() + "\nTotal Distance:" + this.getTD() + "\n";
	}
}
