
package main;

import java.util.Scanner;
import player.Player;
import util.Constraints;


public class THunt {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		Player[] players;
		int nPlayers;
		
		System.out.println("How many players out there? ");
		nPlayers = scan.nextInt();
		if (!Constraints.validateMinimumPlayers(nPlayers)) {
			System.out.println("Sorry... invalid number of players.");
			System.out.println("It should be between " + Constraints.MIN_PLAYERS + " and "
					+ Constraints.MAX_PLAYERS + ".");
			scan.close();
			return;
		}
		
		scan.close();
	}
}