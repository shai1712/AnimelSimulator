/**
 * 
 */
package animals;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import mobility.Point;
import olympics.Medal;

/**
 * @author Shai Shitrit 307874065 & Amit Amir 311527329
 *
 */
public class Pigeon extends AirAnimal {

	private String family;

	/**
	 * Eagle constructor with parameters
	 * @param position  - the current location of the animal
	 * @param name     - the name of the animal
	 * @param gender   - the gender of the animal
	 * @param weight   - the weight of the animal
	 * @param speed    - the speed of the animal
	 * @param wingspan - the animal wingspan
	 * @param family - the pigeon's family
	 * @param medals - the set of medals of the animal
	 */
	public Pigeon(String name, Gender gender, double weight, double speed, double wingspan, String family, Medal[] medals,int maxEnergy) {
		super(name, gender, weight, speed, wingspan, medals, maxEnergy);
		this.setFamily(family);
		this.type = "Pigeon";
	}
	/**
	 * constructor with default values
	 */
	public Pigeon() {
		super();
		this.setFamily("Urban");
		this.type = "Pigeon";
	}
	/**
	 * @return the family
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * @param family the family to set
	 */
	public boolean setFamily(String family) {
		if (family != null) {
			this.family = family;
			return true;
		}
		return false;
	}

	@Override
	public void loadImages(String nm) {
		try {
			this.img1 = ImageIO.read(new File("src\\images\\pigeon.png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}
	@Override
	public String toString() {
		return super.toString() + "\nFamily: " + this.getFamily() + "\n";
	}

	public String specificSound() {
		return "Arr-rar-rar-rar-raah";

	}

}
