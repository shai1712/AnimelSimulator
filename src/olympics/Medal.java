/**
 * 
 */
package olympics;

/**
 * @author Shai Shitrit 307874065 & Amit Amir 311527329
 *
 */
public class Medal {
	public enum MedalType {
		BRONZE, SILVER, GOLD
	}

	private MedalType type;
	private String tournament;
	private int year;

	/**
	 * Medal constructor using parameters
	 * @param type - the type of the medal(gold, silver, bronze)
	 * @param tour - in what tournament the medal was won(running, swimming, etc..)
	 * @param year - in what year the medal was won
	 */
	public Medal(MedalType type, String tour, int year) {
		this.setType(type);
		this.setTour(tour);
		this.year = year;
	}
	/**
	 * Medal constructor with default values
	 */
	public Medal() {
		this.setType(MedalType.BRONZE);
		this.setTour("Running");
		this.year = 2020;
	}

	/**
	 * 
	 * @return the type of the medal
	 */
	public MedalType getType() {
		return type;
	}

	/**
	 * 
	 * @param type  - the type of the medal to set
	 * @return true for success, false otherwise
	 */
	public boolean setType(MedalType type) {
		if (type == MedalType.BRONZE || type == MedalType.SILVER
				|| type == MedalType.GOLD) {
			this.type = type;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return the tournament
	 */
	public String getTour() {
		return tournament;
	}

	/**
	 * 
	 * @param tour - the tournament to set
	 * @return true for success, false otherwise
	 */
	public boolean setTour(String tour) {
		if (tour != null) {
			this.tournament = tour;
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
//is needed?
	/**
	 * 
	 * @param year - the year to set
	 * @return true;
	 */
	/*
	public boolean setYear(int year) {
		this.year = year;
		return true;
	}*/

	/**
	 * Overriding Object toString.
	 */
	@Override
	public String toString() {
		return "Medal:" + this.getType() + "\nTournament:" + getTour() + "\nYear:" + getYear();
	}
}
