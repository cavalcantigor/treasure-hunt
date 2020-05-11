package game;

public class CoordinateMap {
	private int row;
	private int column;
	private boolean treasure;
	private boolean dug;
	
	public CoordinateMap() {
	}
	
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
