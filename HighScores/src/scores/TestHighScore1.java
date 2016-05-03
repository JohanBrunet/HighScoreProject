package scores;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import utils.Parser;

/**
 * Main class for running the application
 * @author Johan Brunet, Julien Gallego
 *
 */
public class TestHighScore1 {
	/**
	 * The ThingSpeak URL to connect to in order to retrieve data
	 */
	public static final String THINGSPEAK_URL = "https://api.thingspeak.com/channels/109692/feeds.csv";
	
	/**
	 * Main of the application
	 * @param args some arguments
	 */
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
		ArrayList<String> dataToParse = new ArrayList<String>(highScore.getScores());
		ArrayList<Integer> scores = new ArrayList<Integer>();
		for (String s : dataToParse) {
			scores.add(Parser.parseScore(s));
		}
		score = scores.get(getRandInt(scores.size()));
		
		System.out.println("Player : " + playerName);
		System.out.println("Score : " + score);
	}
	
	/**
	 * Method to get a random integer between 0 and the specified bound
	 * @param bound maximum value of the random integer
	 * @return a random integer between 0 and the bound
	 */
	private static int getRandInt(int bound) {
		Random rand = new Random();
		return (int)(rand.nextInt(bound));
	}
}
