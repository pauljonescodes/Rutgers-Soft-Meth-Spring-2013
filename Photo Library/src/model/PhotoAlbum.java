package model;

import java.util.ArrayList;

public class PhotoAlbum {
	
	public String albumName;
	public ArrayList<Photo> photos;
	
	public PhotoAlbum(String albumName) {
		this.albumName = albumName;
	}
	
	public void addPhoto() {
		
	}
	
	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public void removePhoto() {
		
	}
}
