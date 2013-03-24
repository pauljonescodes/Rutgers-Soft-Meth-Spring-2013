package view;

import controller.ChessBoardViewController;

public class ChessBoardView {

	public ChessBoardViewController viewController;
	private int moveCount = 0;
	
	public ChessBoardView(ChessBoardViewController viewController) {
		this.viewController = viewController;
	}
	
	public void giveArgument(String arg) {
		if (arg.compareTo("resign") == 0) {
			this.viewController.resign();
		}
		
		moveCount++;
	}
	
	public void printBoard() {
		System.out.println(this.viewController.getBoardString());
	}
	
	public void printPrompt(int moveCount) {
		String prompt = "";
		
		
		
		System.out.println(prompt);
	}
}
