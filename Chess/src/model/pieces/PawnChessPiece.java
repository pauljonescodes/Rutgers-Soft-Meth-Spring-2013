package model.pieces;

public class PawnChessPiece extends ChessPiece {
	public static final String PAWN_PIECE_NAME_CHARACTER = "P";
	
	public PawnChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + PAWN_PIECE_NAME_CHARACTER;
	}
}
