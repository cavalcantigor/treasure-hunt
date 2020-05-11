package game;

public class TreasureMap {
	
	private CoordinateMap[][] coordinates;
	
	public void createMap(int rows, int columns, CoordinateMap[] treasures) {
		this.coordinates = new CoordinateMap[rows][columns];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				this.coordinates[i][j] = new CoordinateMap();
				this.coordinates[i][j].setRow(i);
				this.coordinates[i][j].setColumn(j);
				this.coordinates[i][j].setDug(false);
				this.coordinates[i][j].setTreasure(false);
			}
		}
		for(int i = 0; i < treasures.length; i++) {
			this.coordinates[treasures[i].getRow()][treasures[i].getColumn()].setTreasure(
					true
			);
		}
	}
	
	public void drawMap() {
		// print blank line
		System.out.println();
		
		for(int i = 0; i < Constraints.MAP_COLUMNS; i++) {
			// %4s ---> "   A"
			System.out.print(" ");
			System.out.format("%5s", Constraints.LABELS[i]);
		}
		
		// print blank line
		System.out.println();
		for(int i = 0; i < this.coordinates.length; i++) {
			
			// print integer with 2 spaces
			System.out.format("%2d", i + 1);
			
			for(int j = 0; j < this.coordinates[i].length; j++) {
				if(this.coordinates[i][j].getDug()) {
					System.out.print("   X  ");
				} else {
					System.out.print("   -  ");
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
	
	public boolean hasTreasure(int row, int col) {
		return this.coordinates[row][col].getTreasure();
	}
	
	public boolean dig(int row, int col) {
		boolean hasTreasure = this.hasTreasure(row, col);
		
		if(hasTreasure) {
			this.coordinates[row][col].setTreasure(false);
		}
		this.coordinates[row][col].setDug(true);
		
		return hasTreasure;
	}
}
