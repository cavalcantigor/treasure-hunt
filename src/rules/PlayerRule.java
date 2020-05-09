package rules;

import java.util.Scanner;

import game.Constraints;
import game.Player;

public class PlayerRule {
	
	public static int validateNPlayers(Scanner scan) {
		int n = 0;
		while(true) {
			System.out.println("How many players out there? ");
			n = scan.nextInt();
			if (n < Constraints.MIN_PLAYERS || n > Constraints.MAX_PLAYERS) {
				System.out.println("Invalid data! Number of players should be between " + 
						Constraints.MIN_PLAYERS + " and " + Constraints.MAX_PLAYERS);
				System.out.println("Please, re-enter data...");
			} else {
				break;
			}
		}
		return n;
	}
	
	public static void validatePlayerName(Scanner scan, Player player, int i) {
		String name; // player name from standard input
		
		// infinite loop
		while(true) {
			// reading name property from i'th player
			System.out.println("[Player " + i + "] Whats your name? ");
			name = scan.nextLine(); // reading name and surname
			
			// split by regex "blank space" and generate an array of Strings
			if (name.split("\\s+").length == 1) {
				System.out.println("Invalid data! Should enter name and surname");
				System.out.println("Please, re-enter data...");
			} else {
				// when length name is more than 1, then breaks while loop
				break;
			}
		}
		player.setName(name);
	}
}
