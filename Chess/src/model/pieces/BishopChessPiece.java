package model.pieces;

import util.ChessCoordinatePair;
import util.ChessNamingConstants;

public class BishopChessPiece extends ChessPiece {

	public BishopChessPiece(boolean isBlack) {
		super(isBlack);
	}

	public String toString() {
		return super.toString() + ChessNamingConstants.BISHOP;
	}

	public boolean isValidMove(ChessCoordinatePair startAddress,
			ChessCoordinatePair endAddress, PieceSpecialCases special) {
		boolean generallyValid = super.isValidMove(startAddress, endAddress,
				special);

		if (ChessNamingConstants.DEVELOPMENT) {
			System.out.println("isValidMove() on Bishop");
		}

		if (generallyValid) {
			
			if (ChessNamingConstants.DEVELOPMENT) {
				System.out.println("\tis generally valid");
			}
			
			if (!special.pieceInPath) {
				
				if (ChessNamingConstants.DEVELOPMENT) {
					System.out.println("\tno piece in path");
				}
				
				if (startAddress.isDiagonalTo(endAddress)) {
					
					if (ChessNamingConstants.DEVELOPMENT) {
						System.out.println("\tis diagonal");
					}
					
					return true;
				}
			}
		}

		return false;
	}
}
