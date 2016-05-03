package scores;

public class BestPlayer2 {
	private String playerName;
	private int score;
	
	
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


	public String getPlayer() {
		return playerName;
	}


	public void setPlayer(String player) {
		this.playerName = player;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
