package model;

import java.util.ArrayList;

public class Library {

	private ArrayList<Album> albums;
	
	public Library() {
		this.albums = new ArrayList<Album>();
	}
	
	protected void createAlbum(String albumName) throws PhotoAlbumException {
		if (this.getAlbumIndex(albumName) >= 0) {
			throw new PhotoAlbumException("An album with that name already exists!");
		} else {
			this.albums.add(new Album(albumName));
		}
	}

	protected void deleteAlbum(String albumName) throws PhotoAlbumException {
		if (this.getAlbumIndex(albumName) < 0) {
			throw new PhotoAlbumException("No album with that name exists!");
		} else {
			this.albums.remove(this.getAlbumIndex(albumName));
		}
	}

	protected void renameAlbum(String oldAlbumName, String newAlbumName) throws PhotoAlbumException {
		if (this.getAlbumIndex(oldAlbumName) < 0) {
			throw new PhotoAlbumException("No album with that name exists!");
		} else {
			this.albums.get(this.getAlbumIndex(oldAlbumName)).setAlbumName(newAlbumName);
		}
	}
	
	protected Album getAlbum(String albumName) throws PhotoAlbumException {
		if (this.getAlbumIndex(albumName) < 0) {
			throw new PhotoAlbumException("No album with that name exists!");
		} else {
			for (int i = 0; i < this.getNumberOfAlbums(); i++) {
				if (this.albums.get(i) != null && this.albums.get(i).albumName.compareTo(albumName) == 0) {
					return this.albums.get(i);
				}
			}
		}
		
		return null;
	}
	
	private int getAlbumIndex(String albumName) {
		for (int i = 0; i < this.getNumberOfAlbums(); i++) {
			if (albums.get(i) != null && albums.get(i).albumName.compareTo(albumName) == 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	protected ArrayList<String> getAlbumNames() {
		ArrayList<String> albumNames = new ArrayList<String>(this.getNumberOfAlbums());
		
		for (int i = 0; i < this.getNumberOfAlbums(); i++) {
			if (this.albums.get(i) != null) {
				albumNames.add(this.albums.get(i).albumName);
			}
		}
		
		return albumNames;
	}
	
	public int getNumberOfAlbums() {
		return this.albums.size();
	}
	
	protected ArrayList<Photo> getPhotosByTag(String tagType, String tagValue) throws PhotoAlbumException {
		ArrayList<Photo> photosWithTag = new ArrayList<Photo>();
		ArrayList<String> albumNames = this.getAlbumNames();
		
		for (String albumName : albumNames) {
			ArrayList<String> photoNames = this.getAlbum(albumName).getPhotoNames();
			
			for (String photoName : photoNames) {
				if (this.getPhoto(photoName).hasTag(tagType, tagValue)) {
					photosWithTag.add(this.getPhoto(photoName));
				}
			}
		} 
		
		if (photosWithTag.size() == 0)
			throw new PhotoAlbumException("That tag does not exist.");
		
		return photosWithTag;
	}
	
	protected Photo getPhoto(String photoName) throws PhotoAlbumException{
		ArrayList<String> albumNames = this.getAlbumNames();
		
		for (String albumName : albumNames) {
			if (this.getAlbum(albumName).hasPhoto(photoName)) {
				return this.getAlbum(albumName).getPhoto(photoName);
			}
		} 
		
		throw new PhotoAlbumException("That photo does not exist.");
	}
	
	public boolean hasPhoto(String photoName) {
		for (Album album : this.albums) {
			if (album.hasPhoto(photoName)) {
				return true;
			}
		} 
		
		return false;
	}
}
