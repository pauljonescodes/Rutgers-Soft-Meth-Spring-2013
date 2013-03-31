package model;

import java.util.ArrayList;

public class PhotoAlbumModel {
	private Library albums;

	public PhotoAlbumModel() {
		this.albums = new Library();
	}

	/*
	 * Album Methods
	 */

	/**
	 * Creates a new album.
	 * 
	 * @param albumName
	 * @throws PhotoAlbumException if the album already exists
	 */
	public void createAlbum(String albumName) throws PhotoAlbumException {
		this.albums.createAlbum(albumName);
	} 

	/**
	 * Deletes an old album.
	 * 
	 * @param albumName
	 * @throws PhotoAlbumException if the album does not exist
	 */
	public void deleteAlbum(String albumName) throws PhotoAlbumException {
		this.albums.deleteAlbum(albumName);
	}

	/**
	 * Returns an album with the given name.
	 * 
	 * @param albumName
	 * @return the instance of the album with the album name passed in
	 * @throws PhotoAlbumException
	 */
	public Album getAlbumWithName(String albumName)
			throws PhotoAlbumException {
		return this.albums.getAlbum(albumName);
	}

	/**
	 * Gets all album names
	 * 
	 * @return An array list containing only album names
	 */
	public ArrayList<String> getAlbumNames() {
		return this.albums.getAlbumNames();
	}

	/**
	 * @return the number of albums there are
	 */
	public int getNumberOfAlbums() {
		return this.albums.getNumberOfAlbums();
	}

	/**
	 * Gets the number of photos in an album.
	 * 
	 * @param albumName
	 * @return the number of photos in album
	 * @throws PhotoAlbumException if the album name does not exist
	 */
	public int getNumberOfPhotosInAlbum(String albumName)
			throws PhotoAlbumException {
		return this.albums.getAlbum(albumName).getNumberOfPhotos();
	}

	/**
	 * Get all photo names in an album
	 * 
	 * @param albumName
	 * @return ArrayList of photo names
	 * @throws PhotoAlbumException if the album name does not exist
	 */
	public ArrayList<String> getPhotoNamesForAlbum(String albumName)
			throws PhotoAlbumException {
		return this.albums.getAlbum(albumName).getPhotoNames();
	}

	/*
	 * Photo Methods
	 */

	/**
	 * Adds photo with caption to an album.
	 * 
	 * @param fileName
	 * @param caption
	 * @param albumName
	 * @throws PhotoAlbumException if the album does not exist or the photo already exists.
	 */
	public void addPhoto(String fileName, String caption, String albumName)
			throws PhotoAlbumException {
		this.albums.getAlbum(albumName).addPhoto(fileName, caption);
	}

	/**
	 * Moves photo from one album to another.
	 * 
	 * @param fileName
	 * @param oldAlbumName
	 * @param newAlbumName
	 * @throws PhotoAlbumException if either album does not exist or the photo does not exist in that album
	 */
	public void movePhoto(String fileName, String oldAlbumName, String newAlbumName) throws PhotoAlbumException {
		Photo temp = this.getAlbumWithName(oldAlbumName).getPhoto(fileName);
		
		System.out.println(temp.photoName);
		
		this.getAlbumWithName(oldAlbumName).removePhoto(fileName);
		this.getAlbumWithName(newAlbumName).addPhoto(temp);
	}

	/**
	 * Deletes a photo from an album.
	 * 
	 * @param fileName
	 * @param albumName
	 * @throws PhotoAlbumException if the photo does not exist in the album
	 */
	public void removePhoto(String fileName, String albumName)
			throws PhotoAlbumException {
		this.albums.getAlbum(albumName).removePhoto(fileName);
	}

	public void addTag(String fileName, String tagType, String tagValue) {

	}

	public void deleteTag(String fileName, String tagType, String tagValue) {

	}

	public void listPhotoInfo(String fileName) {

	}
}
