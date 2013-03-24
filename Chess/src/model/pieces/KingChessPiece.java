package model.pieces;

import util.ChessNamingConstants;

public class KingChessPiece extends ChessPiece {
	
	public KingChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessNamingConstants.KING;
	}
}
