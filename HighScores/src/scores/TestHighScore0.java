package scores;

import java.util.Scanner;

public class TestHighScore0 {

	public static void main(String[] args) {
		String playerName;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("> Please enter a player name");
		if (scan.hasNext()) {
			playerName = scan.nextLine();
		}
		else {
			playerName = "default";
		}
		scan.close();
		System.out.println("Player : " + playerName);
	}
}
