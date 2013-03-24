package controller;

import model.board.ChessBoard;

public class ChessBoardViewController {
	private ChessBoard board;
	public boolean gameHasConcluded;
	
	public ChessBoardViewController() {
		this.board = new ChessBoard();
	}
	
	public void resign() {
		gameHasConcluded = true;
	}
	
	public void makeMove(char rankOne, int fileOne, char rankTwo, int fileTwo) {
		
	}
	
	public String getBoardString() {
		return this.board.toString();
	}
}
