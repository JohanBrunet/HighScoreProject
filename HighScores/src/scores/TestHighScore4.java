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
	public static final String THINGSPEAK_FEED_URL = "https://api.thingspeak.com/channels/109693/feeds.csv";
	
	/**
	 * Main of the application
	 * @param args some arguments
	 */
	public static void main(String[] args) {
		String playerName;
		HighScore3 highScore = new HighScore3(THINGSPEAK_FEED_URL);
		BestPlayer3[] top;
		Boolean newStart=true;
		
		Scanner scan = new Scanner(System.in);

		
		
		While(newStart){

		top = highScore.tenBestScores(highScore.getScores());
		int i;
		for (i = 0; i < top.length; i++) {
			if(top[i] != null) {
				System.out.println((i+1) + " - " + top[i].getName() + " : " + top[i].getScore());
			}
		}

		System.out.println("> Do you want to start a new game? write yes or not");	
		if (scan.hasNext()) {
			if (scan.nextLine()=="yes")
				newStart=true;
			else
				newStart=false;
		}
		scan.close();

		if(newStart){
		System.out.println("> Please enter a player name");
		if (scan.hasNext()) {
			playerName = scan.nextLine();
		}
		scan.close();
		
		Random rand = new Random();
		
		
		BestPlayer3 player = top[rand.nextInt(10)];
		player.setName("test");
		player.setScore(player.getScore()*10);
		if (player.getScore()>top[10].getScore()){
			highScore.sendScore(player);
		}
		
		
		}

		}
	}
}
