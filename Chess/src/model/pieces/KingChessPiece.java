package model.pieces;

public class KingChessPiece extends ChessPiece {
	public static final String KING_PIECE_NAME_CHARACTER = "K";
	
	public KingChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + KING_PIECE_NAME_CHARACTER;
	}
}
