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
public class Whale extends WaterAnimal{


	private String foodType;
	/**
	 * Whale constructor using parameters
	 * @param position - the current location of the animal
	 * @param name - the name of the animal
	 * @param gender - the gender of the animal
	 * @param weight - the weight of the animal
	 * @param speed - the speed of the animal
	 * @param diveDept - the animal diving depth
	 * @param foodType - whale type of food
	 * @param medals - the set of medals of the animal
	 */
	public Whale(String name, Gender gender, double weight, double speed, double diveDept,String foodType,Medal[] medals,int maxEnergy) {
		super(name, gender, weight, speed, diveDept, medals, maxEnergy);
		this.setFoodType(foodType);
		this.type = "Whale";
		 
	}
	public Whale() {
		super();
		this.setFoodType("fish");
		this.type = "Whale";
		 
	}
	/**
	 * @return the foodType
	 */
	public String getFoodType() {
		return foodType;
	}
	/**
	 * @param foodType the foodType to set
	 */
	public boolean setFoodType(String foodType) {
		
		if(foodType!=null)
		{
			this.foodType = foodType;
			return true;
		}
		return false;
	
	}
	public String specificSound()
	{
		return "Splash";
		
	}
	@Override
	public void loadImages(String nm) {
		try {
			this.img1 = ImageIO.read(new File("src\\images\\whale" + nm + "E.png"));
		} catch (IOException e) {
			System.out.println("Cannot load image");
		}
	}
	@Override
	public String toString() {
		return super.toString() + "\nType of food: " + this.getFoodType();
	}

	

}
