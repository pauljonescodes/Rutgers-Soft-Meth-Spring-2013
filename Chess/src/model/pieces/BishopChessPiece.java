package model.pieces;

import util.ChessNamingConstants;

public class BishopChessPiece extends ChessPiece {
	
	public BishopChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessNamingConstants.BISHOP;
	}
}
