package scores;

public class BestPlayer2 {
	private String name;
	private int score;
	
	public BestPlayer2(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public int compareTo(BestPlayer2 p){
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
