package game;

/** 
 * Represents a treasure map.
 * @author Cassio Towesend
 * @version 1.0
 * @since 1.0
*/
public class TreasureMap {
	
	private CoordinateMap[][] coordinates;			// matrix of coordinates that composes a map 
	
	/**
	 * Method that creates a new map and fill all coordinates.
	 * @param row integer that indicates the number of map rows
	 * @param row integer that indicates the number of map columns
	 * @param row CoordinateMap array of treasure locations
	 * */
	public void createMap(int rows, int columns, CoordinateMap[] treasures) {
		
		// instantiate a new coordinate map matrix
		this.coordinates = new CoordinateMap[rows][columns];
		
		// travel map rows
		for(int i = 0; i < rows; i++) {
			
			// travel map columns
			for(int j = 0; j < columns; j++) {
				this.coordinates[i][j] = new CoordinateMap();
				this.coordinates[i][j].setRow(i);
				this.coordinates[i][j].setColumn(j);
				this.coordinates[i][j].setDug(false);
				this.coordinates[i][j].setTreasure(false);
			}
		}
		
		// travel treasures
		for(int i = 0; i < treasures.length; i++) {
			
			// for each treasure, set treasure as true on map
			this.coordinates[treasures[i].getRow()][treasures[i].getColumn()].setTreasure(
					true
			);
		}
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
		for(int i = 0; i < this.coordinates.length; i++) {
			
			// print row label
			System.out.format("%2d  ", i + 1);
			
			// travel map columns
			for(int j = 0; j < this.coordinates[i].length; j++) {
				
				// if coordinate is dug
				if(this.coordinates[i][j].getDug()) {
					
					// print dug place
					System.out.print("| X ");
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
	 * Method that checks if a coordinate is already dug.
	 * @param row integer that represents row map
	 * @param row integer that represents column map
	 * @return true if coordinate is already dug; false otherwise
	 * */
	public boolean isCoordinateDug(int row, int col) {
		return this.coordinates[row][col].getDug();
	}
	
	/**
	 * Method that checks if a coordinate has treasure.
	 * @param row integer that represents row map
	 * @param row integer that represents column map
	 * @return true if coordinate has a treasure; false otherwise
	 * */
	public boolean hasTreasure(int row, int col) {
		return this.coordinates[row][col].getTreasure();
	}
	
	/**
	 * Method that checks, dig a coordinate and collects a treasure.
	 * @param row integer that represents row map
	 * @param row integer that represents column map
	 * @return true if dig has collected treasure; false otherwise
	 * */
	public boolean dig(int row, int col) {
		boolean hasTreasure = this.hasTreasure(row, col);
		
		if(hasTreasure) {
			this.coordinates[row][col].setTreasure(false);
		}
		this.coordinates[row][col].setDug(true);
		
		return hasTreasure;
	}
}
