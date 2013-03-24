package model.pieces;

public class QueenChessPiece extends ChessPiece {
	public static final String QUEEN_PIECE_NAME_CHARACTER = "Q";
	
	public QueenChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + QUEEN_PIECE_NAME_CHARACTER;
	}
}
