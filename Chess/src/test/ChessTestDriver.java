package test;

import util.*;

public class ChessTestDriver {
	
	public static void main(String[] args) {
		ChessCoordinatePair ccpone = new ChessCoordinatePair(0, 0);
		ChessCoordinatePair ccptwo = new ChessCoordinatePair(0, 7);
		
		ccpone.file = 5;
		ccpone.rank = 3;
		
		ccptwo.file = 3;
		ccptwo.rank = 5;
		
		System.out.println(ccpone.isDiagonalTo(ccptwo));
		
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
