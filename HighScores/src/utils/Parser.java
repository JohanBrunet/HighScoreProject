package utils;

public class Parser {

	public static int parseScore(String s) {
		String[] parse = s.split(",");
		int i;
		return Integer.parseInt(parse[2]);
	}
}
