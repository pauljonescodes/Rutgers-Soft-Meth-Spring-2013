package util;

public class ChessCoordinatePair {
	public int rank;
	public int file;

	/**
	 * Each square of the chessboard is identified by a unique coordinate pair—a
	 * letter and a number. The vertical column of squares (called files) from
	 * White's left (the queenside) to his right (the kingside) are labeled a
	 * through h. The horizontal rows of squares (called ranks) are numbered 1
	 * to 8 starting from White's side of the board. Thus each square has a
	 * unique identification of file letter followed by rank number. (For
	 * example, White's king starts the game on square e1; Black's knight on b8
	 * can move to open squares a6 or c6.)
	 * 
	 * @param rank
	 * @param file
	 */
	public ChessCoordinatePair(int rank, int file) {
		this.rank = rank;
		this.file = file;
	}
	
	public boolean isXYAdjacentTo(ChessCoordinatePair ccp) {
		if (this.equals(ccp)) {
			return false;
		} else if (this.isDiagonalFrom(ccp)) {
			return false;
		} else if (this.hasSameFileAs(ccp) && (ccp.rank - 1 == this.rank || ccp.rank + 1 == this.rank)) {
			return true;
		} else if (this.hasSameRankAs(ccp) && (ccp.file - 1 == this.file || ccp.file + 1 == this.file)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isDiagonalFrom(ChessCoordinatePair ccp) {
		if (this.equals(ccp)) {
			return false;
		} else if (this.isXYAdjacentTo(ccp)) {
			return false;
		} else if (this.rank == ccp.rank - 1 && this.file == ccp.file - 1) {
			return true;
		} else if (this.rank == ccp.rank + 1 && this.file == ccp.file - 1) {
			return true;
		} else if (this.rank == ccp.rank - 1 && this.file == ccp.file + 1) {
			return true;
		} else if (this.rank == ccp.rank + 1 && this.file == ccp.file + 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasSameRankAs(ChessCoordinatePair ccp) {
		if (this.rank == ccp.rank)
			return true;
		else
			return false;
	}

	public boolean hasSameFileAs(ChessCoordinatePair ccp) {
		if (this.file == ccp.file)
			return true;
		else
			return false;
	}
	
	public boolean equals(Object o) {
		if (o == null || !(o instanceof ChessCoordinatePair)) {
			return false;
		} else {
			ChessCoordinatePair ccp = ((ChessCoordinatePair) o);
			
			if (this.hasSameFileAs(ccp) && this.hasSameRankAs(ccp)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
