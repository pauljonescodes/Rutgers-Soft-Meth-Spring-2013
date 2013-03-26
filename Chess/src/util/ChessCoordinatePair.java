package util;

/**
 * 
 * @author Paul Jones
 *
 */

public class ChessCoordinatePair {
	public int rank;
	public int file;

	/**
	 * Initializes a coordinate pair based on readable standard algebraic format
	 * input.
	 * 
	 * @param rank
	 *            1 through 8
	 * @param file
	 *            a through f
	 * @throws InvalidCoordinateException
	 */
	public ChessCoordinatePair(char rank, char file)
			throws InvalidCoordinateException {
		int rankInt = this.getRankIntFrom(rank);
		int fileInt = this.getFileIntFrom(file);

		if (rankInt > 7) {
			throw new InvalidCoordinateException(
					"Invalid coordinate, your rank is too high.");
		} else if (fileInt > 7) {
			throw new InvalidCoordinateException(
					"Invalid coordinate, your file is too high.");
		} else {
			this.rank = rankInt;
			this.file = fileInt;
		}
	}

	/**
	 * 
	 * Used for normalizing input.
	 * 
	 * @param rank
	 *            a character that is '1', '2', ... '8'
	 * @return an intger greater than zero and less than 7
	 */
	private int getRankIntFrom(char rank) {
		return Integer.parseInt(rank + "") - 1;
	}

	/**
	 * Used for normalizing input.
	 * 
	 * @param file
	 *            a character that is 'a', 'b', ... 'h'
	 * @return an intger greater than zero and less than 7
	 */
	private int getFileIntFrom(char file) {
		return Character.toLowerCase(file) - 'a';
	}

	/**
	 * Used for normalizing input.
	 * 
	 * @param rank
	 * @return
	 */
	private char getRankCharFrom(int rank) {
		return Character.forDigit(rank + 1, 10);
	}

	/**
	 * Used for normalizing input.
	 * 
	 * @param file
	 * @return
	 */
	private char getFileCharFrom(int file) {
		return (char) (file + 'a');
	}

	/**
	 * "Secret" public method that you should not use. Well, you can, it just
	 * isn't human readable. Use indexes.
	 * 
	 * @param rank
	 * @param file
	 */
	public ChessCoordinatePair(int rank, int file) {
		this.rank = rank;
		this.file = file;
	}

	/**
	 * Determines if two coordinate pairs have the same rank.
	 * 
	 * @param ccp
	 *            The coordinate you'd like to test this one against.
	 * @return
	 */
	public boolean hasSameRankAs(ChessCoordinatePair ccp) {
		if (this.rank == ccp.rank)
			return true;
		else
			return false;
	}

	/**
	 * Determines if two coordinate pairs have the same file.
	 * 
	 * @param ccp
	 *            The coordinate you'd like to test this one against.
	 * @return
	 */
	public boolean hasSameFileAs(ChessCoordinatePair ccp) {
		if (this.file == ccp.file)
			return true;
		else
			return false;
	}

	/**
	 * Implementation of the slope formula to determine if two points are
	 * "evenly diagonal."
	 * 
	 * @param ccp
	 * @return
	 */
	public boolean isDiagonalTo(ChessCoordinatePair ccp) {

		if (this.equals(ccp)) {
			return false;
		} else {
			int slope = this.getSlopeTo(ccp);

			System.out.println("slope: " + slope);
			
			if (slope == 1 || slope == -1)
				return true;
			else
				return false;
		}
	}
	
	public int getSlopeTo(ChessCoordinatePair ccp) {
		int rankOne = this.rank + 1;
		int fileOne = this.file + 1;

		int rankTwo = ccp.rank + 1;
		int fileTwo = ccp.file + 1;

		int denominator = fileOne - fileTwo;
		
		if (denominator != 0)
			return (rankOne - rankTwo) / denominator;
		else
			return 0;
	}

	/**
	 * Determines if some inputed point is immediately adjacent to this point,
	 * meaning it "touches" horizontally, vertically, or diagonally this point.
	 * 
	 * @param ccp
	 * @return
	 */
	public boolean isAdjacentTo(ChessCoordinatePair ccp) {
		if (this.rank <= ccp.rank + 1 && this.rank >= ccp.rank - 1) {
			if (this.file <= ccp.file + 1 && this.file >= ccp.file - 1) {
				return true;
			}
		}

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
		return this.getFileCharFrom(this.file) + ""
				+ this.getRankCharFrom(this.rank);
	}

	/**
	 * Implementation of the distance formula for chess coordinate points.
	 * 
	 * @param ccp
	 * @return
	 */
	public int distanceFrom(ChessCoordinatePair ccp) {
		return (int) Math.sqrt(Math.pow((ccp.file - this.file), 2)
				- Math.pow((ccp.rank - this.rank), 2));
	}
}
