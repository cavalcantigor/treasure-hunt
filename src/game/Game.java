package game;

import java.util.List;
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
	
	public void run() {
		boolean continueGame = true;
		CoordinateMap[] treasures = new CoordinateMap[1];
		treasures[0] = new CoordinateMap(0, 0, true);

		this.map.createMap(Constraints.MAP_ROWS, Constraints.MAP_COLUMNS, treasures);
		
		while(continueGame) {
			for(int i = 0; i < this.players.length; i++) {
				
				System.out.println(players[i].getName() + " turn...");
				
				// if current player has dig points
				if(this.players[i].getDigPoints() > 0) {
					this.map.drawMap(); // draw map

					System.out.println("Argh..Pirate " + players[i].getName() + 
							"...it be your turn to dig for me treasure.");
					
					// current player move
					if(move(this.players[i])) {
						this.players[i].setPiratePoints(
								this.players[i].getPiratePoints() + Constraints.PIRATE_POINTS_BONUS
						);
						System.out.println("Yo-ho-ho and a bottle of rum. I found me some\n" + 
								"pieces of eight.");
					} else {
						System.out.println("Walk the plank! There be no treasure here!");
					}
				} else {
					System.out.println("Argh, Captain,\n" + 
							"me shovel has broken!");
				}
				
				// subtract dig points from current player
				this.players[i].setDigPoints(
						this.players[i].getDigPoints() - Constraints.DIG_POINTS_PENALTY
				);
				
				if(GameRule.isAllTreasureFound(this.map) || GameRule.noDigPointsLeft(this.players)) {
					continueGame = false;
					break;
				}
			}
		}
		
		// end game and celebrate winner(s)
		this.end();
	}
	
	public boolean move(Player player) {
		int rowCoordinate;
		int colCoordinate;
		
		while(true) {
			rowCoordinate = GameRule.validateRowMove(this.scan, player);
			colCoordinate = GameRule.validateColMove(this.scan, player);
			
			if(this.map.isCoordinateDug(rowCoordinate - 1, colCoordinate - 1)) {
				System.out.println("Sorry... you cannot 'dig' in the same place more than once.");
				System.out.println("Please, re-enter coordinates...");
			} else {
				return this.map.dig(rowCoordinate - 1, colCoordinate - 1);
			}
		}
	}
	
	public void end() {
		
		System.out.println("Shiver me Timbers, me hearties, sure hasn’t ");
		
		List<Player> piratePointsWinners = GameRule.getPiratePointsWinner(this.players);
		if(piratePointsWinners.size() > 1) {
			List<Player> digPointsWinners = GameRule.getDigPointsWinner(piratePointsWinners);
			if(digPointsWinners.size() > 1) {
				for(int i = 0; i < digPointsWinners.size(); i++) {
					System.out.print(digPointsWinners.get(i).getName() + " ");
				}
			} else {
				System.out.print(digPointsWinners.get(0).getName() + " ");
			}
		} else {
			System.out.print(piratePointsWinners.get(0).getName() + " ");
		}
		
		System.out.println("won the game. Keelhaul the rest of them!");
	}
}
