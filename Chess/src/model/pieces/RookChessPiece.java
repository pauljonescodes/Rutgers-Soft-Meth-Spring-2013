package model.pieces;

import util.ChessConstants;

public class RookChessPiece extends ChessPiece {
	
	public RookChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessConstants.ROOK_PIECE_NAME_CHARACTER;
	}
}
