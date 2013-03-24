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
			throws InvalidCoordinateException, InvalidMoveException {
		ChessCoordinatePair ccpone;
		ChessCoordinatePair ccptwo;

		try {
			ccpone = new ChessCoordinatePair(fileOne, rankOne);
			ccptwo = new ChessCoordinatePair(fileTwo, rankTwo);
		} catch (InvalidCoordinateException ice) {
			throw ice;
		}

		if (ccpone != null && ccptwo != null) {
			try {
				board.makeMove(ccpone, ccptwo);
			} catch (InvalidMoveException ime) {
				throw ime;
			}
		}
	}

	public String getBoardString() {
		return this.board.toString();
	}
}
