package animals;

import java.util.Scanner;

import animals.Animal.Gender;
import animals.Dolphin.WaterType;
import animals.Snake.Poisonous;
import mobility.Point;
import olympics.Medal;

/**
 * @author Shai Shitrit 307874065 & Amit Amir 311527329
 *
 */
public class AnimalCreator {

	/**
	 * default AnimalCreator class constructor
	 */
	public AnimalCreator() {
	}

	/**
	 * this method create the animal object
	 * @param selection1 - the category of the animal the user has selected
	 * @param selection2 - the type of the animal the user has selected
	 * @return - the animal sub-classes object
	 */
	@SuppressWarnings("resource")
	public static Animal makeAnimal(String selection1, String selection2) {
		Scanner input = new Scanner(System.in);
		Medal[] meds = new Medal[1];
		Medal m = new Medal();
		meds[0] = m;
		System.out.println("Enter the Animal Name(free text): ");
		String s = input.nextLine();
		System.out.println("Write the gender(FEMALE,MALE,HERMAPHRODITE):");
		System.out.println(
				"e.g if you want to set the gender to female please write 'female' or 'FEMALE'(without the Apostrophe)");
		String s2 = input.nextLine();
		Gender gen = Gender.valueOf(s2.toUpperCase());
		double w;
		do {
			System.out.println("Enter weight(positive number): ");
			w = input.nextDouble();
		} while (w <= 0);
		double spd;
		do {
			System.out.println("Enter speed(non-negative number): ");
			spd = input.nextDouble();
		} while (spd < 0);
		if (selection1 == "Air Animal") {
			double wingspan;
			do {
				System.out.println("Enter the animal wingspan(positive number): ");
				wingspan = input.nextDouble();
			} while (wingspan <= 0);
			if (selection2 == "Pigeon") {
				System.out.println("Write the pigeon's family(free text): \n");
				String s3 = input.next();
				Pigeon p = new Pigeon(s, gen, w, spd, wingspan, s3, meds, 50);
				return p;
			} else if (selection2 == "Eagle") {
				double alfl;
				do {
					System.out.println("Enter the eagle's flight altitude(positive number):");
					alfl = input.nextDouble();
				} while (alfl <= 0);
				Eagle e = new Eagle(s, gen, w, spd, wingspan, alfl, meds, 100);
				return e;
			}
		} else if (selection1 == "Water Animal") {
			double diveDept;
			do {
				System.out.println("Enter dive depth(negative number): ");
				diveDept = input.nextDouble();
			} while (diveDept >= 0);
			if (selection2 == "Alligator") {
				System.out.println("Write the Alligator area of living(free text): \n");
				String area = input.next();
				Alligator alig = new Alligator(s, gen, w, spd, diveDept, area, meds, 150);
				return alig;
			} else if (selection2 == "Whale") {
				System.out.println("Write the Whale type of food(free text): \n");
				String foodType = input.next();
				Whale wl = new Whale(s, gen, w, spd, diveDept, foodType, meds, 200);
				wl.setLocation(new Point(40, 50));
				return wl;
			} else if (selection2 == "Dolphin") {
				System.out.println("Write the dolphin's type(SEA,SWEET): \n");
				System.out.println(
						"e.g if you want to set the dolphin's type to sea please write 'sea' or 'SEA'(without the Apostrophe)");
				String type = input.next();
				WaterType wt = WaterType.valueOf(type.toUpperCase());
				Dolphin dolp = new Dolphin(s, gen, w, spd, diveDept, wt, meds, 130, (int) spd);
				return dolp;
			}
		} else if (selection1 == "Terrestrial Animal") {
			int nl;
			do {
				System.out.println("Enter number of legs(non-negative number): ");
				nl = input.nextInt();
			} while (nl < 0);
			if (selection2 == "Dog") {
				System.out.println("Write the dog's breed(free text): \n");
				String breed = input.next();
				Dog doggie = new Dog(s, gen, w, spd, nl, breed, meds, 80);
				return doggie;
			} else if (selection2 == "Cat") {
				System.out.println("Is the cat Castrated?(true,false)\n");
				System.out.println(
						"e.g if you want to set that the cat has been castrated please write 'true'(without the Apostrophe)");
				boolean cast = input.nextBoolean();
				Cat kitten = new Cat(s, gen, w, spd, nl, cast, meds, 90);
				return kitten;

			} else if (selection2 == "Snake") {
				System.out.println("Write the snake's toxicity(NONE,LOW,HIGH): \n");
				System.out.println(
						"e.g if you want to set the snake's toxicity to high please write 'high' or 'HIGH'(without the Apostrophe)");
				String toxic = input.next();
				Poisonous poison = Poisonous.valueOf(toxic.toUpperCase());
				double length;
				do {
					System.out.println("enter snake length(positive number): \n");
					length = input.nextDouble();
				} while (length <= 0);
				Snake snk = new Snake(s, gen, w, spd, nl, length, poison, meds, 30);
				return snk;
			}
		}
		return null;
	}
}
