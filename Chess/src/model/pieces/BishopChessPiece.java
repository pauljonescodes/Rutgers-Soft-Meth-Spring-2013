package model.pieces;


public class BishopChessPiece extends ChessPiece {
	public static final String BISHOP_PIECE_NAME_CHARACTER = "B";
	
	public BishopChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + BISHOP_PIECE_NAME_CHARACTER;
	}
}
