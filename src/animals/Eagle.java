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
public class Eagle extends AirAnimal {

	private double altitudeOfFlight;
	private static final double MAX_ALTITUDE = 1000;

	/**
	 * Eagle constructor with parameters
	 * 
	 * @param position  - the current location of the animal
	 * @param name      - the name of the animal
	 * @param gender    - the gender of the animal
	 * @param weight    - the weight of the animal
	 * @param speed     - the speed of the animal
	 * @param wingspan  - the animal wingspan
	 * @param flightAlt - the eagle flight altitude
	 * @param medals    - the set of medals of the animal
	 */
	public Eagle(String name, Gender gender, double weight, double speed, double wingspan,
			double flightAlt, Medal[] medals,int maxEnergy) {
		super(name, gender, weight, speed, wingspan, medals, maxEnergy);
		this.setAltitudeOfFlight(flightAlt);
		this.type = "Eagle";
	}

	public Eagle() {
		super();
		this.setAltitudeOfFlight(100);
		this.type = "Eagle";
	}

	/**
	 * @return the altitudeOfFlight
	 */
	public double getAltitudeOfFlight() {
		return altitudeOfFlight;
	}

	/**
	 * @param altitudeOfFlight the altitudeOfFlight to set
	 */
	public boolean setAltitudeOfFlight(double altitudeOfFlight) {
		if (altitudeOfFlight >= 0 && altitudeOfFlight <= MAX_ALTITUDE) {
			this.altitudeOfFlight = altitudeOfFlight;
			return true;
		}
		return false;
	}

	public String specificSound() {
		return "Clack-wack-chack";

	}

	@Override
	public String toString() {
		return super.toString() + "\nFlight altitude: " + this.getAltitudeOfFlight() + "\n";
	}

	@Override
	public void loadImages(String nm) {
		try {
			this.img1 = ImageIO.read(new File("src\\images\\eagle" + nm + ".png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}
}
