package util;

public class ChessCoordinatePair {
	public int rank;
	public int file;

	public ChessCoordinatePair(char rank, char file) throws InvalidCoordinateException {
		int rankInt = this.getRankIntFrom(rank);
		int fileInt = this.getFileIntFrom(file);
		
		if (rankInt > 7) {
			throw new InvalidCoordinateException("Invalid coordinate, your rank is too high.");
		} else if (fileInt > 7) {
			throw new InvalidCoordinateException("Invalid coordinate, your file is too high.");
		} else {
			this.rank = rankInt;
			this.file = fileInt;
		}
	}
	
	/**
	 * 
	 * @param rank a character that is '1', '2', ... '8'
	 * @return an intger greater than zero and less than 7
	 */
	private int getRankIntFrom(char rank) {
		return Integer.parseInt(rank + "") - 1;
	}
	
	/**
	 * 
	 * @param file a character that is 'a', 'b', ... 'h'
	 * @return an intger greater than zero and less than 7
	 */
	private int getFileIntFrom(char file) {
		return Character.toLowerCase(file) - 'a';
	}
	
	private char getRankCharFrom(int rank) {
		return Character.forDigit(rank + 1, 10);
	}
	
	private char getFileCharFrom(int file) {
		return (char)(file + 'a');
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
	
	public String toString() {
		return this.getFileCharFrom(this.file) + "" + this.getRankCharFrom(this.rank);
	}
	
	
}
