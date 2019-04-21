package lab02;

import java.util.Scanner;

public class CrapsSimulation {
	
	private String name;
	private int balance;
	private int bet = 1001;
	private CrapsGame game;
	private CrapsMetricsMonitor monitor;
	private boolean keepPlaying = true;
	
	public CrapsSimulation() {
		monitor = new CrapsMetricsMonitor();
		game  = new CrapsGame(monitor);
	}
	public void start() {
		
		while(keepPlaying) {
		
			Scanner reader = new Scanner(System.in);
			System.out.print("Welcome to SimCraps! ");
			System.out.print("Enter your user name: ");
			name = reader.nextLine();
			
			//check name
			while ((name.contains(" "))){
				System.out.print("Invalid username! ");
				System.out.print("Enter your user name: ");
				name = reader.nextLine();
			}
			
			System.out.println("Hello " + name + "!");
			System.out.print("Enter the amount of money you will bring to the table: ");
			balance = reader.nextInt();
			monitor.setBalance(balance);
		
			//check bet
			while (bet > 1000 || bet < 1) {
				System.out.print("Enter the bet amount between $1 and $1000: ");
				bet = reader.nextInt();
				if (bet > 1000 || bet < 1) {
					System.out.print("Invalid bet! ");
				}
			}
			
			//keep track of original bet
			int OGbet = bet;
			
			while (monitor.getBalance() > 0) {
				monitor.gamePlayed();
				
				//System.out.println("GAME: " + monitor.gamesPLayed());
				
				System.out.println(name + " bets $" + bet);
				
				//updates maxBalance
				monitor.updateMaxBalance(monitor.getBalance());
				
				//if win
				if (game.playGame()) {
					if(game.getNumRolls() == 1) {
						monitor.incNatural();
						System.out.println("*****Natural! You win!*****");
					}else {
						System.out.println("*****Rolled the point! You win!*****");
					}
					monitor.addBalance(bet);
					monitor.gameWon();
					monitor.endLStreak();
					
					if (monitor.wonLast()) {
						monitor.incWStreak();
					}else {
						monitor.startWStreak();
					}
					
				//if lose
				}else {
					if (game.getNumRolls() == 1) {
						monitor.incCraps();
						System.out.println("*****Craps! You loose.*****");
					}else {
						System.out.println("*****Crap out! You loose.*****");
					}
					monitor.subBalance(bet);
					monitor.gameLost();
					monitor.endWStreak();
					
					if (monitor.lostLast()) {
						monitor.incLStreak();
					}else {
						monitor.startLStreak();
					}
				}
				
				//updates maxRolls
				monitor.UpdateMaxRolls(game.getNumRolls());
				
				
				//updates bet amount
				if (OGbet > monitor.getBalance()) {
					bet = monitor.getBalance();
				}
				if (OGbet < monitor.getBalance()) {
					bet = OGbet;
				}
				
				if (monitor.getBalance() != 0) {
					
					System.out.println(name + "'s balance: " + monitor.getBalance() + ". Playing a new game...");
				}
				
				game.reset();
			}
			
			System.out.println(name + "'s balance: $" + monitor.getBalance());
			
			monitor.printStatistics();
			
			System.out.print("Replay? Enter 'y' or 'n': ");
			String i = reader.next();
	
			//checks invalid input
			String check = "YyNn";
			while (i.length() != 1 || !(check.contains(i))) {
				System.out.println("Invalid input! ");
				System.out.print("Replay? Enter 'y' or 'n': ");
				i = reader.next();
			}
			
			//checks if game continues
			String yes = "Yy";
			String no = "Nn";
			if (yes.contains(i)) {
				keepPlaying = true;
				monitor.reset();
			}else if (no.contains(i)) {
				keepPlaying = false;
				reader.close();
			}
	
			System.out.println();
			
		}
	}

}
