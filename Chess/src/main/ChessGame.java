package main;

import java.util.Scanner;

import view.ChessBoardView;
import controller.ChessBoardViewController;

public class ChessGame {
	public static void main (String[]args) {
		ChessBoardViewController vc = new ChessBoardViewController();
		ChessBoardView v = new ChessBoardView(vc);
		Scanner in = new Scanner(System.in);
		int moveCount = 0;
		
		while (!vc.gameHasConcluded) {
			v.printBoard();
			v.printPrompt(moveCount);
			String arg = in.nextLine();
			v.giveArgument(arg);
		}
	}
}
