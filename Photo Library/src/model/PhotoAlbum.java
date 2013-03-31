package model;

import java.util.ArrayList;

public class PhotoAlbum {
	
	public String albumName;
	private ArrayList<Photo> photos;
	
	protected PhotoAlbum(String albumName) {
		this.albumName = albumName;
		this.photos = new ArrayList<Photo>();
	}
	
	protected void addPhoto(String fileName, String caption) throws PhotoAlbumException {
		if (this.getPhotoIndex(fileName) >= 0) {
			throw new PhotoAlbumException("A photo with that name already exists.");
		} else {
			this.photos.add(new Photo(fileName, caption));
		}
	}

	protected void removePhoto(String fileName) throws PhotoAlbumException {
		if (this.getPhotoIndex(fileName) < 0) {
			throw new PhotoAlbumException("This photo does not exist.");
		} else {
			this.photos.remove(this.getPhotoIndex(fileName));
		}
	}
	
	protected int getNumberOfPhotos() {
		return this.photos.size();
	}
	
	private int getPhotoIndex(String photoName) {
		for (int i = 0; i < this.getNumberOfPhotos(); i++) {
			if (photos.get(i) != null && photos.get(i).photoName.compareTo(photoName) == 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	protected ArrayList<String> getPhotoNames() {
		ArrayList<String> photoNames = new ArrayList<String>(this.getNumberOfPhotos());
		
		for (int i = 0; i < this.getNumberOfPhotos(); i++) {
			if (this.photos.get(i) != null) {
				photoNames.add(this.photos.get(i).photoName);
			}
		}
		
		return photoNames;
	}
	
	protected String getAlbumName() {
		return albumName;
	}

	protected void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
}
