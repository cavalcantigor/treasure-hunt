
package main;

import java.util.Scanner;

import game.Player;
import rules.PlayerRule;


public class THunt {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int nPlayers = 0;
		Player[] players;
		
		nPlayers = PlayerRule.validateNPlayers(scan);
		players = new Player[nPlayers];
		for(int i = 0; i < nPlayers; i++) {
			players[i] = new Player();
			PlayerRule.validatePlayerName(scan, players[i], i + 1);
			PlayerRule.validatePlayerAge(scan, players[i]);
		}
		
		scan.close();
	}
}
