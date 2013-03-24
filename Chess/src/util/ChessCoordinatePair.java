package util;

public class ChessCoordinatePair {
	public int rank;
	public int file;

	/**
	 * 
	 * @param rank
	 *            horizontal rows of squares labeled 1 to 8
	 * @param file
	 *            vertical column of squares labeled a through h
	 */
	public ChessCoordinatePair(char rank, char file) throws InvalidCoordinateException {
		int rankInt = Integer.parseInt(rank + "") - 1;
		int fileInt = file - 'a';
		
		if (rankInt > 7) {
			throw new InvalidCoordinateException("Your rank is too high.");
		} else if (fileInt > 7) {
			throw new InvalidCoordinateException("Your file is too high.");
		} else {
			this.rank = rankInt;
			this.file = fileInt;
		}
	}
	
	public ChessCoordinatePair(int rank, int file) {
		this.rank = rank;
		this.file = file;
	}

	public boolean isXYAdjacentTo(ChessCoordinatePair ccp) {
		if (this.equals(ccp)) {
			return false;
		} else if (this.isDiagonalFrom(ccp)) {
			return false;
		} else if (this.hasSameFileAs(ccp)
				&& (ccp.rank - 1 == this.rank || ccp.rank + 1 == this.rank)) {
			return true;
		} else if (this.hasSameRankAs(ccp)
				&& (ccp.file - 1 == this.file || ccp.file + 1 == this.file)) {
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
