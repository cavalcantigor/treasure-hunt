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
				this.coordinates[i][j].setDigged(false);
			}
		}
		for(int i = 0; i < treasures.length; i++) {
			this.coordinates[treasures[i].getRow()][treasures[i].getColumn()].setTreasure(
					treasures[i].getTreasure()
			);
		}
	}
	
	public void drawMap() {
		System.out.println("A   B   C   D   E   F   G");
		for(int i = 0; i < this.coordinates.length; i++) {
			for(int j = 0; j < this.coordinates[i].length; j++) {
				if(this.coordinates[i][j].getDigged()) {
					System.out.println(" X ");
				} else {
					System.out.println("   ");
				}
			}
		}
	}
}
