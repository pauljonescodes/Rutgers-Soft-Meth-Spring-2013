package songLibrary;

/**
 * @author Paul Jones
 */

public interface SongServer {
	public int numberOfSongs();
	public Song getSongAtIndex(int i);
	public Song getCurrentlySelectedSong();
}
