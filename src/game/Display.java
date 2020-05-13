package game;

/** 
 * Manages game display content.
 * @author Cassio Towesend
 * @version 1.0
*/
public class Display {
	
	private TreasureMap map;
	private Player[] players;
	
	public Display(TreasureMap map, Player[] players) {
		this.map = map;
		this.players = players;
	}
	
	/**
	 * Method that prints a map on screen.
	 * */
	public void drawMap() {
		// print blank line
		System.out.print("\n   ");
		
		// travel map columns
		for(int i = 0; i < Constraints.MAP_COLUMNS; i++) {
			// prints column labels
			System.out.format("%4s", Constraints.LABELS[i]);
		}
		
		System.out.print("\n    _");
		for(int i = 0; i < Constraints.MAP_COLUMNS; i++) {
			// prints column labels
			System.out.format("%s", "____");
		}
		System.out.println("");
		
		// travel map rows
		for(int i = 0; i < this.map.getCoordinates().length; i++) {
			
			// print row label
			System.out.format("%2d  ", i + 1);
			
			// travel map columns
			for(int j = 0; j < this.map.getCoordinates()[i].length; j++) {
				
				// if coordinate is dug
				if(this.map.isCoordinateDug(i, j)) {
					
					if(this.map.hasTreasure(i, j)) {
						// print dug place with treasure
						System.out.print("| O ");
					} else {
						// print dug place without treasure
						System.out.print("| X ");
					}
				} else {
					
					// print empty place
					System.out.print("|   ");
				}
			}
			
			// print blank line
			System.out.print("|\n");
		}
		
		System.out.print("    ‾");
		for(int i = 0; i < Constraints.MAP_COLUMNS; i++) {
			// prints column labels
			System.out.format("%s", "‾‾‾‾");
		}
		System.out.print("\n");
	}
	
	/**
	 * Method that prints the sequence of players move.
	 * */
	public void printPlayersMoves() {
		
		// iterating over players
		for(int i = 0; i < this.players.length; i++) {
			System.out.print(players[i].getName() + ":");
			
			// iterating over moves
			for(int j = 0; j < this.players[i].getMoves().size(); j++) {
				
				// prints move coordinate
				System.out.print(" "
						+ Constraints.LABELS[this.players[i].getMoves().get(j).getColumn() - 1] 
						+ "" 
						+ this.players[i].getMoves().get(j).getRow()
				);
			}
			System.out.println("");
		}
	}
}
