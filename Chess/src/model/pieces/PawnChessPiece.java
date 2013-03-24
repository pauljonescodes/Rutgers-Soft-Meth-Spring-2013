package model.pieces;

import util.ChessNamingConstants;

public class PawnChessPiece extends ChessPiece {
	
	public PawnChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessNamingConstants.PAWN;
	}
}
