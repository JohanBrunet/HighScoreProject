package scores;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import utils.Parser;

public class BestPlayer2 {
	String player;
	int score;
	public int compareTo(BestPlayer p){
		if (this.score>p.score)
			return 1;
		else if (this.score==p.score)
				 return 0;
			 else return -1;
	}
	}
}
