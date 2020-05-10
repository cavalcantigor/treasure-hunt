package rules;

import java.util.Scanner;

import game.Constraints;
import game.Player;

public class GameRule {
	
	public static int validateRowMove(Scanner scan, Player player) {
		int row;
		String rangeRow = "1-" + Constraints.MAP_ROWS;
		
		// infinite loop
		while(true) {
			System.out.println("Enter row coordinate [" + rangeRow + "]: ");
			row = Integer.valueOf(scan.nextLine());
			
			if (row > Constraints.MAP_ROWS || row < 0) {
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
	
}
