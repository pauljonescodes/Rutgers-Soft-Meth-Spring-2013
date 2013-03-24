package songLibrary;

/**
 * @author Paul Jones
 */

public interface SongEditListener {
	public void deleteCurrentlySelectedSong();
	public void updateCurrentlySelectedSong(Song song);
	public void addSong(Song song);
	public void enteringEdit();
	public void exitingEdit();
}
