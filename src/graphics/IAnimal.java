package graphics;

public interface IAnimal {
	/**
	 * this method promote the user to enter an integer value for the animal to eat
	 * @param energy - the energy amount the user wants to add to the animal
	 * @return true for success, false otherwise
	 */
	public boolean eat(int energy);

}
