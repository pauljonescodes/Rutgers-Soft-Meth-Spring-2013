package songLibrary;

/**
 * @author Paul Jones
 */

import java.util.ArrayList;

public class SongLib {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Song> songs = new ArrayList<Song>();
		
		SongLibraryView root = new SongLibraryView(songs);
		root.setVisible(true);
	}
	
	
}
