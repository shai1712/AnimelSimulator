/**
 * 
 */
package system;

import java.util.Scanner;

import animals.Animal;
import animals.AnimalCreator;

/**
 * @author Shai Shitrit 307874065 & Amit Amir 311527329
 *
 */
public class MenuCreator {

	/**
	 * a side class to create the menu
	 */
	public MenuCreator() {
	}

	/**
	 * A side method to create the Air Animals promote menu
	 * 
	 * @param input - the Scanner object from the Main makeMenu method
	 * @return an Animal object
	 */
	private static Animal makeAirAnimalMenu(Scanner input) {
		String firstSelection = "Air Animal";
		String secondSelection;
		int n;
		do {
			System.out.println("Please enter a number(1-2) that match your selection from the following options:");
			System.out.println("1. Pigeon\n2. Eagle");
			n = input.nextInt();
			switch (n) {
			case 1:
				secondSelection = "Pigeon";
				return AnimalCreator.makeAnimal(firstSelection, secondSelection);
			case 2:
				secondSelection = "Eagle";
				return AnimalCreator.makeAnimal(firstSelection, secondSelection);
			}
		} while (n < 1 || n > 2);
		return null;
	}
	private static Animal makeWaterAnimalMenu(Scanner input) {
		String firstSelection = "Water Animal";
		String secondSelection;
		int n;
		do {
			System.out.println("Please enter a number(1-3) that match your selection from the following options:");
			System.out.println("1. Dolphin\n2. Alligator\n3. Whale");
			n = input.nextInt();
			switch (n) {
			case 1:
				secondSelection = "Dolphin";
				return AnimalCreator.makeAnimal(firstSelection, secondSelection);
			case 2:
				secondSelection = "Alligator";
				return AnimalCreator.makeAnimal(firstSelection, secondSelection);
			case 3:
				secondSelection = "Whale";
				return AnimalCreator.makeAnimal(firstSelection, secondSelection);
			}
		} while (n < 1 || n > 3);
		return null;
	}

	private static Animal makeTerrAnimalMenu(Scanner input) {
		String firstSelection = "Terrestrial Animal";
		String secondSelection;
		int n;
		do {
			System.out.println("Please enter a number(1-3) that match your selection from the following options:");
			System.out.println("1. Dog\n2. Cat\n3. Snake");
			n = input.nextInt();
			switch (n) {
			case 1:
				secondSelection = "Dog";
				return AnimalCreator.makeAnimal(firstSelection, secondSelection);
			case 2:
				secondSelection = "Cat";
				return AnimalCreator.makeAnimal(firstSelection, secondSelection);
			case 3:
				secondSelection = "Snake";
				return AnimalCreator.makeAnimal(firstSelection, secondSelection);
			}
		} while (n < 1 || n > 3);
		return null;
	}

	private static Animal[] makeAnimalMenu(Scanner input) {
		System.out.println("Enter number of animals: ");
		int size = input.nextInt();
		Animal[] animals = new Animal[size];
		for (int i = 0; i < animals.length; i++) {
			int n = 0;
			do {
				System.out.println("Please enter a number(1-3) that match your selection from the following options:");
				System.out.println("1. Air Animals\n2. Water Animal\n3. Terrestrial Animals");
				n = input.nextInt();
				switch (n) {
				case 1:
					animals[i] = makeAirAnimalMenu(input);
					break;
				case 2:
					animals[i] = makeWaterAnimalMenu(input);
					break;

				case 3:
					animals[i] = makeTerrAnimalMenu(input);
					break;
				}

			} while (n < 1 || n > 3);
		}
		return animals;
	}

	public static void makeMenu() {
		Scanner input = new Scanner(System.in);
		Animal[] animals = makeAnimalMenu(input);
		int selection = 0;
		do {

			System.out.println("1. animal details\n2. make sound\n3. exit");
			selection = input.nextInt();
			switch (selection) {

			case 1:
				for (int i = 0; i < animals.length; i++) {
					System.out.println(animals[i].toString() + "\n");
				}
				break;
			case 2:
				for (int i = 0; i < animals.length; i++) {
					animals[i].makeSound();
				}

				break;
			case 3:

				break;
			default:
				break;

			}

		} while (selection != 3);

		input.close();
	}
}
