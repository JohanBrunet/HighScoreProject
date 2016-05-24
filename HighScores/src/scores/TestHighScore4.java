package scores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * Main class for running the application
 * @author Johan Brunet, Julien Gallego
 *
 */
public class TestHighScore4 {
	/**
	 * The ThingSpeak URL to connect to in order to retrieve data
	 */
	public static final String THINGSPEAK_FEED_URL = "https://api.thingspeak.com/channels/118973/feeds.csv";
	public static final String  FILE_NAME = "scores/scoreSamples.txt";

	/**
	 * Main of the application
	 * @param args some arguments
	 */
	public static void main(String[] args) {

		boolean newStart = true;
		Scanner scan = new Scanner(System.in);

		while(newStart) {
			HighScore3 highScore = new HighScore3(THINGSPEAK_FEED_URL);
			BestPlayer3[] top;
			top = highScore.tenBestScores(highScore.getScores());
			int i;
			for (i = 0; i < top.length; i++) {
				if (top[i] != null) {
					System.out.println((i+1) + " - " + top[i].getName() + " : " + top[i].getScore());
				}
			}

			System.out.println("> Do you want to start a new game ? (yes/no)");
			String startAgain = scan.nextLine();
			if (!startAgain.equals("yes")) {
				newStart = false;
			}

			if (newStart){
				System.out.println("> Please enter a player name");
				String playerName = scan.nextLine();

				int score = getScore(new File(FILE_NAME));
				BestPlayer3 player = new BestPlayer3(playerName, score*10);

				int it = 0;
				boolean toBeSent = false;
				while (!toBeSent && it < top.length) {
					if (top[it] == null || player.getScore() >= top[it].getScore()) {
						toBeSent = true;
					}
					it++;
				}
				if (toBeSent) {
					highScore.sendScore(player);
					System.out.println("The player " + player.getName() + "(" + player.getScore() + ")" + "  is amongst 10 bests and has been sent.\n");
				}
				else {
					System.out.println("The player " + player.getName() + "(" + player.getScore() + ")" + "  is not amongst 10 bests and has not been sent.\n");
				}
			}
			try {
				Thread.sleep(10000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		scan.close();
	}

	/**
	 * Get a random score from the score samples
	 * @param scores the file from which to get the scores
	 * @return a random score
	 */
	private static int getScore(File scores) {
		int score;
		ArrayList<String> allScores = new ArrayList<String>();

		try {
			FileInputStream input = new FileInputStream(scores);
			InputStreamReader inread = new InputStreamReader(input);
			BufferedReader buffer = new BufferedReader(inread);
			String ligne;
			while ((ligne = buffer.readLine()) != null) {
				allScores.add(ligne);				
			}
			buffer.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

		score = Integer.parseInt(allScores.get(getRandInt(allScores.size())));
		return score;
	}

	/**
	 * A random int
	 * @param bound higher limit of the random int
	 * @return a random int between 0 and the bound
	 */
	private static int getRandInt(int bound) {
		Random rand = new Random();
		return (int)(rand.nextInt(bound));
	}
}
