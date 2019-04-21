

import java.util.Random;

public class CrapsGame {
	
	private int numRolls = 0;
	private boolean gWon = false;
	Random rand = new Random();
	
	public CrapsGame(CrapsMetricsMonitor monitor) {
		
	}
	
	public boolean playGame() {		
		
		int comeOut = roll();
		
		int point;
		
		if (comeOut == 11 || comeOut == 7) {
			return true;
		}else if (comeOut == 2 ||comeOut == 3||comeOut == 12 ) {
			return false;
		}else {
			point = comeOut;
			
			int nextRoll = roll();
			
			boolean reroll = true;
			
			while (reroll) {
				if (nextRoll == point) {
					return true;
				}else if (nextRoll == 7) {
					return false;
				}
				nextRoll = roll();

			}
			
		}
				
		return gWon;		
	}
	
	//simulate 2 dice roll
	public int roll() {
		
		//first die
		int d1 = rand.nextInt(6);
		d1++;
		//second die
		int d2 = rand.nextInt(6);
		d2++;
		
		numRolls++;
		System.out.println("Rolled a " + (d1+d2));
		return d1+d2;
	}
	
	public int getNumRolls() {
		return numRolls;
	}
	
	//reset
	public void reset() {
		numRolls = 0;
		gWon = false;
	}
}
