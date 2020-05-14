package rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.Constraints;
import game.Player;
import game.TreasureMap;

public class GameRule {
	
	public static int validateRowMove(Scanner scan, Player player) {
		int row;
		String rangeRow = "1-" + Constraints.MAP_ROWS;
		
		// infinite loop
		while(true) {
			System.out.println("Enter row coordinate [" + rangeRow + "]: ");
			row = Integer.valueOf(scan.nextLine());
			
			if (row > Constraints.MAP_ROWS || row <= 0) {
				System.out.println("Invalid range!");
				System.out.println("Please, re-enter coordinate...");
			} else {
				break;
			}
		}

		return row;
	}
	
	public static int validateColMove(Scanner scan, Player player) {
		String colCoordinate;
		int col;
		String rangeCol = "A-" + Constraints.LABELS[Constraints.MAP_COLUMNS - 1];
		
		// infinite loop
		while(true) {
			System.out.println("Enter column coordinate [" + rangeCol + "]: ");
			colCoordinate = scan.nextLine();
			
			col = Constraints.transformLabelCoordinate(colCoordinate);
			if(col == -1) {
				System.out.println("Invalid range!");
				System.out.println("Please, re-enter coordinate...");
			} else {
				break;
			}
		}

		return col;
	}
	
	public static boolean isAllTreasureFound(TreasureMap map) {
		for(int i = 0; i < Constraints.MAP_ROWS; i++) {
			for(int j = 0; j < Constraints.MAP_COLUMNS; j++) {
				if (map.hasTreasure(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean noDigPointsLeft(Player[] players) {
		for(int i = 0; i < players.length; i++) {
			if(players[i].getDigPoints() > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static List<Player> getPiratePointsWinner(Player[] players) {
		List<Player> winners = new ArrayList<Player>();
		
		int maxPiratePoints = players[0].getPiratePoints(); 
		winners.add(players[0]);
		
		if (players.length > 1) {
			for(int i = 1; i < players.length; i++) {
				if(players[i].getPiratePoints() > maxPiratePoints) {
					winners.clear();
					winners.add(players[i]);
					maxPiratePoints = players[i].getPiratePoints();
				} else if (players[i].getPiratePoints() == maxPiratePoints) {
					winners.add(players[i]);
				}
			}
		}
		
		return winners;
	}
	
	public static List<Player> getDigPointsWinner(List<Player> players) {
		List<Player> winners = new ArrayList<Player>();
		
		int maxDigPoints = players.get(0).getDigPoints(); 
		winners.add(players.get(0));
		
		if (players.size() > 1) {
			for(int i = 1; i < players.size(); i++) {
				if(players.get(i).getDigPoints() > maxDigPoints) {
					winners.clear();
					winners.add(players.get(i));
					maxDigPoints = players.get(i).getDigPoints();
				} else if (players.get(i).getDigPoints() == maxDigPoints) {
					winners.add(players.get(i));
				}
			}
		}
		
		return winners;
	}
	
}
