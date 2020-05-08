package util;

public class Constraints {
	
	public static int MIN_PLAYERS = 2;
	public static int MAX_PLAYERS = 4;
	public static int DIG_POINTS_MULTIPLIER = 5;
	
	public static boolean validateMinimumPlayers(int players) {
		if (players < MIN_PLAYERS || players > MAX_PLAYERS) {
			return false;
		}
		return true;
	}
}
