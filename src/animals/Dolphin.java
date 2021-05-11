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
public class Dolphin extends WaterAnimal {
	public enum WaterType {
		SEA, SWEET
	}

	private WaterType waterType;

	/**
	 * Dolphin constructor with parameters
	 * @param position - the current location of the animal
	 * @param name     - the name of the animal
	 * @param gender   - the gender of the animal
	 * @param weight   - the weight of the animal
	 * @param speed    - the speed of the animal
	 * @param diveDept - the animal diving depth
	 * @param waterType     - dolphin's type: Sea or sweet water
	 * @param medals - the set of medals of the animal
	 */
	public Dolphin(String name, Gender gender, double weight, double speed, double diveDept,
			WaterType waterType,Medal[] medals,int maxEnergy,int epm) {
		super(name, gender, weight, speed, diveDept, medals, maxEnergy);
		this.setWaterType(waterType);
		this.type = "Dolphin";
	}
	public Dolphin() {
		super();
		this.setWaterType(WaterType.SEA);
		this.type = "Dolphin";
	}

	/**
	 * @return the type
	 */
	public WaterType getWaterType() {
		return this.waterType;
	}

	/**
	 * @param type the type to set
	 */
	public boolean setWaterType(WaterType waterType) {
		if (waterType == WaterType.SEA || waterType == WaterType.SWEET) {
			this.waterType = waterType;
			return true;
		}
		return false;
	}

	public String specificSound() {
		return "Click-click";

	}

	@Override
	public void loadImages(String nm) {
		try {
			this.img1 = ImageIO.read(new File("src\\images\\dolphin" + nm + "E.png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nLives in: " + this.getWaterType() + " Water";
	}

}
