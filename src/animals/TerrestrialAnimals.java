package animals;

import mobility.Point;
import olympics.Medal;

/**
 * @author Shai Shitrit 307874065 & Amit Amir 311527329
 *
 */
public class TerrestrialAnimals extends Animal {

	private int noLegs;

	/**
	 * TerrestrialAnimals constructor with parameters
	 * 
	 * @param position - the current location of the animal
	 * @param name     - the name of the animal
	 * @param gender   - the gender of the animal
	 * @param weight   - the weight of the animal
	 * @param speed    - the speed of the animal
	 * @param noLegs   - the number of legs the animal has
	 * @param medals - the set of medals of the animal
	 */
	public TerrestrialAnimals(String name, Gender gender, double weight, double speed, int noLegs,Medal[] medals,int maxEnergy) {
		super(name, gender, weight, speed,medals,maxEnergy);
		this.setNoLegs(noLegs);
		this.category = "Terrestrial";
	}

	/**
	 * Constructor with default values
	 */
	public TerrestrialAnimals() {
		super();
		this.setNoLegs(4);
		this.category = "Terrestrial";
	}
	/**
	 * @return the noLegs
	 */
	public int getNoLegs() {
		return noLegs;
	}

	/**
	 * 
	 * @param noLegs the noLegs to set
	 * @return true for success, false otherwise
	 */
	public boolean setNoLegs(int noLegs) {
		if (noLegs >= 0) {
			this.noLegs = noLegs;
			return true;
		}
		return false;
	}

	@Override
	public String specificSound() {
		return "";
	}

	@Override
	public String toString() {
		return super.toString() + "\nNumber of legs: " + this.getNoLegs();
	}

	@Override
	public void loadImages(String nm) {
		
	}

}
