package songLibrary;

/**
 * @author Paul Jones
 */

import java.awt.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SongLibraryView extends JFrame implements SongSelectionListener, SongEditListener, SongServer {

	public SongListView listView;
	public SongDetailView detailView;
	public SongEditView editView;
	public ArrayList<Song> songs;
	int currentlySelectedIndex;
	
	public SongLibraryView(ArrayList<Song> songs) {
		super("Song Library");
		
		this.setLayout(new GridLayout(0, 3));
		
		this.songs = songs;
		
		listView = new SongListView(this, this);
		detailView = new SongDetailView();
		editView = new SongEditView(this, this);
		
		getContentPane().add(listView);
		getContentPane().add(detailView);
		getContentPane().add(editView);
		
		pack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setSize(800, 600);
		setMinimumSize(new Dimension(350, 225));
	}

	@Override
	public void songAtIndexWasSelected(int index) {
		this.detailView.setSong(songs.get(index));
		currentlySelectedIndex = index;
	}

	@Override
	public void deleteCurrentlySelectedSong() {
		this.songs.remove(currentlySelectedIndex);
		this.listView.removeSongAtIndex(currentlySelectedIndex);
		this.listView.list.setEnabled(true);
		
		if (this.songs.size() > 0) {
			this.detailView.setSong(songs.get(0));
			this.listView.list.setSelectedIndex(0);
		} else {
			this.detailView.setSong(new Song());
		}
	}

	@Override
	public void updateCurrentlySelectedSong(Song song) {
		this.songs.set(currentlySelectedIndex, song);
		this.listView.setSongAtIndex(currentlySelectedIndex, song);
		
		if (this.songs.size() > 0) {
			this.detailView.setSong(songs.get(0));
			this.listView.list.setSelectedIndex(0);
		}
	}

	@Override
	public void addSong(Song song) {
		this.songs.add(song);
		this.listView.addSong(song);
		
		if (this.songs.size() > 0) {
			this.detailView.setSong(songs.get(0));
			this.listView.list.setSelectedIndex(0);
		}
	}
	
	@Override
	public Song getCurrentlySelectedSong() {
		return songs.get(currentlySelectedIndex);
	}

	@Override
	public int numberOfSongs() {
		return songs.size();
	}

	@Override
	public Song getSongAtIndex(int i) {
		return songs.get(i);
	}

	@Override
	public void enteringEdit() {
		this.listView.list.setEnabled(false);
		
	}

	@Override
	public void exitingEdit() {
		this.listView.list.setEnabled(true);
		this.detailView.setSong(songs.get(currentlySelectedIndex));
	}
}
