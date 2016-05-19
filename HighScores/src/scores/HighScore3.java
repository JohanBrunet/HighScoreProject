package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;

import utils.Parser;
/**
 * Class allowing to retieve data from ThingSpeak
 * @author Johan Brunet, Julien Gallego
 *
 */
public class HighScore3 {
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
	public HighScore3(String url) {
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
			while ((inputLine = buffer.readLine()) != null) {
				if (!inputLine.equals("")) {
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

	public BestPlayer3[] tenBestScores(ArrayList<String> readScores) {
		BestPlayer3[] tenBests = new BestPlayer3[10];
		ArrayList<BestPlayer3> playerRecords = parsePlayers(readScores);
		Collections.sort(playerRecords, Collections.reverseOrder());

		for(int i = 0; i < playerRecords.size() && i < 10; i++) {
			tenBests[i] = playerRecords.get(i);
		}
		return tenBests;
	}
	
	public ArrayList<BestPlayer3> parsePlayers(ArrayList<String> readScores) {
		ArrayList<BestPlayer3> playerRecord = new ArrayList<BestPlayer3>(readScores.size());
		for(String line : readScores) {
			playerRecord.add(new BestPlayer3(Parser.parseName(line), Parser.parseScore(line)));
		}
		return playerRecord;
	}

	public void sendScore(BestPlayer3 p){
        
		try{
            	String nom = p.getName();
            	int score = p.getScore();
            	URL getURL = new URL("https://api.thingspeak.com/update?api_key=6CX6OM3NHAZH6E2U&field1="+score+ "&field3="+nom);
            	HttpURLConnection con = (HttpURLConnection) getURL.openConnection();
            	con.setRequestMethod("GET");
            	con.getResponseCode();
        } 
		catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
        
}
