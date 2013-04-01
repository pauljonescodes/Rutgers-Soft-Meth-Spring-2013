package control;

import java.util.ArrayList;
import java.util.Calendar;

import model.Photo;
import model.PhotoAlbumException;
import model.PhotoAlbumModel;

/**
 * All formatting for the interactive view is done here. Everything is done with
 * pure strings.
 * 
 * This gets access to the pure data structures from the user's library, and
 * formats them into strings to give to the interactive view for printing.
 * 
 * @author Paul Jones
 * @author Sujish Patel
 */

public class InteractiveModeViewController {

	/**
	 * This is the source of all information regarding the model. All queries
	 * are sent from the InteractiveView, and passed along to the User, which
	 * passes back the relevant information, which is packaged for the
	 * InteractiveView to print.
	 */
	private final PhotoAlbumModel user;

	/**
	 * This is used by the InteractiveView to print in the cases where a boolean
	 * is retured, it is set in the constructor by the passed in User.
	 */
	public final String userId;

	/**
	 * Used by the main method to determine whether to continue running or not.
	 */
	public boolean isLoggedIn;

	/**
	 * Constructor. Sets userId based on this user.
	 * 
	 * @param user
	 *            User for this instance, through which all queries are made,
	 *            the information garnered is sent to the view.
	 */
	public InteractiveModeViewController(PhotoAlbumModel user) {
		this.user = user;
		this.userId = user.getUserName();

		isLoggedIn = true;
	}

	/**
	 * 
	 * Queries the user to create an album with the inputted album name.
	 * 
	 * The user returns the success of failure of the creation.
	 * 
	 * The overall structure is such that this success or failure will be
	 * returned to the view, which will tell the user about the success or
	 * failure.
	 * 
	 * This method is one of the exceptions to the "strings only" mandate listed
	 * at the top of this class.
	 * 
	 * @param albumName
	 *            The name of the album that the user will be queried to create.
	 * @throws PhotoAlbumException 
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#createAlbum(java.lang.String)
	 * 
	 * <!-- DONE -->
	 */
	public void createAlbum(String albumName) throws PhotoAlbumException {
		try {
			this.user.createAlbum(albumName);
		} catch (PhotoAlbumException e) {
			throw e;
		}
	}

	/**
	 * 
	 * Queries the user to delete an album with the inputted album name.
	 * 
	 * @param albumName
	 *            The name of the album the user will be queried to delete.
	 * @throws PhotoAlbumException 
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#deleteAlbum(java.lang.String)
	 */
	public void deleteAlbum(String albumName) throws PhotoAlbumException {
		try {
			this.user.deleteAlbum(albumName);
		} catch (PhotoAlbumException e) {
			throw e;
		} 
	}
	/**
	 * 
	 * Queries the user for a list of albums, which are returned as Album
	 * objects.
	 * 
	 * The albums are then formatted with the following format:
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#listAlbums()
	 */
	public ArrayList<String> listAlbums() {
		return this.user.getAlbumNames();
	}

	/**
	 * 
	 * Queries the user for a an album, where is then traversed and formatted
	 * into a string for the view.
	 * 
	 * @return List of photo names delimited by new line.
	 * 
	 *         Photos for album [name]: [fileName] - [date] ...
	 * @throws PhotoAlbumException 
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#listPhotos(java.lang.String)
	 */
	public ArrayList<String> listPhotos(String albumName) throws PhotoAlbumException {
		try {
			return this.user.getPhotoNamesForAlbum(albumName);
		} catch (PhotoAlbumException e) {
			throw e;
		}
	}

	/**
	 * Queries the user to add a photo, along with the arguments specified in
	 * interface this class implements.
	 * 
	 * Returns a boolean to the view, which it uses to decide what to print.
	 * @throws PhotoAlbumException 
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#addPhoto(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 *      
	 *      <!-- DONE -->
	 */
	public void addPhoto(String fileName, String caption, String albumName) throws PhotoAlbumException {
		try {
			this.user.addPhoto(fileName, caption, albumName);
		} catch (PhotoAlbumException e) {
			throw e;
		}
	}

	/**
	 * Queries the user for move a photo, and passes the boolean garnered from
	 * this query to the view.
	 * @throws PhotoAlbumException 
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#movePhoto(java.lang
	 *      .String, java.lang.String, java.lang.String)
	 */
	public void movePhoto(String fileName, String oldAlbumName,
			String newAlbumName) throws PhotoAlbumException {
		try {
			this.user.movePhoto(fileName, oldAlbumName, newAlbumName);
		} catch (PhotoAlbumException e) {
			throw e;
		}
	}

	/**
	 * Queries the user for move a photo, and passes the boolean garnered from
	 * this query to the view.
	 * @throws PhotoAlbumException 
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#removePhoto(java.lang
	 *      .String, java.lang.String)
	 */
	public void removePhoto(String fileName, String albumName) throws PhotoAlbumException {
		try {
			this.user.removePhoto(fileName, albumName);
		} catch (PhotoAlbumException e) {
			throw e;
		}
	}

	/**
	 * Calls the model to add a tag.
	 * 
	 * Expects a boolean back regarding the success or failure of the operation.
	 * 
	 * Sends the view a String to print based on this success or failure.
	 * @throws PhotoAlbumException 
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#addTag(java.lang.String
	 *      , java.lang.String, java.lang.String)
	 */
	public void addTag(String fileName, String tagType, String tagValue) throws PhotoAlbumException {
		try {
			this.user.addTag(tagType, tagValue, fileName);
		} catch (PhotoAlbumException e) {
			throw e;
		}
	}

	/**
	 * Calls the model to delete a tag.
	 * 
	 * Based on the boolean returned, sends the view a formatted String.
	 * @throws PhotoAlbumException 
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#deleteTag(java.lang
	 *      .String, java.lang.String, java.lang.String)
	 */
	public void deleteTag(String fileName, String tagType, String tagValue) throws PhotoAlbumException {
		try {
		this.deleteTag(fileName, tagType, tagValue);
		} catch (PhotoAlbumException pae) {
			throw pae;
		}
	}

	/**
	 * Usage: listPhotoInfo "fileName"
	 * 
	 * @return String with the following format: Photo file name: <fileName>
	 *         Album: <albumName>[,<albumName>]... Date: <date> Caption:
	 *         <caption> Tags:<tagType>:<tagValue> ... (grouped by tag type, in
	 *         the order location first, then people, and then others, sorted by
	 *         tag value within each type)
	 * 
	 *         Or: Photo <fileName> does not exist
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#listPhotoInfo(java.
	 *      lang.String)
	 */
	public String listPhotoInfo(String fileName) {
		try {
			return this.user.getPhoto(fileName).toString();
		} catch (PhotoAlbumException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Queries the user for photos between to calendar start date.
	 * 
	 * Expects from the user an ArrayList of Photos.
	 * 
	 * Sends to the view a formatted string for printing.
	 * 
	 * @return Photos for user <user id> in range <start date> to <end date>:
	 *         <caption> - Album: <albumName>[,<albumName>]... - Date: <date>
	 *         ...
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#getPhotosByDate()
	 */
	public ArrayList<Photo> getPhotosByDate(Calendar startDate, Calendar endDate) {
		try {
			return this.user.getPhotosInRange(startDate, endDate);
		} catch (PhotoAlbumException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @param tagType
	 *            A string representing this tags type, like a person, location,
	 *            theme. Must already exist.
	 * 
	 * @param tagValue
	 *            The actual content of the tag, like "San Francisco",
	 *            "John Smith", or "Wildlife." Must already exist.
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#getPhotosByTag(java
	 *      .lang.String, java.lang.String)
	 */
	public ArrayList<Photo> getPhotosByTag(String tagType, String tagValue) {
		try {
			return this.user.getPhotosByTag(tagType, tagValue);
		} catch (PhotoAlbumException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * Called by the view when the user inputs "logout."
	 * 
	 * Marks the beginning of the end in terms of program operation.
	 * 
	 * @see cs213.photoAlbum.control.PhotoAlbumViewController#logout()
	 */
	public void logout() {
		this.isLoggedIn = false;
	}
	
	public String getUserId() {
		return this.userId;
	}
}
