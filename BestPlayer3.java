package scores;

/**
 * Class representing the best player
 * @author Johan Brunet, Julien Gallego
 *
 */
public class BestPlayer3 implements Comparable<BestPlayer3> {
	/**
	 * The name of the best player
	 */
	private String name;
	/**
	 * The name of the best player
	 */
	private int score;
	
	/**
	 * Constructor of the class
	 * @param name the name of the player
	 * @param score the score of the player
	 */
	public BestPlayer3(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	/**
	 * Method to compare the score of the current player to another one
	 * @param p the player to compare to the current one
	 * @return -1 if the current player's score is lesser than the other's, 0 if the scores are equals, 1 in other case
	 */
	public int compareTo(BestPlayer3 p) {
		if (p == null) {
			throw new NullPointerException();
		}
		if (!(p instanceof BestPlayer3)) {
			throw new ClassCastException();
		}
		if (this.score > p.getScore()) {
			return 1;
		}
		else if (this.score == p.getScore()) {
			return 0;
		}
		else {
			return -1;
		}
	}

	public String getName() {
		return name;
	}


	public void setName(String player) {
		this.name = player;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
