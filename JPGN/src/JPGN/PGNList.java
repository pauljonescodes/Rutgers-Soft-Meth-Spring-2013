package JPGN;

import java.io.Serializable;
import java.util.Calendar;
import java.util.ArrayList;

public class PGNList extends ArrayList<CCPSourceDestPair> implements
		Serializable {
	private static final long serialVersionUID = -1970986254768586322L;

	/**
	 * Event: the name of the tournament or match event.
	 */
	public String event;

	/**
	 * Site: the location of the event. This is in "City, Region COUNTRY"
	 * format, where COUNTRY is the three-letter International Olympic Committee
	 * code for the country. An example is "New York City, NY USA".
	 */
	public String site;

	/**
	 * Date: the starting date of the game, in YYYY.MM.DD form. "??" are used
	 * for unknown values.
	 */
	public Calendar date;

	/**
	 * Round: the playing round ordinal of the game within the event.
	 */
	public int round;

	/**
	 * White: the player of the white pieces, in "last name, first name" format.
	 */
	public String whiteName;

	/**
	 * Black: the player of the black pieces, same format as White.
	 */
	public String blackName;

	/**
	 * Result: the result of the game. This can only have four possible values:
	 * "1-0" (White won), "0-1" (Black won), "1/2-1/2" (Draw), or "*" (other,
	 * e.g., the game is ongoing).
	 */
	public boolean whiteWon;
	public boolean blackWon;
	private String result;

	public PGNList() {
		super();
	}

	public PGNList(String event, String site, Calendar date, int round,
			String whiteName, String blackName, boolean whiteWon,
			boolean blackWon) {
		super();
		this.event = event;
		this.site = site;
		this.date = date;
		this.round = round;
		this.whiteName = whiteName;
		this.blackName = blackName;

		this.onWin(whiteWon, blackWon);
	}

	public void onMove(int srcRank, int srcFile, int dstRank, int dstFile) {
		this.add(new CCPSourceDestPair(
				new ChessCoordinatePair(srcRank, srcFile),
				new ChessCoordinatePair(dstRank, dstFile)));
	}
	
	public void onMove(ChessCoordinatePair source, ChessCoordinatePair destination) {
		System.out.println("adding:" + source + " " + destination);
		this.add(new CCPSourceDestPair(source, destination));
	}
	
	public void onMove(CCPSourceDestPair ccpsdp) {
		this.add(ccpsdp);
	}

	public void onWin(boolean whiteWon, boolean blackWon) {
		this.whiteWon = whiteWon;
		this.blackWon = blackWon;

		if (this.whiteWon && !this.blackWon)
			this.result = "1-0";
		else if (!this.whiteWon && this.blackWon)
			this.result = "0-1";
		else if (this.whiteWon && this.blackWon) {
			this.result = "*";
		} else {
			this.result = "1/2-1/2";
		}
	}

	public void undoMove() {
		this.remove(this.size() - 1);
	}

	public CCPSourceDestPair getCurrentMove() {
		return this.get(this.size() - 1);
	}

	public String toString() {
		String game = "";

		game += ("[Event \"" + this.event + "\"]\n");
		game += ("[Site \"" + this.event + "\"]\n");
		game += ("[Date \"" + this.date.toString() + "\"]\n");
		game += ("[Round \"" + this.round + "\"]\n");
		game += ("[White \"" + this.whiteName + "\"]\n");
		game += ("[Black \"" + this.blackName + "\"]\n");
		game += ("[Result \"" + this.result + "\"]\n");

		for (int i = 0; i < this.size(); i++) {
			game += ("" + (i + 1) + ". " + this.get(i).toString());
		}

		return game;
	}
	
	public String movesToString() {
		String game = "";
		
		for (int i = 0; i < this.size(); i++) {
			game +=("" + (i + 1) + ". " + this.get(i).toString() + "\n");
		}
		
		return game;
	}
}
