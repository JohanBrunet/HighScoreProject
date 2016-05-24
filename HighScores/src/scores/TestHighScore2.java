package scores;

import java.util.Scanner;
/**
 * Main class for running the application
 * @author Johan Brunet, Julien Gallego
 *
 */
public class TestHighScore2 {
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
		HighScore2 highScore = new HighScore2(THINGSPEAK_URL);
		BestPlayer2[] top;

		Scanner scan = new Scanner(System.in);
		System.out.println("> Please enter a player name");
		if (scan.hasNext()) {
			playerName = scan.nextLine();
		}
		scan.close();

		top = highScore.tenBestScores(highScore.getScores());

		int i;
		for (i = 0; i < top.length; i++) {
			if(top[i] != null) {
				System.out.println((i+1) + " - " + top[i].getName() + " : " + top[i].getScore());
			}
		}
	}
}