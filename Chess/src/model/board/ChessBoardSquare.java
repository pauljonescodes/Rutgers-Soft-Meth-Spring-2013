package model.board;

import model.pieces.ChessPiece;
import util.*;

public class ChessBoardSquare {
	public final ChessCoordinatePair location;
	public ChessPiece piece;

	public ChessBoardSquare(ChessCoordinatePair location, ChessPiece piece) {
		this.location = location;
		this.piece = piece;
	}

	public boolean isOccupied() {
		return this.piece == null;
	}

	public String toString() {
		if (this.piece == null) {
			if ((this.location.file % 2 == 0 && this.location.rank % 2 == 0)
					|| (this.location.file % 2 != 0 && this.location.rank % 2 != 0)) {
				return ChessNamingConstants.WHITE_SQUARE;
			} else {
				return ChessNamingConstants.BLACK_SQUARE;
			}
		} else {
			return this.piece.toString();
		}
	}
}
