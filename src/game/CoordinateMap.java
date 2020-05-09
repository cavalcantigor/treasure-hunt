package game;

public class CoordinateMap {
	private int row;
	private int column;
	private int treasure;
	private boolean digged;
	
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

	public boolean getDigged() {
		return digged;
	}

	public void setDigged(boolean digged) {
		this.digged = digged;
	}
}
