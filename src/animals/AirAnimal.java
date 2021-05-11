/**
 * 
 */
package animals;


import mobility.Point;
import olympics.Medal;

/**
 * @author Shai Shitrit 307874065 & Amit Amir 311527329
 *
 */
public class AirAnimal extends Animal {

	private double wingspan;

	/**
	 * AirAnimal constructor with parameters
	 * 
	 * @param position - the current location of the animal
	 * @param name     - the name of the animal
	 * @param gender   - the gender of the animal
	 * @param weight   - the weight of the animal
	 * @param speed    - the speed of the animal
	 * @param wingspan - the wingspan of the animal
	 * @param medals   - the set of medals of the animal
	 */
	public AirAnimal(String name, Gender gender, double weight, double speed, double wingspan,
			Medal[] medals, int maxEnergy) {
		super(name, gender, weight, speed, medals, maxEnergy);
		this.setWingspan(wingspan);
		this.category = "Air";
	}

	/**
	 * AirAnimal constructor with default parameters
	 */
	public AirAnimal() {
		super();
		this.setWingspan(2.0);
		this.category = "Air";
	}

	/**
	 * @return the wingspan
	 */
	public double getWingspan() {
		return wingspan;
	}

	/**
	 * @param wingspan the wingspan to set
	 */
	public boolean setWingspan(double wingspan) {
		if (wingspan > 0) {
			this.wingspan = wingspan;
			return true;
		}
		return false;
	}

	@Override
	public Point getLocation() {
		return super.getLocation();
	}

	@Override
	public boolean setLocation(Point p) {
		if (super.setLocation(p))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + "\nWing span: " + this.getWingspan();
	}

	@Override
	public String specificSound() {
		return "";
	}

	@Override
	public void loadImages(String nm) {
		
	}
}
