package game;

public class CoordinateMap {
	private int row;
	private int column;
	private int treasure;
	private boolean dug;
	
	public CoordinateMap() {
	}
	
	public CoordinateMap(int row, int column, int treasure) {
		this.row = row;
		this.column = column;
		this.treasure = treasure;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getTreasure() {
		return treasure;
	}

	public void setTreasure(int treasure) {
		this.treasure = treasure;
	}

	public boolean getDug() {
		return dug;
	}

	public void setDug(boolean digged) {
		this.dug = digged;
	}
}
