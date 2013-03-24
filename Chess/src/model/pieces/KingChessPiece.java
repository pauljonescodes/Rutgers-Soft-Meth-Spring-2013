package model.pieces;

import util.ChessConstants;

public class KingChessPiece extends ChessPiece {
	
	public KingChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessConstants.KING_PIECE_NAME_CHARACTER;
	}
}
