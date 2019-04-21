package lab02;

public class CrapsMetricsMonitor {
	
	private int gPlayed=0;
	private int gWon=0;
	private int gLost=0;
	private int maxRolls=0;
	private int nCount=0;
	private int cCount=0;
	private int wStreak=0;
	private int maxWStreak = 0;
	private int lStreak=0;
	private int maxLStreak = 0;
	private int balance=0;
	private int maxGame = 0;
	private int maxBalance = 0;
	private boolean wonLast = false;
	private boolean lostLast = false;
	
	public CrapsMetricsMonitor() {
		
	}	
	
	public void printStatistics() {
		System.out.println("\n");
		System.out.println("*****************************");
		System.out.println("*** SIMULATION STATISTICS ***");
		System.out.println("*****************************");
		System.out.println("Games played: " + gPlayed);
		System.out.println("Games won: " + gWon);
		System.out.println("Games lost: " + gLost);
		System.out.println("Maximum Rolls in a single game: " + maxRolls);
		System.out.println("Natural Count: " + nCount);
		System.out.println("Craps Count: " + cCount);
		System.out.println("Maximum Winning Streak: " + maxWStreak);
		System.out.println("Maximum Losing Streak: " + maxLStreak);
		System.out.println("Maximum balance: " + maxBalance + " during game " + maxGame);
		System.out.println();
	}
	
	public void setBalance(int n) {
		balance = n;
	}
	public int getBalance() {
		return balance;
	}
	public void addBalance(int n) {
		balance += n;
	}
	public void subBalance(int n) {
		balance -= n;
	}
	public void gamePlayed() {
		gPlayed++;
	}
	
	public int gamesPLayed() {
		return gPlayed;
	}
	
	public void gameWon() {	
		gWon++;
	}

	public void gameLost() {	
		gLost++;
	}
	
	public boolean wonLast() {
		return wonLast;
	}
	
	public void incWStreak() {
		wStreak++;
		if (wStreak > maxWStreak) {
			maxWStreak = wStreak;
		}
	}
	
	public void startWStreak() {
		wStreak = 1;
		wonLast = true;
		if (wStreak > maxWStreak) {
			maxWStreak = wStreak;
		}
	}
	public void endWStreak() {
		wStreak = 0;
		wonLast = false;
	}
	
	public boolean lostLast() {
		return lostLast;
	}
	
	public void incLStreak() {
		lStreak++;
		if (lStreak > maxLStreak) {
			maxLStreak = lStreak;
		}
	}
	
	public void startLStreak() {
		lStreak = 1;
		lostLast = true;
		if (lStreak > maxLStreak) {
			maxLStreak = lStreak;
		}
	}
	public void endLStreak() {
		lStreak = 0;
		lostLast = false;
	}
	
	public void UpdateMaxRolls(int n) {
		if (n > maxRolls) {
			maxRolls = n;
		}
	}
	
	public void incNatural() {
		nCount++;
	}
	public void incCraps() {
		cCount++;
	}
	
	public void updateMaxBalance(int n) {
		if ( n >= maxBalance) {
			maxBalance = n;
			maxGame = gPlayed;
		}
	}
	
	public void reset() {
		gPlayed = 0;
		gWon = 0;
		gLost = 0;
		maxRolls = 0;
		nCount = 0;
		cCount = 0;
		wStreak = 0;
		lStreak = 0;
		balance = 0;
		maxBalance = 0;
		maxGame = 0;
	}
	
}
