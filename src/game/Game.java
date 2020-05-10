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
		CoordinateMap[] treasures = new CoordinateMap[1];
		treasures[0] = new CoordinateMap(0, 0, 25);

		this.map.createMap(Constraints.MAP_ROWS, Constraints.MAP_COLUMNS, treasures);
		
		while(true) {
			for(int i = 0; i < this.players.length; i++) {
				this.map.drawMap();
				System.out.println("Argh..Pirate " + players[i].getName() + 
						"...it be your turn to dig for me treasure.");
				move(this.players[i]);
			}
		}
	}
	
	public void move(Player player) {
		int rowCoordinate;
		int colCoordinate;
		
		while(true) {
			rowCoordinate = GameRule.validateRowMove(this.scan, player);
			colCoordinate = GameRule.validateColMove(this.scan, player);
			
			if(this.map.isCoordinateDug(rowCoordinate - 1, colCoordinate - 1)) {
				System.out.println("Sorry... you cannot 'dig' in the same place more than once.");
				System.out.println("Please, re-enter coordinates...");
			} else {
				this.map.dig(rowCoordinate - 1, colCoordinate - 1);
				break;
			}
		}
	}
}
