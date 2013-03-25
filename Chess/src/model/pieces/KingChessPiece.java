package model.pieces;

import util.ChessCoordinatePair;
import util.ChessNamingConstants;

public class KingChessPiece extends ChessPiece {
	
	public KingChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessNamingConstants.KING;
	}
	
	public boolean isValidMove(ChessCoordinatePair startAddress, ChessCoordinatePair endAddress, PieceSpecialCases special) {
		boolean generallyValid = super.isValidMove(startAddress, endAddress, special);
		
		if (generallyValid) {
			if (startAddress.isAdjacentTo(endAddress)) {
				return true;
			}
		} 
		
		return false;
	} // TODO: check
}
