package view;

import controller.ChessBoardViewController;
import util.*;

public class ChessBoardView {

	public ChessBoardViewController vc;
	private int moveCount = 0;
	
	public ChessBoardView(ChessBoardViewController viewController) {
		this.vc = viewController;
	}
	
	public void giveArgument(String arg) {
		if (arg.compareTo("resign") == 0) {
			this.vc.resign();
		} else if (arg.length() == 5){
			char rankOne = arg.charAt(0);
			char fileOne = arg.charAt(1);
			
			char rankTwo = arg.charAt(3);
			char fileTwo = arg.charAt(4);
			
			try {
				vc.makeMove(rankOne, fileOne, rankTwo, fileTwo);
			} catch (InvalidCoordinateException ice) {
				System.out.println(ice.getMessage());
			} catch (InvalidMoveException ime) {
				System.out.println(ime.getMessage());
			}
		}
		
		moveCount++;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public void printBoard() {
		System.out.println(this.vc.getBoardString());
	}
	
	public void printPrompt(int moveCount) {
		String prompt = "";
		
		
		
		System.out.println(prompt);
	}
}
