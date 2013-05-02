package JPGN;

/**
 * A data structure to wrap two chess coordinate pairs together to represent
 * source and destination in a chess move.
 * 
 * @author Paul Jones
 */
public class CCPSourceDestPair {
	public ChessCoordinatePair source;
	public ChessCoordinatePair destination;

	public CCPSourceDestPair(ChessCoordinatePair source,
			ChessCoordinatePair destination) {
		this.source = source;
		this.destination = destination;
	}

	public String toString() {
		return this.source.toString() + " " + this.destination.toString();
	}
}
