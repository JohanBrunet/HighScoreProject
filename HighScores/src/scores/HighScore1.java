package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import utils.Parser;

public class HighScore1 {
	private List<Integer> allScores;
	private String url;
	
	public HighScore1(String url) {
		this.allScores = new ArrayList<Integer>();
		this.url = url;
	}
	
	public List<Integer> getScores() {
		try {
			URL thingSpeak = new URL(this.url);
			URLConnection connect = thingSpeak.openConnection();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			String inputLine;
			buffer.readLine();
			while ((inputLine = buffer.readLine()) != null) {
				if (!inputLine.equals("")) {
					System.out.println("Line : " + inputLine);
					allScores.add(Parser.parseScore(inputLine));
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
