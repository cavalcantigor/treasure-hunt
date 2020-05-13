package game;

import java.util.List;

/** 
 * Represents a treasure map.
 * @author Cassio Towesend
 * @version 1.0
*/
public class TreasureMap {
	
	private CoordinateMap[][] coordinates;			// matrix of coordinates that composes a map 

	/**
	 * Method that creates a new map and fill all coordinates.
	 * @param row integer that indicates the number of map rows
	 * @param row integer that indicates the number of map columns
	 * @param row CoordinateMap array of treasure locations
	 * */
	public void createMap(int rows, int columns, List<CoordinateMap> treasures) {
		
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
		for(int i = 0; i < treasures.size(); i++) {
			
			// for each treasure, set treasure as true on map
			this.coordinates[treasures.get(i).getRow()][treasures.get(i).getColumn()].setTreasure(
					true
			);
		}
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
	 * Method that dig a coordinate.
	 * @param row integer that represents row map
	 * @param row integer that represents column map
	 * */
	public void dig(int row, int col) {
		this.coordinates[row][col].setDug(true);
	}
	
	public CoordinateMap[][] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(CoordinateMap[][] coordinates) {
		this.coordinates = coordinates;
	}
	
}
