package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Class allowing to retieve data from ThingSpeak
 * @author Johan Brunet, Julien Gallego
 *
 */
public class HighScore1 {
	/**
	 * The lines of data retrieved from ThingSpeak
	 */
	private ArrayList<String> allScores;
	/**
	 * The connection to the ThingSpeak feed
	 */
	private URLConnection connection;
	
	/**
	 * Constructor of the class that instantiates the list of lines of data 
	 * and opens the connection to ThingSpeak feed
	 * @param url the URL to connect to
	 */
	public HighScore1(String url) {
		this.allScores = new ArrayList<String>();
		openConnection(url);
	}
	
	/**
	 * Method to retrieve data for the ThingSpeak feed
	 * @return the list containing the lines of data retrieved from ThingSpeak
	 */
	public ArrayList<String> getScores() {
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(this.connection.getInputStream()));
			String inputLine;
			buffer.readLine();
			String phantomLine = "";
			while ((inputLine = buffer.readLine()) != null) {
				if (!inputLine.equals(phantomLine)) {
					allScores.add(inputLine);
				}
			}
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return allScores;
	}
	
	/**
	 * Method that opens the connection to the ThingSpeak feed
	 * @param url the URL to connect to
	 */
	private void openConnection(String url) {
		try {
			this.connection = new URL(url).openConnection();
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
