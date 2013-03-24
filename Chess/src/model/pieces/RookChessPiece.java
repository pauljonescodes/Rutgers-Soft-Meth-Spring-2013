package model.pieces;

import util.ChessNamingConstants;

public class RookChessPiece extends ChessPiece {
	
	public RookChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessNamingConstants.ROOK;
	}
}
