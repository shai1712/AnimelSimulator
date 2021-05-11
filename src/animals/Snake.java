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
public class Snake extends TerrestrialAnimals implements IReptile {

	public enum Poisonous {
		LOW, MEDIUM, HIGH

	}

	private Poisonous poison;
	private double length;

	/**
	 * Snake constructor with parameters
	 * 
	 * @param position - the current location of the animal
	 * @param name     - the animal name
	 * @param gender   - the animal gender
	 * @param weight   - the animal weight
	 * @param speed    - the animal speed
	 * @param noLegs   - the number of legs the animal has
	 * @param length   - the length of the snake
	 * @param poison   - the toxicity level of the snake
	 */
	public Snake(String name, Gender gender, double weight, double speed, int noLegs, double length,
			Poisonous poison, Medal[] medals, int maxEnergy) {
		super(name, gender, weight, speed, noLegs, medals, maxEnergy);
		this.setLength(length);
		this.setPoison(poison);
		this.type = "Snake";
	}

	/**
	 * constructor with default values
	 */
	public Snake() {
		super();
		this.setNoLegs(0);
		this.setLength(4.0);
		this.setPoison(Poisonous.LOW);
		this.type = "Snake";
	}

	/**
	 * @return the poison level of the snake(low, medium, high)
	 */
	public Poisonous getPoison() {
		return poison;
	}

	/**
	 * @param poison the poison to set
	 */
	public boolean setPoison(Poisonous poison) {

		if (poison == Poisonous.HIGH || poison == Poisonous.LOW || poison == Poisonous.MEDIUM) {
			this.poison = poison;
			return true;
		}
		return false;
	}

	/**
	 * @return the length
	 */

	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public boolean setLength(double length) {
		if (length < 0) {
			return false;
		}
		this.length = length;
		return true;

	}

	@Override
	public void speedUp(double k) {
		this.setSpeed(Math.min(k + this.getSpeed(), MAX_SPEED));
	}

	public String specificSound() {
		return "ssssssss";

	}

	@Override
	public void loadImages(String nm) {
		try {
			this.img1 = ImageIO.read(new File("src\\images\\snake" + nm + "E.png"));
			this.img2 = ImageIO.read(new File("src\\images\\snake" + nm + "S.png"));
			this.img3 = ImageIO.read(new File("src\\images\\snake" + nm + "W.png"));
			this.img4 = ImageIO.read(new File("src\\images\\snake" + nm + "N.png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}

	@Override
	public String toString() {
		return super.toString() + "\nLength: " + this.getLength() + "\nToxicity: " + this.getPoison();
	}

}
