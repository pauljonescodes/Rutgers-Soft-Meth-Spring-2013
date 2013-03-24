package model.pieces;

import util.ChessConstants;

public class BishopChessPiece extends ChessPiece {
	
	public BishopChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessConstants.BISHOP_PIECE_NAME_CHARACTER;
	}
}
