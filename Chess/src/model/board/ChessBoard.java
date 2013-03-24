package model.board;

import util.*;
import model.pieces.*;

public class ChessBoard {
	public static final int NUMBER_OF_RANKS = 8;
	public static final int NUMBER_OF_FILES = 8;

	private ChessBoardSquare[][] board;

	public ChessBoard() {
		board = new ChessBoardSquare[NUMBER_OF_RANKS][NUMBER_OF_FILES];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				board[i][j] = new ChessBoardSquare(
						new ChessCoordinatePair(i, j), null);

				if (i == 0 || i == 7) {
					if (j == 0 || j == 7) {
						board[i][j].piece = new RookChessPiece(i == 0);
					} else if (j == 1 || j == 6) {
						board[i][j].piece = new KnightChessPiece(i == 0);
					} else if (j == 2 || j == 5) {
						board[i][j].piece = new BishopChessPiece(i == 0);
					} else if (j == 3) {
						board[i][j].piece = new QueenChessPiece(i == 0);
					} else if (j == 4) {
						board[i][j].piece = new KingChessPiece(i == 0);
					}
				} else if (i == 1 || i == 6) {
					board[i][j].piece = new PawnChessPiece(i == 1);
				}
			}
		}
	}

	public void makeMove(ChessCoordinatePair from, ChessCoordinatePair to)
			throws InvalidMoveException {
		
	}

	public String toString() {
		String str = "";

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				str += this.board[i][j].toString() + " ";
			}

			str += (i + 1) + "\n";
		}

		str += " a  b  c  d  e  f  g  h\n";

		return str;
	}
}
