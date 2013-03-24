package model.pieces;

import util.ChessConstants;

public class QueenChessPiece extends ChessPiece {
	
	public QueenChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessConstants.QUEEN_PIECE_NAME_CHARACTER;
	}
}
