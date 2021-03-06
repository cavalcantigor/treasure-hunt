package game;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import rules.GameRule;

/** 
 * Manages the game.
 * @author Cassio Towesend
 * @version 1.0
*/
public class Game {

	private Scanner scan;					// scan object that read all input data from players
	private Player[] players;				// players on the game
	private TreasureMap map;				// game map
	private Display display;				// object that manages game display
	private int[][] treasures;  // matrix of treasures hidden on map
	
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
		this.display = new Display(this.map, this.players);
		this.treasures = new int[Constraints.MAP_ROWS][Constraints.MAP_COLUMNS];
	}
	
	/**
	 * Method that encapsulates all game routine.
	 * @return
	 * */
	public void run() {
		boolean continueGame = true; // control the game main loop
		boolean treasureFound = false; // control if move found treasure
		
		// loads file with coordinates of treasures 
		this.loadFileTreasures();
		
		// creates the map with n rows and n columns; also set treasure on the map
		this.map.createMap(Constraints.MAP_ROWS, Constraints.MAP_COLUMNS, this.treasures);

		// main game loop
		while(continueGame) {
			
			for(int i = 0; i < this.players.length; i++) {

				// if current player has dig points
				if(this.players[i].getDigPoints() > 0) {
					
					// print sequence of players moves 
					this.display.printPlayersMoves();
					
					// draw map
					this.display.drawMap();

					// annunciate player turn
					System.out.println("Argh... Pirate " + players[i].getName() + 
							"... it be your turn to dig for me treasure.");

					// current player move
					treasureFound = move(this.players[i]);
					
					// if the move found treasure
					if(treasureFound) {

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
				if(GameRule.isAllTreasureFound(this.treasures) || GameRule.noDigPointsLeft(this.players)) {
					continueGame = false;
					break;
				}
			}
		}
		// print sequence of players moves 
		this.display.printPlayersMoves();
		
		// draw map
		this.display.drawMap();
		
		// end game and celebrate winner(s)
		this.end();
	}
	
	/**
	 * Read Pirate Pete file and load treasures.
	 * */
	private void loadFileTreasures() {
		Scanner fileScan;						// scanner to read file
		
		// block to handle error
		try {
			File piratePeteFile = new File(Constraints.PIRATE_PETE_FILE); 	// file pirate pete
			
			// instantiate a new scanner object
			fileScan = new Scanner(piratePeteFile);
			
			int col; // column to be read from file
			int row; // row to be read from file
			
			// read all file while has token
			while(fileScan.hasNext()) {
				
				// read column label and transform to integer
				col = Constraints.transformLabelCoordinate(fileScan.nextLine());
				
				// read row value from file
				row = Integer.valueOf(fileScan.nextLine());
				
				// add a coordinate to treasure list
				this.treasures[row - 1][col - 1] = 1;
			}
			
			// closes scan
			fileScan.close();
		
		} catch (Exception e) { // if an error is raised
			System.out.println("An error ocurred on loading file treasures.");
			e.printStackTrace();
		}
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
		boolean hasTreasure; 				// boolean that save if coordinate has treasure
		
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
				
				// save if location dug has a treasure
				hasTreasure = this.map.hasTreasure(rowCoordinate - 1, colCoordinate - 1);
				
				// if found treasure
				if (hasTreasure) {
					
					// collect treasure
					this.treasures[rowCoordinate - 1][colCoordinate - 1] = 0;
				}
				
				// if coordinate is OK, then mark as dug
				this.map.dig(rowCoordinate - 1, colCoordinate - 1);
				
				// adding player move to list of moves
				player.getMoves().add(new CoordinateMap(rowCoordinate, colCoordinate, hasTreasure));
				
				// return if the place dug has a treasure
				return hasTreasure;
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
					System.out.print(digPointsWinners.get(i).getName() + ", ");
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
		
		System.out.println("\n\n\n --------- THE END --------");
	}
}
