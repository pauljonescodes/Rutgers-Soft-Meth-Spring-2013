package model.pieces;

import java.util.ArrayList;

import util.*;

/**
 * 
 * @author Paul Jones
 *
 */

public class ChessPiece {
	public boolean isBlack;

	public ChessPiece(boolean isBlack) {
		this.isBlack = isBlack;
	}

	public String toString() {
		return this.isBlack ? ChessNamingConstants.BLACK_PIECE : ChessNamingConstants.WHITE_PIECE;
	}

	public boolean isValidMove(ChessCoordinatePair startAddress, ChessCoordinatePair endAddress, PieceSpecialCases special) {
		if (startAddress.distanceFrom(endAddress) <= 7) {
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<ChessCoordinatePair> deepestMovesFrom(ChessCoordinatePair startAddress) {
		return null;
	}
}
