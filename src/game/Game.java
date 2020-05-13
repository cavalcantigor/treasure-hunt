package game;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rules.GameRule;

/** 
 * Manage the game.
 * @author Cassio Towesend
 * @version 1.0
*/
public class Game {

	private Scanner scan;				// scan object that read all input data from players
	private Player[] players;			// players on the game
	private TreasureMap map;			// game map
	
	/**
	 * Object constructor.
	 * @param scan Scanner object
	 * @param players Player array
	 * @param map TreasureMap object
	 * */
	public Game(Scanner scan, Player[] players, TreasureMap map) {
		this.scan = scan;
		this.players = players;
		this.map = map;
	}
	
	/**
	 * Method that encapsulates all game routine.
	 * @return
	 * */
	public void run() {
		boolean continueGame = true; // control the game main loop

		// creates the map with n rows and n columns; also set treasure on the map
		this.map.createMap(Constraints.MAP_ROWS, Constraints.MAP_COLUMNS, this.loadFileTreasures());

		// main game loop
		while(continueGame) {
			for(int i = 0; i < this.players.length; i++) {

				// if current player has dig points
				if(this.players[i].getDigPoints() > 0) {

					// draw map
					this.map.drawMap();

					// annunciate player turn
					System.out.println("Argh..Pirate " + players[i].getName() + 
							"...it be your turn to dig for me treasure.");

					// current player move
					if(move(this.players[i])) {

						// if move succeeds, then the player earn pirate points bonus
						this.players[i].setPiratePoints(
								this.players[i].getPiratePoints() + Constraints.PIRATE_POINTS_BONUS
						);
						
						// congratulations, player[i] ;)
						System.out.println("Yo-ho-ho and a bottle of rum. I found me some\n" + 
								"pieces of eight.");
					} else {
						
						// oh no... the move was fail
						System.out.println("Walk the plank! There be no treasure here!");
					}
				} else {
					
					// player has no dig points to move
					System.out.println("Argh, Captain, me shovel has broken!");
				}
				
				// subtract dig points penalty from current player
				this.players[i].setDigPoints(
						this.players[i].getDigPoints() - Constraints.DIG_POINTS_PENALTY
				);
				
				// game ends if all treasure is found or all player has no dig points
				if(GameRule.isAllTreasureFound(this.map) || GameRule.noDigPointsLeft(this.players)) {
					continueGame = false;
					break;
				}
			}
		}
		
		// end game and celebrate winner(s)
		this.end();
	}
	
	/**
	 * Read Pirate Pete file and load coordinates list.
	 * @return an array list of CoordinateMaps if success; otherwise, return null.
	 * */
	private List<CoordinateMap> loadFileTreasures() {
		Scanner fileScan;						// scanner to read file
		List<CoordinateMap> treasure = null;	// list of coordinate map with treasure location
		
		// block to handle error
		try {
			File piratePeteFile = new File(Constraints.PIRATE_PETE_FILE); 	// file pirate pete
			
			// instantiate a new scanner object
			fileScan = new Scanner(piratePeteFile);
			
			// instantiate a new list of coordinate map
			treasure = new ArrayList<CoordinateMap>();
			
			int col; // column to be read from file
			int row; // row to be read from file
			
			// read all file while has token
			while(fileScan.hasNext()) {
				
				// read column label and transform to integer
				col = Constraints.transformLabelCoordinate(fileScan.nextLine());
				
				// read row value from file
				row = Integer.valueOf(fileScan.nextLine());
				
				// add a coordinate to treasure list
				treasure.add(new CoordinateMap(row - 1, col - 1, true));
			}
			
			// closes scan
			fileScan.close();
		
		} catch (Exception e) { // if an error is raised
			System.out.println("An error ocurred on loading file treasures.");
			e.printStackTrace();
		}
		
		// return the list of treasures
		return treasure;
	}
	
	/**
	 * Method that do a player move. It validates player input and
	 * and dig a new square on map.
	 * @param player player doing the move
	 * @return True if move was well done (found a treasure); False otherwise
	 * */
	public boolean move(Player player) {
		int rowCoordinate;					// row coordinate
		int colCoordinate;					// column coordinate
		
		// infinite loop
		while(true) {
			
			// get column move from player
			colCoordinate = GameRule.validateColMove(this.scan, player);
			
			// get row move from player
			rowCoordinate = GameRule.validateRowMove(this.scan, player);
			
			// check if coordinate move was previously dug
			if(this.map.isCoordinateDug(rowCoordinate - 1, colCoordinate - 1)) {
				System.out.println("Sorry... you cannot 'dig' in the same place more than once.");
				System.out.println("Please, re-enter coordinates...");
			} else {

				// if coordinate is OK, then mark as dug
				this.map.dig(rowCoordinate - 1, colCoordinate - 1);
				
				// return if the place dug has a treasure
				return this.map.hasTreasure(rowCoordinate - 1, colCoordinate - 1);
			}
		}
	}
	
	/**
	 * Method that ends the game and annunciate the winner(s).
	 * */
	public void end() {
		
		System.out.println("Shiver me Timbers, me hearties, sure hasn’t ");
		
		// check winners with pirate points
		List<Player> piratePointsWinners = GameRule.getPiratePointsWinner(this.players);
		
		// if there are more than 1 winner
		if(piratePointsWinners.size() > 1) {
			
			// then check dig points winners
			List<Player> digPointsWinners = GameRule.getDigPointsWinner(piratePointsWinners);
			
			// if there are more than 1 dig point winner
			if(digPointsWinners.size() > 1) {
				
				// annunciate all tied winners
				for(int i = 0; i < digPointsWinners.size(); i++) {
					System.out.print(digPointsWinners.get(i).getName() + " ");
				}
			} else {
				
				// annunciate dig points winner
				System.out.print(digPointsWinners.get(0).getName() + " ");
			}
		} else {
			
			// annunciate pirate points winner
			System.out.print(piratePointsWinners.get(0).getName() + " ");
		}
		
		System.out.println("won the game. Keelhaul the rest of them!");
	}
}
