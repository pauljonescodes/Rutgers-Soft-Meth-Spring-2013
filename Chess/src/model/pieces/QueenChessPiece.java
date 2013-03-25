package model.pieces;

import java.util.ArrayList;

import util.ChessCoordinatePair;
import util.ChessNamingConstants;

public class QueenChessPiece extends ChessPiece {
	
	public QueenChessPiece(boolean isBlack) {
		super(isBlack);
	}
	
	public String toString() {
		return super.toString() + ChessNamingConstants.QUEEN;
	}
	
	public boolean isValidMove(ChessCoordinatePair startAddress, ChessCoordinatePair endAddress, PieceSpecialCases special) {
		boolean generallyValid = super.isValidMove(startAddress, endAddress, special);
		
		if (generallyValid) {
			if (!special.pieceInPath) {
				if (startAddress.hasSameFileAs(endAddress)) {
					return true;
				} else if (startAddress.hasSameRankAs(endAddress)) {
					return true;
				} else if (startAddress.isDiagonalTo(endAddress)) {
					return true;
				}
			}
		} 

		return false;
	}
	
	public ArrayList<ChessCoordinatePair> deepestMovesFrom(ChessCoordinatePair startAddress) {
		ArrayList<ChessCoordinatePair> deepestMoves = new ArrayList<ChessCoordinatePair>(8);
		
		deepestMoves.add(new ChessCoordinatePair(startAddress.rank, 7));
		deepestMoves.add(new ChessCoordinatePair(startAddress.rank, 0));
		deepestMoves.add(new ChessCoordinatePair(7, startAddress.file));
		deepestMoves.add(new ChessCoordinatePair(0, startAddress.file));
		
		return deepestMoves;
	}
}
