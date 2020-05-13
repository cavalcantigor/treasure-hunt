package game;

import java.util.ArrayList;
import java.util.List;

/** 
 * Represents a coordinate player.
 * @author Cassio Towesend
 * @version 1.0
*/
public class Player {

	private int age;					// player age
	private String name;				// player name
	private String surname;				// player surname
	private int piratePoints;			// player pirate points
	private int digPoints;				// player dig points
	private List<CoordinateMap> moves;  // player moves
	
	public Player() {
		this.moves = new ArrayList<CoordinateMap>();
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setSurname(String name) {
		this.surname = name;
	}

	public int getDigPoints() {
		return digPoints;
	}

	public void setDigPoints(int digPoints) {
		this.digPoints = digPoints;
	}

	public int getPiratePoints() {
		return piratePoints;
	}

	public void setPiratePoints(int piratePoints) {
		this.piratePoints = piratePoints;
	}

	public List<CoordinateMap> getMoves() {
		return moves;
	}

	public void setMoves(List<CoordinateMap> moves) {
		this.moves = moves;
	}
}
