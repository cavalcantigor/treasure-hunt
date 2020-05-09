package rules;

import java.util.Random;
import java.util.Scanner;

import game.Constraints;
import game.Player;

public class PlayerRule {
	
	public static int validateNPlayers(Scanner scan) {
		int n = 0;
		while(true) {
			System.out.println("How many players out there? ");
			n = Integer.valueOf(scan.nextLine());
			if (n < Constraints.MIN_PLAYERS || n > Constraints.MAX_PLAYERS) {
				System.out.println("Invalid data! Number of players should be between " + 
						Constraints.MIN_PLAYERS + " and " + Constraints.MAX_PLAYERS);
				System.out.println("Please, re-enter players...");
			} else {
				break;
			}
		}
		return n;
	}
	
	public static void validatePlayerName(Scanner scan, Player player, int i) {
		String name;
		
		// infinite loop
		while(true) {
			// reading name property from i'th player
			System.out.println("[Player " + i + "] Whats your name? ");
			name = scan.nextLine(); // reading name and surname
			
			// split by regex "blank space" and generate an array of Strings
			if (name.split("\\s+").length == 1) {
				System.out.println("Invalid data! Should enter name and surname");
				System.out.println("Please, re-enter name and surname...");
			} else {
				// when length name is more than 1, then breaks while loop
				break;
			}
		}
		player.setName(name);
	}
	
	public static void validatePlayerAge(Scanner scan, Player player, int i) {
		int age;
		
		// infinite loop
		while(true) {
			// reading age property from i'th player
			System.out.println(player.getName() + ", what's your age? ");
			age = Integer.valueOf(scan.nextLine()); // reading player age
			
			if (age < Constraints.MIN_PLAYER_AGE) {
				System.out.println("Invalid data! Age should be greater or equal " + Constraints.MIN_PLAYER_AGE);
				System.out.println("Please, re-enter age...");
			} else {
				break;
			}
		}
		player.setAge(age);
	}
	
	public static void validatePlayerDigPoints(Scanner scan, Player player) {
		// instantiate object random to generate random numbers
		Random r = new Random();
		
		// generate random numbers between max (inclusive) and min (inclusive)
		int digPoints = r.nextInt(Constraints.MAX_PLAYER_DIG_POINTS + 1) + Constraints.MIN_PLAYER_DIG_POINTS;
		
		// set dig point to player
		player.setDigPoints(digPoints);
		
		// set pirate points
		player.setPiratePoints(
				Constraints.PIRATE_POINTS - (Constraints.DIG_POINTS_MULTIPLIER * player.getDigPoints()) 
		);
	}
}
