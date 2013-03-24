package model.pieces;

public class KnightChessPiece extends ChessPiece {
	public static final String KNIGHT_PIECE_NAME_CHARACTER = "N";
	
	public KnightChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + KNIGHT_PIECE_NAME_CHARACTER;
	}
}
