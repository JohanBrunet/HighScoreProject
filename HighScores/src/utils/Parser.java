package utils;

public class Parser {

	public static int parseScore(String s) {
		int parsedScore;
		String[] parse = s.split(",");
		int i;
		for (i = 0; i < parse.length; i++) {
			System.out.println("Parsed : " + parse[i]);
		}
		System.out.println("Score : " + parse[2]);
		return Integer.parseInt(parse[2]);
	}
}
