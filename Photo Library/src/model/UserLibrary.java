package model;

import java.util.ArrayList;

public class UserLibrary {
	private AlbumLibrary albums;

	public UserLibrary() {
		this.albums = new AlbumLibrary();
	}

	/*
	 * Album Methods
	 */

	public void createAlbum(String albumName) throws PhotoAlbumException {
		this.albums.createAlbum(albumName);
	}

	public void deleteAlbum(String albumName) throws PhotoAlbumException {
		this.albums.deleteAlbum(albumName);
	}

	public PhotoAlbum getAlbumWithName(String albumName)
			throws PhotoAlbumException {
		return this.albums.getAlbumWithName(albumName);
	}

	public ArrayList<String> getAlbumNames() {
		return this.albums.getAlbumNames();
	}

	public int getNumberOfAlbums() {
		return this.albums.getNumberOfAlbums();
	}

	public int getNumberOfPhotosInAlbum(String albumName)
			throws PhotoAlbumException {
		return this.albums.getAlbumWithName(albumName).getNumberOfPhotos();
	}

	public ArrayList<String> getPhotoNamesForAlbum(String albumName)
			throws PhotoAlbumException {
		return this.albums.getAlbumWithName(albumName).getPhotoNames();
	}

	/*
	 * Photo Methods
	 */

	public void addPhoto(String fileName, String caption, String albumName)
			throws PhotoAlbumException {
		this.albums.getAlbumWithName(albumName).addPhoto(fileName, caption);
	}

	public void movePhoto(String fileName, String oldAlbumName,
			String newAlbumName) throws PhotoAlbumException {

	}

	public void removePhoto(String fileName, String albumName)
			throws PhotoAlbumException {
		this.albums.getAlbumWithName(albumName).removePhoto(fileName);
	}

	public void addTag(String fileName, String tagType, String tagValue) {

	}

	public void deleteTag(String fileName, String tagType, String tagValue) {

	}

	public void listPhotoInfo(String fileName) {

	}
}
