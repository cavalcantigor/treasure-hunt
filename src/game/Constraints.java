package game;

/** 
 * Controls all game variables.
 * @author Cassio Towesend
 * @version 1.0
 * @since 1.0
*/
public class Constraints {
	public static int MIN_PLAYERS = 2;
	public static int MAX_PLAYERS = 4;
	public static int MIN_PLAYER_AGE = 12;
	public static int DIG_POINTS_MULTIPLIER = 5;
	public static int DIG_POINTS_PENALTY = 1;
	public static int PIRATE_POINTS = 100;
	public static int PIRATE_POINTS_BONUS = 20;
	public static int MIN_PLAYER_DIG_POINTS = 4;
	public static int MAX_PLAYER_DIG_POINTS = 7;
	public static int MAP_COLUMNS = 10;
	public static int MAP_ROWS = 10;
	
	public static String[] LABELS = {
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};
	
	public static int transformLabelCoordinate(String label) {
		for(int i = 0; i < MAP_COLUMNS; i++) {
			if(LABELS[i].equalsIgnoreCase(label)) {
				return i + 1;
			}
		}
		return -1;
	}
}
