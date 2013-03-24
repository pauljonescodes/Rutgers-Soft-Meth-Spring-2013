package model.pieces;

import util.*;

public class ChessPiece {
	public boolean isBlack;
	
	public ChessPiece (boolean isBlack) {
		this.isBlack = isBlack;
	}
	
	public String toString() {
		return this.isBlack ? ChessNamingConstants.BLACK_PIECE : ChessNamingConstants.WHITE_PIECE;
	}
	
	public boolean isValidMove(ChessCoordinatePair from, ChessCoordinatePair to) {
		
		return false;
	}
}
