package model.pieces;

import util.ChessCoordinatePair;
import util.ChessNamingConstants;

public class KnightChessPiece extends ChessPiece {
	
	public KnightChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessNamingConstants.KNIGHT;
	}
	
	public boolean isValidMove(ChessCoordinatePair startAddress, ChessCoordinatePair endAddress, PieceSpecialCases special) {
		boolean generallyValid = super.isValidMove(startAddress, endAddress, special);
		
		if (generallyValid) {
			if (startAddress.rank + 2 == endAddress.rank || startAddress.rank - 2 == endAddress.rank) {
				if (startAddress.file + 1 == endAddress.file || startAddress.file - 1 == endAddress.file) {
					return true;
				}
			} else if (startAddress.file + 2 == endAddress.file || startAddress.file - 2 == endAddress.file) {
				if (startAddress.rank + 1 == endAddress.rank || startAddress.rank - 1 == endAddress.rank) {
					return true;
				} 
			}
		}
		
		return false;
	}
}
