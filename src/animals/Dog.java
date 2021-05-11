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
public class Dog extends TerrestrialAnimals {

	private String breed;

	/**
	 * Dog constructor with parameters
	 * 
	 * @param name     - the name of the animal
	 * @param position - the current location of the animal
	 * @param gender   - the gender of the animal
	 * @param weight   - the weight of the animal
	 * @param speed    - the speed of the animal
	 * @param noLegs   - the number of legs the animal has
	 * @param breed    - the breed of the dog
	 * @param medals   - the set of medals of the animal
	 */
	public Dog(String name, Gender gender, double weight, double speed, int noLegs, String breed, Medal[] medals,
			int maxEnergy) {
		super(name, gender, weight, speed, noLegs, medals, maxEnergy);
		this.setBreed(breed);
		this.type = "Dog";
	}

	public Dog() {
		super();
		this.setBreed("Haski");
		this.type = "Dog";
	}

	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @param breed the breed to set
	 */
	public boolean setBreed(String breed) {
		if (breed != null) {
			this.breed = breed;
			return true;
		}
		return false;
	}

	@Override
	public void loadImages(String nm) {
		try {
			this.img1 = ImageIO.read(new File("src\\images\\dog" + nm + "E.png"));
			this.img2 = ImageIO.read(new File("src\\images\\dog" + nm + "S.png"));
			this.img3 = ImageIO.read(new File("src\\images\\dog" + nm + "W.png"));
			this.img4 = ImageIO.read(new File("src\\images\\dog" + nm + "N.png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}

	public String specificSound() {
		return "Woof Woof";

	}

	@Override
	public String toString() {
		return super.toString() + "\nBreed: " + this.getBreed();
	}
}
