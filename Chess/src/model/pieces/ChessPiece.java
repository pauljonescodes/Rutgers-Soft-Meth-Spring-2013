package model.pieces;

public class ChessPiece {
	public boolean isBlack;
	
	public ChessPiece (boolean isBlack) {
		this.isBlack = isBlack;
	}
	
	public String toString() {
		return this.isBlack ? "b" : "w";
	}
}
