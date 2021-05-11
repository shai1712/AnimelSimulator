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
public class WaterAnimal extends Animal {
	private static final int MAX_DIVE = -800;
	private double diveDept;
	

	/**
	 * WaterAnimal constructor with parameters
	 * 
	 * @param position - the current location of the animal
	 * @param name     - the name of the animal
	 * @param gender   - the gender of the animal
	 * @param weight   - the weight of the animal
	 * @param speed    - the speed of the animal
	 * @param diveDept - the diving depth the animal can reach
	 * @param medals   - the set of medals of the animal
	 */
	public WaterAnimal(String name, Gender gender, double weight, double speed, double diveDept,
			Medal[] medals,int maxEnergy) {
		super(name, gender, weight, speed, medals,maxEnergy);
		this.setDiveDept(diveDept);
		this.category = "Water";
	}

	public WaterAnimal() {
		super();
		this.setDiveDept(-500);
		this.category = "Water";
	}

	/**
	 * @return the diving Depth of the animal
	 */
	public double getDiveDept() {
		return diveDept;
	}

	/**
	 * @param diveDept the diveDept to set
	 */
	public boolean setDiveDept(double diveDept) {
		if (diveDept >= MAX_DIVE && diveDept < 0) {
			this.diveDept = diveDept;
			return true;
		}
		return false;
	}

	/**
	 * make the animal dive deeper, however, only it doesn't cause it to dive deeper
	 * than its MAX_DIVE value
	 * 
	 * @param dive - waiting for lecturer's answer
	 */
	public void dive(double dive) {
		this.setDiveDept(Math.max(dive + this.getDiveDept(), MAX_DIVE));
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
	public String specificSound() {
		return "";
	}

	@Override
	public String toString() {
		return super.toString() + "\nDive depth: " + this.getDiveDept();
	}

	@Override
	public void loadImages(String nm) {
		
	}

}
