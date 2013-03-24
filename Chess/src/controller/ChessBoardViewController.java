package controller;

import util.*;
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

	public void makeMove(char rankOne, char fileOne, char rankTwo, char fileTwo)
			throws InvalidCoordinateException {
		try {
			ChessCoordinatePair ccpone = new ChessCoordinatePair(fileOne, rankOne);
			ChessCoordinatePair ccptwo = new ChessCoordinatePair(fileTwo, rankTwo);
		} catch (InvalidCoordinateException ice) {
			throw ice;
		}
	}

	public String getBoardString() {
		return this.board.toString();
	}
}
