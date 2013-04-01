package model;

import java.util.ArrayList;
import java.util.Calendar;

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
	 * @throws PhotoAlbumException
	 *             if the album already exists
	 */
	public void createAlbum(String albumName) throws PhotoAlbumException {
		this.albums.createAlbum(albumName);
	}

	/**
	 * Deletes an old album.
	 * 
	 * @param albumName
	 * @throws PhotoAlbumException
	 *             if the album does not exist
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
	public Album getAlbum(String albumName) throws PhotoAlbumException {
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
	 * @throws PhotoAlbumException
	 *             if the album name does not exist
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
	 * @throws PhotoAlbumException
	 *             if the album name does not exist
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
	 * @throws PhotoAlbumException
	 *             if the album does not exist or the photo already exists.
	 */
	public void addPhoto(String fileName, String caption, String albumName)
			throws PhotoAlbumException {
		if (this.albums.hasPhoto(fileName)) {
			throw new PhotoAlbumException(
					"A photo with that filename already exists.");
		} else {
			this.albums.getAlbum(albumName).addPhoto(fileName, caption);
		}
	}

	/**
	 * Moves photo from one album to another.
	 * 
	 * @param fileName
	 * @param oldAlbumName
	 * @param newAlbumName
	 * @throws PhotoAlbumException
	 *             if either album does not exist or the photo does not exist in
	 *             that album
	 */
	public void movePhoto(String fileName, String oldAlbumName,
			String newAlbumName) throws PhotoAlbumException {
		Photo temp = this.getAlbum(oldAlbumName).getPhoto(fileName);

		this.getAlbum(oldAlbumName).removePhoto(fileName);
		this.getAlbum(newAlbumName).addPhoto(temp);
	}

	/**
	 * Deletes a photo from an album.
	 * 
	 * @param fileName
	 * @param albumName
	 * @throws PhotoAlbumException
	 *             if the photo does not exist in the album
	 */
	public void removePhoto(String fileName, String albumName)
			throws PhotoAlbumException {
		this.albums.getAlbum(albumName).removePhoto(fileName);
	}

	/**
	 * Gets an individual photo from the file name.
	 * 
	 * You will what to use this if you'd like the information contained within one photo.
	 * 
	 * @param fileName
	 * @return
	 * @throws PhotoAlbumException if the photo does not exist.
	 */
	public Photo getPhoto(String fileName) throws PhotoAlbumException {
		return this.albums.getPhoto(fileName);
	}

	/*
	 * Tag methods
	 */
	
	/**
	 * This gets a photo and adds a tag with the inputted values.
	 * 
	 * @param fileName
	 * @param tagType
	 * @param tagValue
	 * @throws PhotoAlbumException if the photo does not exist or the tag already exists.
	 */
	public void addTag(String fileName, String tagType, String tagValue)
			throws PhotoAlbumException {
		this.getPhoto(fileName).addTag(tagType, tagValue);
	}

	/**
	 * Gets the photo and deletes the tag with the inputted values.
	 * 
	 * @param fileName
	 * @param tagType
	 * @param tagValue
	 * @throws PhotoAlbumException if the tag or the photo DNE
	 */
	public void deleteTag(String fileName, String tagType, String tagValue)
			throws PhotoAlbumException {
		this.getPhoto(fileName).deleteTag(tagType, tagValue);
	}

	/**
	 * Gets a single photo and returns its toString() value
	 * 
	 * @param fileName
	 * @return
	 * @throws PhotoAlbumException if the photo DNE
	 */
	public String getPhotoInfo(String fileName) throws PhotoAlbumException {
		return this.getPhoto(fileName).toString();
	}

	/**
	 * To retrieve photos between two dates.
	 * 
	 * @param first the date which you want every photo "after"
	 * @param second the date which you want every photo "before"
	 * @return
	 * @throws PhotoAlbumException if there are no photos in that ranged
	 */
	public ArrayList<Photo> getPhotosInRange(Calendar first, Calendar second) throws PhotoAlbumException {
		return this.albums.getPhotosInRange(first, second);
	}
	
	/**
	 * Returns an array list with every photo with a given tag.
	 * 
	 * @param tagType
	 * @param tagValue
	 * @return
	 * @throws PhotoAlbumException if the tag does not exist
	 */
	public ArrayList<Photo> getPhotosByTag(String tagType, String tagValue) throws PhotoAlbumException {
		return this.albums.getPhotosByTag(tagType, tagValue);
	}
}
