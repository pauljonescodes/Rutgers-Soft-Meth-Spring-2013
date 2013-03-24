package model.pieces;

import util.ChessNamingConstants;

public class QueenChessPiece extends ChessPiece {
	
	public QueenChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessNamingConstants.QUEEN;
	}
}
