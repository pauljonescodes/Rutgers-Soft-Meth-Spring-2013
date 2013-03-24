package songLibrary;

/**
 * @author Paul Jones
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class SongEditView extends JPanel {
	public JButton editButton;
	public JButton deleteButton;
	public JButton addButton;
	public JButton doneButton;
	
	public JTextField songNameTextField;
	public JTextField songArtistTextField; 
	public JTextField songAlbumTextField;
	public JTextField songYearTextField;
	
	public SongEditListener songEditListener;
	public SongServer songServer;
	
	private boolean adding;
	private boolean editing;
	
	public SongEditView(final SongEditListener songEditListener, final SongServer songServer) {
		super();
		
		this.setLayout(new GridLayout(6, 0));
		
		this.songEditListener = songEditListener;
		this.songServer = songServer;
		
		this.songNameTextField = new JTextField();
		this.songArtistTextField = new JTextField();
		this.songAlbumTextField = new JTextField();
		this.songYearTextField = new JTextField();
		
		this.songNameTextField.setEnabled(false);
		this.songArtistTextField.setEnabled(false);
		this.songAlbumTextField.setEnabled(false);
		this.songYearTextField.setEnabled(false);
		
		this.editButton = new JButton("Edit");
		this.doneButton = new JButton("Done");
		this.doneButton.setEnabled(false);
		
		this.deleteButton = new JButton("Delete");
		this.addButton = new JButton("Add");
		this.deleteButton.setEnabled(false);
		
		if (this.songServer.numberOfSongs() == 0)
			this.editButton.setEnabled(false);
		
		this.editButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editing = true;
				
				editButton.setEnabled(false);
				doneButton.setEnabled(true);
				deleteButton.setEnabled(true);
				addButton.setEnabled(false);
				
				songNameTextField.setEnabled(true);
				songArtistTextField.setEnabled(true);
				songAlbumTextField.setEnabled(true);
				songYearTextField.setEnabled(true);
				
				songNameTextField.setText(songServer.getCurrentlySelectedSong().name);
				songArtistTextField.setText(songServer.getCurrentlySelectedSong().artist);
				songAlbumTextField.setText(songServer.getCurrentlySelectedSong().album);
				songYearTextField.setText(songServer.getCurrentlySelectedSong().year);
				
				songEditListener.enteringEdit();
			}
			
		});
		
		this.addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				adding = true;
				
				editButton.setEnabled(false);
				doneButton.setEnabled(true);
				deleteButton.setEnabled(false);
				addButton.setEnabled(false);
				
				songNameTextField.setEnabled(true);
				songArtistTextField.setEnabled(true);
				songAlbumTextField.setEnabled(true);
				songYearTextField.setEnabled(true);
				
			}
			
		});
		
		this.deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editButton.setEnabled(true);
				doneButton.setEnabled(false);
				deleteButton.setEnabled(false);
				addButton.setEnabled(true);
				
				songNameTextField.setEnabled(false);
				songArtistTextField.setEnabled(false);
				songAlbumTextField.setEnabled(false);
				songYearTextField.setEnabled(false);
				
				songEditListener.deleteCurrentlySelectedSong();
				songNameTextField.setText("");
				songArtistTextField.setText("");
				songAlbumTextField.setText("");
				songYearTextField.setText("");
				
				if (songServer.numberOfSongs() == 0) {
					editButton.setEnabled(false);
				}
			}
			
		});
		
		this.doneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editButton.setEnabled(true);
				doneButton.setEnabled(false);
				deleteButton.setEnabled(false);
				addButton.setEnabled(true);
				
				songNameTextField.setEnabled(false);
				songArtistTextField.setEnabled(false);
				songAlbumTextField.setEnabled(false);
				songYearTextField.setEnabled(false);
				
				if(adding) {
					songEditListener.addSong(new Song(songNameTextField.getText(), 
							songArtistTextField.getText(), 
							songAlbumTextField.getText(), 
							songYearTextField.getText()));
					
					adding = false;
				}
				
				if (editing) {
					
					songEditListener.updateCurrentlySelectedSong(new Song(songNameTextField.getText(), 
							songArtistTextField.getText(), 
							songAlbumTextField.getText(), 
							songYearTextField.getText()));
					
					editing = false;
				}
				
				songNameTextField.setText("");
				songArtistTextField.setText("");
				songAlbumTextField.setText("");
				songYearTextField.setText("");
				
				songEditListener.exitingEdit();
			}
			
			
		});
		
		JPanel editPanel = new JPanel(new GridLayout(0, 2));
		JPanel addDeletePanel = new JPanel(new GridLayout(0,2));
		
		JPanel songNameFieldPanel = new JPanel(new BorderLayout());
		songNameFieldPanel.add(this.songNameTextField, BorderLayout.CENTER);
		songNameFieldPanel.add(new JLabel("Song (required)"), BorderLayout.PAGE_START);
		
		JPanel songArtistFieldPanel = new JPanel(new BorderLayout());
		songArtistFieldPanel.add(songArtistTextField, BorderLayout.CENTER);
		songArtistFieldPanel.add(new JLabel("Artist (required)"), BorderLayout.PAGE_START);
		
		JPanel songAlbumFieldPanel = new JPanel(new BorderLayout());
		songAlbumFieldPanel.add(songAlbumTextField, BorderLayout.CENTER);
		songAlbumFieldPanel.add(new JLabel("Album"), BorderLayout.PAGE_START);
		
		JPanel songYearFieldPanel = new JPanel(new BorderLayout());
		songYearFieldPanel.add(songYearTextField, BorderLayout.CENTER);
		songYearFieldPanel.add(new JLabel("Year"), BorderLayout.PAGE_START);
		
		editPanel.add(editButton);
		editPanel.add(doneButton);
		
		addDeletePanel.add(addButton);
		addDeletePanel.add(deleteButton);
		
		this.add(editPanel);
		this.add(songNameFieldPanel);
		this.add(songArtistFieldPanel);
		this.add(songAlbumFieldPanel);
		this.add(songYearFieldPanel);
		this.add(addDeletePanel);
	}
}
