package game;

public class TreasureMap {
	
	/**
	 *  [n] => [
	 *    			[CoordinateMap, CoordinateMap, CoordinateMap],
	 *    			[CoordinateMap, CoordinateMap, CoordinateMap]
	 *  	   ]
	 *  
	 *  [ (0,0), (0,1), (0,2) ]
	 *  [ (1,0), (1,1), (1,2) ]
	 *  [ (2,0), (2,1), (2,2) ]
	 *  
	 *  coordinate[0] ==> [CoordinateMap, CoordinateMap, CoordinateMap]
	 *  coordinate[2] ==> [CoordinateMap, CoordinateMap, CoordinateMap]
	 *  coordinate[0][2] ==> CoordinateMap ==> coordinate[0][2].getRow(); 
	 *  coordinate[2][2] ==> CoordinateMap
	 *  
	 *  
	 *  treasures[] => [(0, 0, 10)  (2, 1, 5) ...]
	 * 
	 * */

	private CoordinateMap[][] coordinates;
	
	public void createMap(int rows, int columns, CoordinateMap[] treasures) {
		this.coordinates = new CoordinateMap[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				this.coordinates[i][j] = new CoordinateMap();
				this.coordinates[i][j].setRow(i);
				this.coordinates[i][j].setColumn(j);
				this.coordinates[i][j].setDug(false);
				this.coordinates[i][j].setTreasure(0);
			}
		}
		for(int i = 0; i < treasures.length; i++) {
			this.coordinates[treasures[i].getRow()][treasures[i].getColumn()].setTreasure(
					treasures[i].getTreasure()
			);
		}
	}
	
	public void drawMap() {
		// print blank line
		System.out.println();
		
		for(int i = 0; i < Constraints.MAP_COLUMNS; i++) {
			// %4s ---> "   A"
			System.out.format("%4s", Constraints.LABELS[i]);
		}
		
		// print blank line
		System.out.println();
		for(int i = 0; i < this.coordinates.length; i++) {
			
			// print integer with 2 spaces
			System.out.format("%2d", i + 1);
			
			for(int j = 0; j < this.coordinates[i].length; j++) {
				if(this.coordinates[i][j].getDug()) {
					System.out.print(" X  ");
				} else {
					System.out.print(" #  ");
				}
			}
			
			// print blank line
			System.out.println();
		}
		
		// print blank line
		System.out.println();
	}
	
	public boolean isCoordinateDug(int row, int col) {
		return this.coordinates[row][col].getDug();
	}
	
	public void dig(int row, int col) {
		this.coordinates[row][col].setDug(true);
	}
}
