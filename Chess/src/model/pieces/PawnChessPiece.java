package model.pieces;

import util.ChessConstants;

public class PawnChessPiece extends ChessPiece {
	
	public PawnChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessConstants.PAWN_PIECE_NAME_CHARACTER;
	}
}
