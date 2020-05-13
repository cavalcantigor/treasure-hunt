package game;

/** 
 * Represents a coordinate map.
 * @author Cassio Towesend
 * @version 1.0
*/
public class CoordinateMap {

	private int row;				// map row
	private int column;				// map column
	private boolean treasure;		// controls if this coordinate has treasure
	private boolean dug;			// controls if this coordinate was dug
	
	/**
	 * Object constructor.
	 * */
	public CoordinateMap() {
	}
	
	/**
	 * Object constructor.
	 * @param row integer that indicates the map row
	 * @param columns integer that indicates the map row
	 * @param row boolean that indicates if this coordinate has a treasure
	 * */
	public CoordinateMap(int row, int column, boolean treasure) {
		this.row = row;
		this.column = column;
		this.treasure = treasure;
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return this.column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public boolean getTreasure() {
		return this.treasure;
	}

	public void setTreasure(boolean treasure) {
		this.treasure = treasure;
	}

	public boolean getDug() {
		return this.dug;
	}

	public void setDug(boolean dug) {
		this.dug = dug;
	}
}
