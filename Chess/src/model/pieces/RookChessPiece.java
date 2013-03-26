package model.pieces;

import java.util.ArrayList;

import util.ChessCoordinatePair;
import util.ChessNamingConstants;

/**
 * 
 * @author Paul Jones
 *
 */

public class RookChessPiece extends ChessPiece {

	public RookChessPiece(boolean isBlack) {
		super(isBlack);
	}

	public String toString() {
		return super.toString() + ChessNamingConstants.ROOK;
	}

	public boolean isValidMove(ChessCoordinatePair startAddress,
			ChessCoordinatePair endAddress, PieceSpecialCases special) {
		boolean generallyValid = super.isValidMove(startAddress, endAddress,
				special);

		if (generallyValid) {
			if (!special.pieceInPath) {
				if (startAddress.hasSameRankAs(endAddress)) {
					return true;
				} else if (startAddress.hasSameFileAs(endAddress)) {
					return true;
				} 
			}
		}

		return false;
	}
	
	public ArrayList<ChessCoordinatePair> deepestMovesFrom(ChessCoordinatePair startAddress) {
		ArrayList<ChessCoordinatePair> deepestMoves = new ArrayList<ChessCoordinatePair>(4);
		
		deepestMoves.add(new ChessCoordinatePair(startAddress.rank, 7));
		deepestMoves.add(new ChessCoordinatePair(startAddress.rank, 0));
		deepestMoves.add(new ChessCoordinatePair(7, startAddress.file));
		deepestMoves.add(new ChessCoordinatePair(0, startAddress.file));
		
		return deepestMoves;
	}
}
