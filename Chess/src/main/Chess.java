package main;

import java.util.Scanner;

import view.ChessBoardView;
import controller.ChessBoardViewController;

/**
 * 
 * @author Paul Jones
 *
 */

public class Chess {
	public static void main (String[]args) {
		ChessBoardViewController vc = new ChessBoardViewController();
		ChessBoardView v = new ChessBoardView(vc);
		Scanner in = new Scanner(System.in);
		
		while (!vc.gameHasConcluded) {
			v.printBoard();
			v.printPrompt();
			String arg = in.nextLine();
			v.giveArgument(arg);
		}
	}
}
