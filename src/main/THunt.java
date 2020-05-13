
package main;

import java.util.Scanner;

import game.Game;
import game.Player;
import game.TreasureMap;
import rules.PlayerRule;

/** 
 * Starts application.
 * @author Cassio Towesend
 * @version 1.0
*/
public class THunt {

	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in); 			// scan object to read user input
		int nPlayers = 0;								// number of players in the game
		Player[] players;								// array of objects Player
		TreasureMap map = new TreasureMap();			// instantiate new treasure map object
		
		// input valid number of players
		nPlayers = PlayerRule.validateNPlayers(scan);
		
		// instantiate an array of players
		players = new Player[nPlayers];
		
		// for each player the game should validate name, age and dig points
		for(int i = 0; i < nPlayers; i++) {
			// instantiate a new player
			players[i] = new Player();
			
			// validate player name input
			PlayerRule.validatePlayerName(scan, players[i], i + 1);
			
			// validate player age input
			PlayerRule.validatePlayerAge(scan, players[i]);
			
			// randomly generate dig points to player
			PlayerRule.validatePlayerDigPoints(scan, players[i]);
		}
		
		// instantiate game object
		Game game = new Game(scan, players, map);
		
		// run game -- here the game starts
		game.run();
		
		// closes scan object
		scan.close();
	}
}
