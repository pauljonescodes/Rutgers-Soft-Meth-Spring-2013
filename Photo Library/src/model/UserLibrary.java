package model;

import java.util.ArrayList;

public class UserLibrary {
	private AlbumLibrary albums;
	
	public UserLibrary() {
		this.albums = new AlbumLibrary();
	}
	
	public void createAlbum(String albumName) throws PhotoAlbumException {
		try {
			this.albums.createAlbum(albumName);
		} catch (PhotoAlbumException pae) {
			throw pae;
		}
	}
	
	public void deleteAlbum(String albumName) throws PhotoAlbumException {
		try {
			this.albums.deleteAlbum(albumName);
		} catch (PhotoAlbumException pae) {
			throw pae;
		}
	}
	
	public ArrayList<String> getAlbumNames() {
		return this.albums.getAlbumNames();
	}
	
	public int getNumberOfAlbums() {
		return this.albums.getNumberOfAlbums();
	}
	
	public ArrayList<String> getPhotoNames(String forAlbum) {
		
		return null;
	}
	
	public void addPhoto (String fileName, String caption, String albumName) throws PhotoAlbumException {
		
	}
	
	public void movePhoto (String fileName, String oldAlbumName, String newAlbumName) throws PhotoAlbumException {
		
	}
	
	public void removePhoto (String fileName, String albumName) throws PhotoAlbumException {
		
	}
	
	public void addTag (String fileName, String tagType, String tagValue) {
		
	}
	
	public void deleteTag (String fileName, String tagType, String tagValue) {
		
	}
	
	public void listPhotoInfo (String fileName) {
		
	}
}
