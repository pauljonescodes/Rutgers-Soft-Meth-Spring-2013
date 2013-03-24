package model.pieces;

import util.ChessConstants;

public class KnightChessPiece extends ChessPiece {
	
	public KnightChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessConstants.KNIGHT_PIECE_NAME_CHARACTER;
	}
}
