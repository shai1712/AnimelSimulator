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
public class Cat extends TerrestrialAnimals {

	private boolean castrated = false;

	/**
	 * Cat constructor with parameters
	 * 
	 * @param position  - the current location of the animal
	 * @param name      - the name of the animal
	 * @param gender    - the gender of the animal
	 * @param weight    - the weight of the animal
	 * @param speed     - the speed of the animal
	 * @param noLegs    - the number of legs the animal has
	 * @param castrated - is the cat castrated
	 * @param medals    - the set of medals of the animal
	 */
	public Cat(String name, Gender gender, double weight, double speed, int noLegs, boolean castrated, Medal[] medals,
			int maxEnergy) {
		super(name, gender, weight, speed, noLegs, medals, maxEnergy);
		this.setCastrated(castrated);
		this.type = "Cat";
	}

	/**
	 * constructor with default values
	 */
	public Cat() {
		super();
		this.setCastrated(true);
		this.type = "Cat";
	}

	/**
	 * @return the castrated
	 */
	public boolean isCastrated() {
		return castrated;
	}

	/**
	 * @param castrated the castrated to set
	 */
	public boolean setCastrated(boolean castrated) {

		if (isCastrated()) {
			return false;
		}
		this.castrated = castrated;
		return true;
	}

	public String specificSound() {
		return "Meow";

	}

	@Override
	public String toString() {
		return super.toString() + "\nIs castrated: " + this.isCastrated();
	}

	@Override
	public void loadImages(String nm) {
		try {
			this.img1 = ImageIO.read(new File("src\\images\\cat" + nm + "E.png"));
			this.img2 = ImageIO.read(new File("src\\images\\cat" + nm + "S.png"));
			this.img3 = ImageIO.read(new File("src\\images\\cat" + nm + "W.png"));
			this.img4 = ImageIO.read(new File("src\\images\\cat" + nm + "N.png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}
}
