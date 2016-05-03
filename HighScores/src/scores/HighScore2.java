package scores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import utils.Parser;
/**
 * Class allowing to retieve data from ThingSpeak
 * @author Johan Brunet, Julien Gallego
 *
 */
public class HighScore2 {
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
	public HighScore2(String url) {
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
	
	/*
	public BestPlayer[] tenBestScores(String[] readScores){
		BestPlayer[] best=new BestPlayer[10];
		int i=0;
		BestPlayer test;
		boolean place==false;
		for (String s : readScores){
			if (i<10){
				test.score=Parser.parseScore[s];
				test.player=Parser.parseName[s];
				int j=i;
				While (j>-1 && place==false){
					if (test.compareto(best[j])==1 && j==0;){
						best[j+1]=best[j];
						best[j]=test;
					}
					else if (test.compareto(best[j])==1 ){
						best[j+1]=best[j];
						j=j-1;
					}
						else if (test.compareto(best[j]<1){
							best[j+1]=test;
							place=true;
						}	
				}
			}
				
			else{
				test.score=Parser.parseScore[s];
				test.player=Parser.parseName[s];
				int j=9;				
				While (j>-1 && place==false){
					if (test.compareto(best[j])==1 && j==9){
						j=j-1;
					}
					else if (test.compareto(best[j])==1 && j==0){
							best[j+1]=best[j];
							best[j]=test;
						}
						else if (test.compareto(best[j])==1){
							best[j+1]=best[j];
							j=j-1;
						}
							else if (test.compareto(best[j]<1){
								if (j==9)
									place=true;
								else{
									best[j+1]=test;
									place=true;
								}
								
							}	
						
					}
				}
					
			}
		}
		return best;
		
	}
	*/

	public BestPlayer2[] tenBestScores(ArrayList<String> readScores) {
		BestPlayer2[] tenBests = new BestPlayer2[10];
		int i;
		String currentData;
		for(i = 0; i < readScores.size(); i++) {
			currentData = readScores.get(i);
			BestPlayer2 current = new BestPlayer2(Parser.parseName(currentData), Parser.parseScore(currentData));
		}
		return tenBests;
	}
}



