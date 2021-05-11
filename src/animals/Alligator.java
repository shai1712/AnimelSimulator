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
public class Alligator extends WaterAnimal implements IReptile {

	private String AreaOfLiving;
	private TerrestrialAnimals amphibious;

	/**
	 * Alligator constructor with parameters
	 * 
	 * @param position - the current location of the animal
	 * @param name     - the name of the animal
	 * @param gender   - the gender of the animal
	 * @param weight   - the animal weight
	 * @param speed    - the animal speed
	 * @param diveDept - the animal diving depth
	 * @param area     - the Alligator area of living
	 * @param medals   - the set of medals of the animal
	 */
	public Alligator(String name, Gender gender, double weight, double speed, double diveDept, String area,
			Medal[] medals, int maxEnergy) {
		super(name, gender, weight, speed, diveDept, medals, maxEnergy);
		TerrestrialAnimals temp = new TerrestrialAnimals(name, gender, weight, speed, 4, medals, maxEnergy);
		this.makeAmphibious(temp);
		this.setAreaOfLiving(area);
		this.type = "Alligator";
	}

	public Alligator() {
		super();
		this.setDiveDept(-50);
		this.makeAmphibious(new TerrestrialAnimals());
		this.amphibious.setNoLegs(4);
		this.setAreaOfLiving("Africa");
		this.type = "Alligator";
	}

	/**
	 * @return the areaOfLiving
	 */
	public String getAreaOfLiving() {
		return AreaOfLiving;
	}

	/**
	 * @param areaOfLiving the areaOfLiving to set
	 */
	public boolean setAreaOfLiving(String areaOfLiving) {
		if (areaOfLiving != null) {
			this.AreaOfLiving = areaOfLiving;
			return true;
		}
		return false;
	}

	@Override
	public void loadImages(String nm) {
		try {
			this.img1 = ImageIO.read(new File("src\\images\\alligator" + nm + "E.png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}

	@Override
	public void speedUp(double k) {
		this.setSpeed(Math.min(k + this.getSpeed(), MAX_SPEED));
	}

	public String specificSound() {
		return "Roar";

	}

	public boolean makeAmphibious(TerrestrialAnimals ta) {
		if (ta == null)
			return false;
		this.amphibious = ta;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "\nArea of living: " + this.getAreaOfLiving();
	}

}
