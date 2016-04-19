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

import jdk.management.resource.internal.inst.FileInputStreamRMHooks;

public class TestHighScore0 {
	public static final String  FILE_NAME = "scores/scoreSamples.txt";
	
	public static void main(String[] args) {
		String playerName;
		int score;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("> Please enter a player name");
		if (scan.hasNext()) {
			playerName = scan.nextLine();
		}
		else {
			playerName = "default";
		}
		scan.close();
		
		score = getScore(new File(FILE_NAME));
		
		System.out.println("Player : " + playerName);
		System.out.println("Score : " + score);
	}
	
	private static int getScore(File scores) {
		int score;
		ArrayList<String> allScores = new ArrayList<String>();
		
		try {
			FileInputStream input = new FileInputStream(scores);
			InputStreamReader inread = new InputStreamReader(input);
			BufferedReader buffer = new BufferedReader(inread);
			String ligne;
			while ((ligne=buffer.readLine()) != null) {
				allScores.add(ligne);				
			}
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
	
	private static int getRandInt(int bound) {
		Random rand = new Random();
		return (int)(rand.nextInt(bound));
	}
}
