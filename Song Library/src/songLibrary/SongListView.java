package songLibrary;

/**
 * @author Paul Jones
 */

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class SongListView extends JPanel implements ListSelectionListener{

	public JList<String> list;
	public DefaultListModel<String> listModel;
	public JScrollPane scrollPane;
	public SongSelectionListener songSelectionListener;
	public SongServer songServer;

	public SongListView(SongSelectionListener songSelectionListener, SongServer songServer) {
		super(new BorderLayout());
		
		this.listModel = new DefaultListModel<String>();
		
		for (int i = 0; i < songServer.numberOfSongs(); i++) {
			this.listModel.add(i, songServer.getSongAtIndex(i).name);
		}
		
		this.list = new JList<String>(this.listModel);
		
		this.list.setSelectedIndex(0);
		this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.list.addListSelectionListener(this);

		this.songSelectionListener = songSelectionListener;
		this.songServer = songServer;

		scrollPane = new JScrollPane(list);

		super.add(scrollPane, BorderLayout.CENTER);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			for (int i = 0; i < songServer.numberOfSongs(); i++) {
				if (list.isSelectedIndex(i)) {
					songSelectionListener.songAtIndexWasSelected(i);
					break;
				}
			}
		}
	}
	
	public void setSongAtIndex(int index, Song song) {
		this.listModel.set(index, song.name);
	}
	
	public void removeSongAtIndex(int index) {
		this.listModel.remove(index);
	}
	
	public void addSong(Song song) {
		this.listModel.addElement(song.name);
	}
}
