
package main;

import java.util.Scanner;

import game.Constraints;
import game.CoordinateMap;
import game.Player;
import game.TreasureMap;
import rules.PlayerRule;


public class THunt {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int nPlayers = 0;
		Player[] players;
		TreasureMap map = new TreasureMap();
		
		nPlayers = PlayerRule.validateNPlayers(scan);
		players = new Player[nPlayers];
		for(int i = 0; i < nPlayers; i++) {
			players[i] = new Player();
			PlayerRule.validatePlayerName(scan, players[i], i + 1);
			PlayerRule.validatePlayerAge(scan, players[i]);
		}
		
		CoordinateMap[] treasures = new CoordinateMap[1];
		treasures[0] = new CoordinateMap(0, 0, 25);

		map.createMap(Constraints.MAP_ROWS, Constraints.MAP_COLUMNS, treasures);
		map.drawMap();
		
		scan.close();
	}
}
