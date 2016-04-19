package scores;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestHighScore1 {
	public static final String THINGSPEAK_URL = "https://api.thingspeak.com/channels/109692/feeds.csv";
	
	public static void main(String[] args) {
		String playerName;
		int score;
		HighScore1 highScore = new HighScore1(THINGSPEAK_URL);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("> Please enter a player name");
		if (scan.hasNext()) {
			playerName = scan.nextLine();
		}
		else {
			playerName = "default";
		}
		scan.close();
		ArrayList<Integer> scores = new ArrayList<Integer>(highScore.getScores());
		score = scores.get(getRandInt(scores.size()));
		
		System.out.println("Player : " + playerName);
		System.out.println("Score : " + score);
	}
	
	private static int getRandInt(int bound) {
		Random rand = new Random();
		return (int)(rand.nextInt(bound));
	}
}
