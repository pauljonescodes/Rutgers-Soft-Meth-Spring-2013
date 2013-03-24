package songLibrary;

/**
 * @author Paul Jones
 */

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SongDetailView extends JPanel {
	public JLabel nameLabel;
	public JLabel artistLabel;
	public JLabel albumLabel;
	public JLabel yearLabel;
	
	public SongDetailView() {
		super();
		
		this.setLayout(new GridLayout(4, 1));
		
		this.nameLabel = new JLabel("Song: ");
		this.artistLabel = new JLabel("Artist: ");
		this.albumLabel = new JLabel("Album: ");
		this.yearLabel = new JLabel("Year: ");
		
		this.addLabel(this.nameLabel, Component.LEFT_ALIGNMENT);
		this.addLabel(this.artistLabel, Component.LEFT_ALIGNMENT);
		this.addLabel(this.albumLabel, Component.LEFT_ALIGNMENT);
		this.addLabel(this.yearLabel, Component.LEFT_ALIGNMENT);
	}
	
	private void addLabel(JLabel label, float alignmentX) {
		label.setAlignmentX(alignmentX);
		this.add(label);
	}
	
	public void setSong(Song song) {
		this.nameLabel.setText("Song: " + song.name);
		this.artistLabel.setText("Artist: " + song.artist);
		this.albumLabel.setText("Album: " + song.album);
		this.yearLabel.setText("Year: " + song.year);
	}
}
