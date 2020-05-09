package game;

import java.util.Scanner;

import rules.GameRule;

public class Game {
	private Scanner scan;
	private Player[] players;
	private TreasureMap map;
	
	public Game(Scanner scan, Player[] players, TreasureMap map) {
		this.scan = scan;
		this.players = players;
		this.map = map;
	}
	
	public void runGame() {
		int rowCoordinate;
		int colCoordinate;
		
		this.map.drawMap();
		
		while(true) {
			for(int i = 0; i < this.players.length; i++) {
				System.out.println("Argh..Pirate " + players[i].getName() + 
						"...it be your turn to dig for me treasure.");
				while(true) {
					rowCoordinate = GameRule.validateRowMove(this.scan, this.players[i]);
					colCoordinate = GameRule.validateColMove(this.scan, this.players[i]);
				}
			}
		}
	}
	
}
