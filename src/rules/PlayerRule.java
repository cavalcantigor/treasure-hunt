package rules;

import java.util.Random;
import java.util.Scanner;

import game.Constraints;
import game.Player;

/** 
 * Manage all player rules.
 * @author Cassio Towesend
 * @version 1.0
*/
public class PlayerRule {
	
	/**
	 * Validate number of players input from user.
	 * until read a valid data (only integers).
	 * @param scan object scanner that reads data from user.
	 * @return integer that represents the number of players. 
	 * */
	public static int validateNPlayers(Scanner scan) {
		int n = 0;
		
		// until a valid number of player is read
		while(true) {
			System.out.println("How many players out there? ");
			
			// read number of players data (string) and parse to integer
			n = Integer.valueOf(scan.nextLine());
			
			// check if number of players is valid
			if (n < Constraints.MIN_PLAYERS || n > Constraints.MAX_PLAYERS) {
				System.out.println("Invalid data! Number of players should be between " + 
						Constraints.MIN_PLAYERS + " and " + Constraints.MAX_PLAYERS);
				System.out.println("Please, re-enter players...");
			} else {
				
				// if number of players is valid, then breaks loop
				break;
			}
		}
		return n;
	}
	
	/**
	 * Validate name and surname input from user.
	 * @param scan object scanner that reads data from user.
	 * @param player the player that should receive name read.
	 * @param i the integer that represents the array position of player. 
	 * */
	public static void validatePlayerName(Scanner scan, Player player, int i) {
		String name;
		
		// infinite loop
		while(true) {
			// reading name property from i'th player
			System.out.println("[Player " + i + "] Whats your name? ");
			name = scan.nextLine(); // reading name and surname
			
			// split by regular expression "blank space" and generate an array of Strings
			if (name.split("\\s+").length == 1) {
				System.out.println("Invalid data! Should enter name and surname");
				System.out.println("Please, re-enter name and surname...");
			} else {
				// when length name is more than 1, then breaks while loop
				break;
			}
		}
		
		// set player name
		player.setName(name.split("\\s+")[0]);
		
		// set player surname
		player.setSurname(name.split("\\s+")[1]);
	}
	
	/**
	 * Validate age input from user.
	 * @param scan object scanner that reads data from user.
	 * @param player the player that should receive read age. 
	 * */
	public static void validatePlayerAge(Scanner scan, Player player) {
		int age;		// player age to be read
		
		// infinite loop
		while(true) {
			System.out.println(player.getName() + ", what's your age? ");
			
			// reading age property from i'th player
			age = Integer.valueOf(scan.nextLine()); // reading player age
			
			// check if age is valid
			if (age < Constraints.MIN_PLAYER_AGE) {
				System.out.println("Invalid data! Age should be greater or equal " + Constraints.MIN_PLAYER_AGE);
				System.out.println("Please, re-enter age...");
			} else {
				// if age is valid, then breaks loop
				break;
			}
		}
		
		// set player age
		player.setAge(age);
	}
	
	/**
	 * Validate the random dig points distributed among the players.
	 * @param scan object scanner that reads data from user.
	 * @param player the player that should receive randomly generated dig points. 
	 * */
	public static void validatePlayerDigPoints(Scanner scan, Player player) {
		// instantiate object Random to generate random numbers
		Random r = new Random();
		
		// generate random numbers between max (inclusive) and min (inclusive)
		int digPoints = r.nextInt(
				Constraints.MAX_PLAYER_DIG_POINTS - Constraints.MIN_PLAYER_DIG_POINTS
		) + Constraints.MIN_PLAYER_DIG_POINTS;
		
		// set dig point to player
		player.setDigPoints(digPoints);
		
		// set pirate points
		player.setPiratePoints(
				Constraints.PIRATE_POINTS - (Constraints.DIG_POINTS_MULTIPLIER * player.getDigPoints()) 
		);
	}
}
