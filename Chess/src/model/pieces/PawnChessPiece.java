package model.pieces;

import util.ChessCoordinatePair;
import util.ChessNamingConstants;

public class PawnChessPiece extends ChessPiece {

	public PawnChessPiece(boolean isBlack) {
		super(isBlack);
	}

	public String toString() {
		return super.toString() + ChessNamingConstants.PAWN;
	}

	public boolean isValidMove(ChessCoordinatePair startAddress,
			ChessCoordinatePair endAddress, PieceSpecialCases special) {
		boolean generallyValid = super.isValidMove(startAddress, endAddress,
				special);

		if (isBlack) {
			special.isFirstMove = startAddress.rank == 1 ? true : false;
			special.canPromote = endAddress.rank == 7 ? true : false;
		} else {
			special.isFirstMove = startAddress.rank == 6 ? true : false;
			special.canPromote = endAddress.rank == 0 ? true : false;
		}

		if (generallyValid) {
			if (special.isCapturing) { // TODO:en passant
				if (startAddress.file - 1 == endAddress.file
						|| startAddress.file + 1 == endAddress.file) {
					if (isBlack)
						return (startAddress.rank + 1 == endAddress.rank);
					else
						return (startAddress.rank - 1 == endAddress.rank);
				} else
					return false;
			} else if (startAddress.hasSameFileAs(endAddress)) {
				if (special.isFirstMove) {
					if (isBlack)
						return (startAddress.rank + 1 == endAddress.rank || startAddress.rank + 2 == endAddress.rank);
					else
						return (startAddress.rank - 1 == endAddress.rank || startAddress.rank - 2 == endAddress.rank);
				} else if (special.isPromoting) {
					if (isBlack)
						return (startAddress.rank + 1 == endAddress.rank) && special.canPromote;
					else
						return (startAddress.rank - 1 == endAddress.rank) && special.canPromote;
				} else {
					if (isBlack)
						return (startAddress.rank + 1 == endAddress.rank);
					else
						return (startAddress.rank - 1 == endAddress.rank);
				}
			}

			return false;
		}

		return false;
	}
}
