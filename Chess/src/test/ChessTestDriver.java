package test;

import java.util.ArrayList;

import util.*;
import model.pieces.*;

/**
 * 
 * @author Paul Jones
 *
 */

public class ChessTestDriver {
	
	public static void main(String[] args) {
		ChessCoordinatePair ccpone = new ChessCoordinatePair(0, 0);
		ChessCoordinatePair ccptwo = new ChessCoordinatePair(0, 7);
		
		ccpone.file = 1;
		ccpone.rank = 1;
		
		ccptwo.file = 3;
		ccptwo.rank = 5;
		
		System.out.println(ccpone.isDiagonalTo(ccptwo));
		
		RookChessPiece rcp = new RookChessPiece(false);
		ArrayList<ChessCoordinatePair> deepestMoves = rcp.deepestMovesFrom(ccpone);
		
		System.out.println("Deepest moves for Rook at " + ccpone);
		for (int i = 0; i < deepestMoves.size(); i++) {
			System.out.println(deepestMoves.get(i));
		}
		
		KnightChessPiece kcp = new KnightChessPiece(false);
		deepestMoves = kcp.deepestMovesFrom(ccpone);
		
		System.out.println("Deepest moves for Knight at " + ccpone);
		for (int i = 0; i < deepestMoves.size(); i++) {
			System.out.println(deepestMoves.get(i));
		}
		
		for (int fileone = 0; fileone < 8; fileone++) {
			ccpone.file = fileone;
			for (int rankone = 0; rankone < 8; rankone++) {
				ccpone.rank = rankone;
				for (int ranktwo = 0; ranktwo < 8; ranktwo++) {
					ccptwo.rank = ranktwo;
					for (int filetwo = 0; filetwo < 8; filetwo++) {
						ccptwo.file = filetwo;
						
						boolean fileCompareShouldBe;
						
						if (fileone == filetwo) {
							fileCompareShouldBe = true;
						} else {
							fileCompareShouldBe = false;
						}
						
						if (ccpone.hasSameFileAs(ccptwo) != fileCompareShouldBe)
							System.out.println("Failure");
						
						boolean rankCompareShouldBe;
						
						if (rankone == ranktwo) {
							rankCompareShouldBe = true;
						} else {
							rankCompareShouldBe = false;
						}
						
						if (ccpone.hasSameRankAs(ccptwo) != rankCompareShouldBe)
							System.out.println("Failure");
						
						boolean equalsShouldBe;
						
						if (fileCompareShouldBe && rankCompareShouldBe) {
							equalsShouldBe = true;
						} else {
							equalsShouldBe = false;
						}
						
						if (ccpone.equals(ccptwo) != equalsShouldBe) {
							System.out.println("Failure for: " + ccpone.toString() + " and " + ccptwo.toString());
						}
						
						boolean adjacentShouldBe = false;;
						
						if ((rankone == ranktwo + 1 || rankone == ranktwo - 1) && fileone == filetwo) {
							adjacentShouldBe = true;
						} else if ((fileone == filetwo + 1 || fileone == filetwo - 1) && rankone == ranktwo) {
							adjacentShouldBe = true;
						}
						
						
					}
				}
			}
			
			
			
			System.out.println();
		}
	}

}
