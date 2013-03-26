package model.pieces;

import java.util.ArrayList;

import util.ChessCoordinatePair;
import util.ChessNamingConstants;

/**
 * 
 * @author Paul Jones
 *
 */

public class KnightChessPiece extends ChessPiece {

	public KnightChessPiece(boolean isBlack) {
		super(isBlack);
	}

	public String toString() {
		return super.toString() + ChessNamingConstants.KNIGHT;
	}

	public boolean isValidMove(ChessCoordinatePair startAddress,
			ChessCoordinatePair endAddress, PieceSpecialCases special) {
		boolean generallyValid = super.isValidMove(startAddress, endAddress,
				special);

		if (generallyValid) {
			if (startAddress.rank + 2 == endAddress.rank
					|| startAddress.rank - 2 == endAddress.rank) {
				if (startAddress.file + 1 == endAddress.file
						|| startAddress.file - 1 == endAddress.file) {
					return true;
				}
			} else if (startAddress.file + 2 == endAddress.file
					|| startAddress.file - 2 == endAddress.file) {
				if (startAddress.rank + 1 == endAddress.rank
						|| startAddress.rank - 1 == endAddress.rank) {
					return true;
				}
			}
		}

		return false;
	}

	public ArrayList<ChessCoordinatePair> deepestMovesFrom(
			ChessCoordinatePair start) {
		ArrayList<ChessCoordinatePair> deepestMoves = new ArrayList<ChessCoordinatePair>();

		int currentRank = start.rank + 2;
		int currentFile = start.file + 1;

		if (currentRank < 8 && currentRank >= 0 && currentFile < 8 && currentFile >= 0)
			deepestMoves.add(new ChessCoordinatePair(currentRank, currentFile));

		currentRank = start.rank - 2;
		currentFile = start.file + 1;
		
		if (currentRank < 8 && currentRank > 0 && currentFile < 8 && currentFile >= 0)
			deepestMoves.add(new ChessCoordinatePair(currentRank, currentFile));
		
		currentRank = start.rank + 2;
		currentFile = start.file - 1;
		
		if (currentRank < 8 && currentRank > 0 && currentFile < 8 && currentFile >= 0)
			deepestMoves.add(new ChessCoordinatePair(currentRank, currentFile));
		
		currentRank = start.rank - 2;
		currentFile = start.file - 1;
		
		if (currentRank < 8 && currentRank >= 0 && currentFile < 8 && currentFile >= 0)
			deepestMoves.add(new ChessCoordinatePair(currentRank, currentFile));
		
		currentRank = start.rank + 1;
		currentFile = start.file + 2;
		
		if (currentRank < 8 && currentRank >= 0 && currentFile < 8 && currentFile >= 0)
			deepestMoves.add(new ChessCoordinatePair(currentRank, currentFile));

		currentRank = start.rank - 1;
		currentFile = start.file + 2;
		
		if (currentRank < 8 && currentRank >= 0 && currentFile < 8 && currentFile >= 0)
			deepestMoves.add(new ChessCoordinatePair(currentRank, currentFile));
		
		currentRank = start.rank + 1;
		currentFile = start.file - 2;
		
		if (currentRank < 8 && currentRank >= 0 && currentFile < 8 && currentFile >= 0)
			deepestMoves.add(new ChessCoordinatePair(currentRank, currentFile));
		
		currentRank = 0;
		currentFile = 0;
		
		if (currentRank < 8 && currentRank >= 0 && currentFile < 8 && currentFile >= 0)
			deepestMoves.add(new ChessCoordinatePair(currentRank, currentFile));

		return deepestMoves;
	}
}
