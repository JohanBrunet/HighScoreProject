package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class HighScore1 {
	private ArrayList<String> allScores;
	private String url;
	
	public HighScore1(String url) {
		this.allScores = new ArrayList<String>();
		this.url = url;
	}
	
	public ArrayList<String> getScores() {
		try {
			URL thingSpeak = new URL(this.url);
			URLConnection connect = thingSpeak.openConnection();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(connect.getInputStream()));
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
}
