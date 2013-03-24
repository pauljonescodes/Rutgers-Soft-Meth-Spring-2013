package model.pieces;

public class RookChessPiece extends ChessPiece {
	
	public static final String ROOK_PIECE_NAME_CHARACTER = "R";
	
	public RookChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ROOK_PIECE_NAME_CHARACTER;
	}
}
