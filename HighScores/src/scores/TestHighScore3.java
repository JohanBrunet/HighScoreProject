package scores;

import java.util.Random;
import java.util.Scanner;
/**
 * Main class for running the application
 * @author Johan Brunet, Julien Gallego
 *
 */
public class TestHighScore3 {
	/**
	 * The ThingSpeak URL to connect to in order to retrieve data
	 */
	public static final String THINGSPEAK_FEED_URL = "https://api.thingspeak.com/channels/118973/feeds.csv";

	/**
	 * Main of the application
	 * @param args some arguments
	 */
	public static void main(String[] args) {
		HighScore3 highScore = new HighScore3(THINGSPEAK_FEED_URL);
		BestPlayer3[] top;


		System.out.println("> Please enter a player name");
		Scanner scan = new Scanner(System.in);
		String playerName = scan.nextLine();
		scan.close();
		System.out.println("Name : " + playerName);

		Random rand = new Random();

		top = highScore.tenBestScores(highScore.getScores());


		int it;
		for (it = 0; it < top.length; it++) {
			if(top[it] != null) {
				System.out.println((it+1) + " - " + top[it].getName() + " : " + top[it].getScore());
			}
		}

		BestPlayer3 player = top[rand.nextInt(10)];
		player.setName(playerName);
		player.setScore(player.getScore()*5);

		int i = 0;
		boolean toBeSent = false;
		while (!toBeSent && i < top.length && top[i] != null) {
			if (player.getScore() >= top[i].getScore()) {
				toBeSent = true;
			}
			i++;
		}
		if (toBeSent) {
			highScore.sendScore(player);
			System.out.println("The player " + player.getName() + "  is amongst 10 bests and has been sent.");
		}
	}
}
