package model.pieces;

import util.ChessNamingConstants;

public class KnightChessPiece extends ChessPiece {
	
	public KnightChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessNamingConstants.KNIGHT;
	}
}
