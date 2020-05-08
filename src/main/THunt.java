
package main;

import java.util.Scanner;
import game.Player;


public class THunt {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int nPlayers = 0;
		
		System.out.println("How many players out there? ");
		nPlayers = scan.nextInt();
		
		scan.close();
	}
}
