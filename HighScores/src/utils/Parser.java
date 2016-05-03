package utils;

/**
 * Class containing methods to parse the result lines retrieved from ThingSpeak
 * @author Johan Brunet, Julien Gallego
 *
 */
public class Parser {

	/**
	 * Parsing method that parses the line to retrieve the score value
	 * @param s the line to parse
	 * @return the score value
	 */
	public static int parseScore(String s) {
		String[] parse = s.split(",");
		return Integer.parseInt(parse[2]);
	}

	public static String parseName(String s) {
		String[] parse = s.split(",");
		return parse[3];
	}
}
