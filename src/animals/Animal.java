/**
 * 
 */
package animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import graphics.CompetitionPanel;
import graphics.IAnimal;
import graphics.IClonable;
import graphics.IDrawable;
import graphics.IMoveable;
import mobility.ILocatable;
import mobility.Mobile;
import mobility.Point;
import olympics.Medal;

/**
 * @author Shai Shitrit 307874065 & Amit Amir 311527329
 *
 */
public abstract class Animal extends Mobile implements IAnimal, ILocatable, IDrawable {
	public enum Gender {
		MALE, FEMALE, HERMAPHRODITE
	}

	public enum Orientation {
		SOUTH, NORTH, WEST, EAST
	}

	private String name;
	private Gender gender;
	private double weight;
	private double speed;
	private Medal[] medals;
	private Point position;
	private int totalEnergyConsumption = 0;

	protected final int size;
	protected Orientation orien;
	protected final int maxEnergy;
	protected int currentEnergy;
	protected int energyPerMeter;
	protected CompetitionPanel pan;
	protected BufferedImage img1, img2, img3, img4;
	protected String type, category;
	private boolean endOfCompetition = false;

	/**
	 * Animal constructor with parameters
	 * 
	 * @param name      - the name of the animal
	 * @param gender    - the gender of the animal
	 * @param weight    - the weight of the animal
	 * @param speed     - the speed of the animal
	 * @param medals    - the set of medals of the animal
	 * @param maxEnergy - the maximum energy value the animal can have
	 */
	public Animal(String name, Gender gender, double weight, double speed, Medal[] medals, int maxEnergy) {
		super(new Point());
		this.setName(name);
		this.setGen(gender);
		this.setWeight(weight);
		this.setSpeed(speed);
		this.setMedal(medals);
		this.maxEnergy = maxEnergy;
		this.currentEnergy = maxEnergy / 2;
		this.setEnergyPerMeter((int) speed);
		this.orien = Orientation.EAST;
		this.size = 65;
	}

	/**
	 * Animal constructor with default values.
	 */
	public Animal() {
		super();
		this.setName("Default");
		this.setGen(Gender.FEMALE);
		this.setWeight(1.0);
		this.setSpeed(2.0);

		this.medals = new Medal[1];
		Medal m = new Medal();
		this.medals[0] = m;
		this.setMedal(this.getMedal());
		this.maxEnergy = 100;
		this.currentEnergy = maxEnergy / 2;
		this.setEnergyPerMeter(2);
		this.orien = Orientation.EAST;
		this.size = 65;
	}

	/**
	 * 
	 * @return the name of the animal
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name the name to set
	 * @return true for success, false otherwise
	 */
	public boolean setName(String name) {
		if (name != null) {
			this.name = name;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return the gender of the animal
	 */
	public Gender getGen() {
		return this.gender;
	}

	/**
	 * 
	 * @param gen the gender to set
	 * @return true for success, false otherwise
	 */
	public boolean setGen(Gender gen) {
		if (gen == Gender.MALE || gen == Gender.HERMAPHRODITE || gen == Gender.FEMALE) {
			this.gender = gen;
			return true;
		}
		return false;
	}

	/**
	 * this method give the Orientation value the Orientation instance has
	 * 
	 * @return - the orientation of the object(EAST,WEST,SOUTH,NORTH)
	 */
	public Orientation getOrientation() {
		return this.orien;
	}

	/**
	 * this method sets the Orientation value for the Orientation instance to the
	 * direction variable value
	 * 
	 * @param direction - the value to set
	 * @return - true if managed to set the value for this, false otherwise
	 */
	public boolean setOrientation(Orientation direction) {
		if (direction == Orientation.EAST || direction != Orientation.WEST || direction != Orientation.SOUTH
				|| direction != Orientation.NORTH) {
			this.orien = direction;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return the weight of the animal
	 */
	public Double getWeight() {
		return this.weight;
	}

	/**
	 * 
	 * @param w the weight to set
	 * @return true for success, false otherwise
	 */
	public boolean setWeight(Double w) {
		if (w > 0) {
			this.weight = w;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return the animal's speed
	 */
	public Double getSpeed() {
		return this.speed;
	}

	/**
	 * 
	 * @param spd - the speed to set
	 * @return true for success, false otherwise
	 */
	public boolean setSpeed(Double spd) {
		if (this instanceof Snake || this instanceof Alligator) {
			if (spd > IReptile.MAX_SPEED || spd < 0)
				return false;
			this.speed = spd;
			return true;
		} else if (spd >= 0) {
			this.speed = spd;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return an array of Medal
	 */
	public Medal[] getMedal() {
		return medals;
	}

	/**
	 * this method prints the medal set the animal has won and used inside toString
	 * method
	 * 
	 * @return - empty string for the toString method
	 */
	public String printMedalSet() {
		for (int i = 0; i < this.medals.length; i++) {
			System.out.println(this.medals[i]);
		}
		return "";
	}

	/**
	 * this method sets the medal set for the animal
	 * 
	 * @param medals - the values to set from
	 * @return true for success, false otherwise
	 */
	public boolean setMedal(Medal[] medals) {
		if (medals != null) {
			this.medals = new Medal[medals.length];
			for (int i = 0; i < medals.length; i++) {
				this.medals[i] = medals[i];
			}
			return true;
		}
		return false;

	}

	/**
	 * this method give the animal's total energy consumption
	 * 
	 * @return the totalEnergyConsumption variable of the animal
	 */
	public int getTotalEnergyConsumption() {
		return totalEnergyConsumption;
	}

	/**
	 * 
	 * @param totalEnergyConsumption the totalEnergyConsumption value to set from
	 * @return true for success, false otherwise
	 */
	public boolean setTotalEnergyConsumption(int totalEnergyConsumption) {
		if (totalEnergyConsumption < 0)
			return false;
		this.totalEnergyConsumption = totalEnergyConsumption;
		return true;
	}

	/**
	 * 
	 * @return the animal energy consumption per meter
	 */
	public int getEnergyPerMeter() {
		return this.energyPerMeter;
	}

	/**
	 * this method returns the animal type(Cat, Dog, Snake, etc..)
	 * 
	 * @return the type of the animal
	 */
	public String getType() {
		return type;
	}

	/**
	 * this method returns the animal type category(Water, Air, Terrestrial)
	 * 
	 * @return the category of the animal
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * this method return the animal max energy value
	 * 
	 * @return the animal's max energy value
	 */
	public int getMaxEnergy() {
		return this.maxEnergy;
	}

	/**
	 * 
	 * @return the current energy amount of the animal
	 */
	public int getCurrentEnergy() {
		return this.currentEnergy;
	}

	/**
	 * this method sets the current energy amount of the animal with the energy
	 * variable values
	 * 
	 * @param energy - the value to set from
	 * @return true for success, false otherwise
	 */
	public boolean setCurrentEnergy(int energy) {
		if (energy > this.getMaxEnergy())
			return false;
		this.currentEnergy = Math.max(0, energy);
		return true;
	}

	/**
	 * epm - Energy per meter
	 * 
	 * @param epm - the value to set
	 * @return true for success, false otherwise.
	 */
	public boolean setEnergyPerMeter(int epm) {
		if (epm <= 0 || epm > maxEnergy)
			return false;
		this.energyPerMeter = epm;
		return true;
	}

	/**
	 * 
	 * @param pan - set the animal panel to pan
	 * @return true for success, false otherwise
	 */
	public boolean setCompetitionPanel(CompetitionPanel pan) {
		if (pan == null)
			return false;
		this.pan = pan;
		return true;
	}

	/**
	 * 
	 * @return the animal panel
	 */
	public CompetitionPanel getCompetitionPanel() {
		return this.pan;
	}

	/**
	 * 
	 * @return the specific sound for each animal
	 */
	public abstract String specificSound();

	/**
	 * a function to call for the specific sound for each animal
	 */
	public void makeSound() {
		System.out.println("Animal " + this.getName() + " said " + this.specificSound() + "\n");
	}

	@Override
	public boolean eat(int energy) {
		if (energy < 0)
			return false;
		this.setCurrentEnergy(Math.min(this.getMaxEnergy(), this.getCurrentEnergy() + energy));
		this.setTotalEnergyConsumption(this.getTotalEnergyConsumption() + Math.min(energy, this.getMaxEnergy()));
		return true;
	}

	/**
	 * this method move the animal from one point to another, it also check if the
	 * animal has sufficient energy amount and that it can continue its movement
	 * 
	 * @param p - the point to move to
	 * @return true for success, false otherwise
	 */
	public boolean animalMove(Point p) {
		double distance = this.move(p);
		if (this.canMove(distance)) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setLocation(p);
			this.addTotalDistance(distance);
			this.setCurrentEnergy(this.getCurrentEnergy() - (this.getEnergyPerMeter() * (int) distance));
			if (this instanceof TerrestrialAnimals) {
				switchImages();
			}
			stopMovement();
		} else
			return false;
		pan.repaint();
		return true;
	}

	/**
	 * this method check if the animal has reached the finish line, if it does, it
	 * sets its endOfCompetition value to true.
	 */
	private void stopMovement() {
		if (this instanceof AirAnimal) {
			if (this.getLocation().getX() >= this.getCompetitionPanel().getWidth() - 120
					&& this.getLocation().getY() == 0) {
				this.endOfCompetition = true;
			}
		} else if (this instanceof WaterAnimal) {
			if (this.getLocation().getX() >= this.getCompetitionPanel().getWidth() - 200) {
				this.endOfCompetition = true;
			}
		} else if (this instanceof TerrestrialAnimals) {
			if (this.getLocation().getX() == 0 && this.getLocation().getY() == 0) {
				this.endOfCompetition = true;
			}
		}
	}

	/**
	 * this method check if the animal has reached the screen corners and adjust its
	 * orientation value accordingly
	 */
	private void switchImages() {
		if (this.getLocation().getX() >= this.getCompetitionPanel().getWidth() - 80 && this.getLocation().getY() == 0) {
			this.setOrientation(Orientation.SOUTH);
		} else if (this.getLocation().getX() >= this.getCompetitionPanel().getWidth() - 80
				&& this.getLocation().getY() >= this.getCompetitionPanel().getHeight() - 80) {
			this.setOrientation(Orientation.WEST);
		} else if (this.getLocation().getX() == 0
				&& this.getLocation().getY() >= this.getCompetitionPanel().getHeight() - 80) {
			this.setOrientation(Orientation.NORTH);
		}

	}

	/**
	 * this method check if the animal can continue its movement, if it has enough
	 * energy, or the animal has reached the finish line
	 * 
	 * @param distance - the distance the animal has to travel for its next location
	 * @return
	 */
	public boolean canMove(double distance) {
		if (this.getCurrentEnergy() < distance || this.getCurrentEnergy() <= 0 || this.endOfCompetition == true)
			return false;
		return true;
	}

	/**
	 * this method sets the animal next location
	 * 
	 * @return
	 */
	public Point nextLocation() {
		Point currentPoint = this.getLocation();
		int x = currentPoint.getX();
		int y = currentPoint.getY();
		if (this.getOrientation() == Orientation.EAST) {
			return new Point(Math.min((int) (x + this.getSpeed()), this.getCompetitionPanel().getWidth() - 80), y);
		} else if (this.getOrientation() == Orientation.SOUTH) {
			return new Point(x, (int) (y + this.getSpeed()));
		} else if (this.getOrientation() == Orientation.WEST) {
			return new Point((int) (x - this.getSpeed()), y);
		} else if (this.getOrientation() == Orientation.NORTH) {
			return new Point(x, (int) (y - this.getSpeed()));
		}
		return currentPoint;
	}

	@Override
	public void drawObject(Graphics g) {
		if (this.getOrientation() == Orientation.EAST) // animal move to the east side
			g.drawImage(img1, this.getLocation().getX(), this.getLocation().getY() - size / 10, size * 2, size, pan);
		else if (this.getOrientation() == Orientation.SOUTH) // animal move to the south side
			g.drawImage(img2, this.getLocation().getX(), this.getLocation().getY() - size / 10, size, size, pan);
		else if (this.getOrientation() == Orientation.WEST) // animal move to the west side
			g.drawImage(img3, this.getLocation().getX(), this.getLocation().getY() - size / 10, size * 2, size, pan);
		else if (this.getOrientation() == Orientation.NORTH) // animal move to the north side
			g.drawImage(img4, this.getLocation().getX() - size / 2, this.getLocation().getY() - size / 10, size,
					size * 2, pan);
	}

	@Override
	public String toString() {
		return super.toString() + "Name: " + this.getName() + "\nGender: " + this.getGen() + "\nWeight: "
				+ this.getWeight() + "\nSpeed: " + this.getSpeed() + this.printMedalSet();
	}

}
