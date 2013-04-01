package simpleview;

import java.util.ArrayList;
import java.util.Calendar;

import model.PhotoAlbumException;

import control.InteractiveModeViewController;

/**
 * 
 * This is a command line view which accepts an argument and prints to the
 * terminal the response.
 * 
 * There are no graphical elements besides printing.
 * 
 * In the overall structure of this photo album implementation, all printing is
 * done here.
 * 
 * This class knows nothing about data structures or context, it simply accepts
 * an argument, and prints out what the view controller feeds to it.
 * 
 * This view is "success/failure" sensitive - if the view controller passes a
 * "false" back to here, this code decides to print the failure.
 * 
 * Repeat for clarity: ALL PRINTING TO THE COMMAND LINE IS DONE HERE.
 * 
 * @author Paul Jones
 * @author Sujish Patel
 */
public class InteractiveView {
	/**
	 * This non-specific interface is the only required field for this class.
	 * 
	 * This view knows nothing about implementation, or data structures, or
	 * overall structure.
	 * 
	 * Every time this class works out the argument that it was sent, it queries
	 * the view controller for a String or a series of Strings.
	 * 
	 * The view controller makes sure the Strings are in the proper format, and
	 * this view blindly prints them out.
	 */
	public InteractiveModeViewController viewController;

	/**
	 * 
	 * This is the main method, it simply accepts the view controller that this
	 * instance will use to complete and query operations.
	 * 
	 * @param viewController
	 *            The view controller associated with this instance, where all
	 *            queries are sent. Everything returned from the view controller
	 *            is printed here.
	 */
	public InteractiveView(InteractiveModeViewController viewController) {
		this.viewController = viewController;
	}

	/**
	 * 
	 * The only public method for this class. Accepts an argument which is
	 * parsed here, determines what the user intends to do, and send off the
	 * necessary internal call to a private method.
	 * 
	 * @param arg
	 *            The argument to execute.
	 */
	public void giveArgument(String arg) {
		if (arg.compareTo("logout") == 0) {
			logout();
		} else if (arg.compareTo("listAlbums") == 0) { /* WORKS */
			this.listAlbums();
		} else if (arg.contains("createAlbum \"")) { /* WORKS */
			try {
				String albumName = arg.substring(arg.indexOf('"') + 1,
						arg.lastIndexOf('"'));
				this.createAlbum(albumName);
			} catch (Exception e) {
				System.out.println("Create album formatting wrong, try again");
			}
		} else if (arg.contains("deleteAlbum \"")) { /* WORKS */
			try {
				String albumName = arg.substring(arg.indexOf('"') + 1,
						arg.lastIndexOf('"'));
				this.deleteAlbum(albumName);
			} catch (Exception e) {
				System.out
						.println("Delete album formatting incorrect, try again");
			}
		} else if (arg.contains("addPhoto \"")) { /* WORKS */
			try {
				int startIndexFileName = arg.indexOf('"');
				int endIndexFileName = arg.indexOf('"', startIndexFileName + 1);
				int startIndexCaption = arg.indexOf('"', endIndexFileName + 1);
				int endIndexCaption = arg.indexOf('"', startIndexCaption + 1);
				int startIndexAlbumName = arg.indexOf('"', endIndexCaption + 1);
				int endIndexAlbumName = arg.indexOf('"',
						startIndexAlbumName + 1);

				String fileName = arg.substring(startIndexFileName + 1,
						endIndexFileName);
				String caption = arg.substring(startIndexCaption + 1,
						endIndexCaption);
				String albumName = arg.substring(startIndexAlbumName + 1,
						endIndexAlbumName);

				this.addPhoto(fileName, caption, albumName);
			} catch (Exception e) {
				System.out
						.println("Formatting on addPhoto incorrect, try again");
			}
		} else if (arg.contains("listPhotos \"")) { /* WORKS */
			try {
				int startIndexFileName = arg.indexOf('"');
				int endIndexFileName = arg.indexOf('"', startIndexFileName + 1);

				this.listPhotos(arg.substring(startIndexFileName + 1,
						endIndexFileName));
			} catch (Exception e) {
				System.out
						.println("Tried to list photos in album but formatting was incorrect"
								+ e.getLocalizedMessage());
			}
		} else if (arg.contains("removePhoto \"")) {
			/*
			 * Output: Removed photo: <fileName> - From album <albumName> Or:
			 * Photo <fileName> is not in album <albumName>
			 */

			try {
				int startIndexFileName = arg.indexOf('"');
				int endIndexFileName = arg.indexOf('"', startIndexFileName + 1);
				int startIndexOldAlbum = arg.indexOf('"', endIndexFileName + 1);
				int endIndexOldAlbum = arg.indexOf('"', startIndexOldAlbum + 1);

				String fileName = arg.substring(startIndexFileName + 1,
						endIndexFileName);
				String albumName = arg.substring(startIndexOldAlbum + 1,
						endIndexOldAlbum);

				this.removePhoto(fileName, albumName);
			} catch (Exception e) {
				System.out.println("Remove photo formatting wrong, try again");
			}

		} else if (arg.contains("movePhoto \"")) {
			/*
			 * movePhoto "<fileName>" "<oldAlbumName>" "<newAlbumName>"
			 * 
			 * Output: Moved photo <fileName>: <fileName> - From album
			 * <oldAlbumName> to album <newAlbumName> Or: Photo <fileName> does
			 * not exist in <oldAlbumName>
			 */
			try {
				int startIndexFileName = arg.indexOf('"');
				int endIndexFileName = arg.indexOf('"', startIndexFileName + 1);
				int startIndexOldAlbum = arg.indexOf('"', endIndexFileName + 1);
				int endIndexOldAlbum = arg.indexOf('"', startIndexOldAlbum + 1);
				int startIndexNewAlbum = arg.indexOf('"', endIndexOldAlbum + 1);
				int endIndexNewAlbum = arg.indexOf('"', startIndexNewAlbum + 1);

				String fileName = arg.substring(startIndexFileName + 1,
						endIndexFileName);
				String oldAlbumName = arg.substring(startIndexOldAlbum + 1,
						endIndexOldAlbum);
				String newAlbumName = arg.substring(startIndexNewAlbum + 1,
						endIndexNewAlbum);

				this.movePhoto(fileName, oldAlbumName, newAlbumName);
			} catch (Exception e) {
				System.out
						.println("You tried to move a photo but your formmating was incorrect, try again");
			}
		} else if (arg.contains("addTag \"")) {
			/*
			 * addTag "<fileName>" <tagType>:"<tagValue>"
			 * 
			 * Output: Added tag: <fileName> <tagType>:<tagValue> Or: Tag
			 * already exists for <fileName> <tagType>:<tagValue>
			 */

			try {
				int startIndexFileName = arg.indexOf('"');
				int endIndexFileName = arg.indexOf('"', startIndexFileName + 1);
				int startIndextagType = endIndexFileName + 2;
				int endIndexOldAlbum = arg.indexOf(':', startIndextagType + 1);
				int startIndexNewAlbum = arg.indexOf('"', endIndexOldAlbum + 1);
				int endIndexNewAlbum = arg.indexOf('"', startIndexNewAlbum + 1);

				String fileName = arg.substring(startIndexFileName + 1,
						endIndexFileName);
				String tagType = arg.substring(startIndextagType + 1,
						endIndexOldAlbum);
				String tagValue = arg.substring(startIndexNewAlbum + 1,
						endIndexNewAlbum);

				this.addTag(fileName, tagType, tagValue);
			} catch (Exception e) {
				System.out
						.println("You tried to add a tag but formmated the input incorrectly");
			}
		} else if (arg.contains("deleteTag \"")) {
			try {
				int startIndexFileName = arg.indexOf('"');
				int endIndexFileName = arg.indexOf('"', startIndexFileName + 1);
				int startIndextagType = endIndexFileName + 2;
				int endIndexOldAlbum = arg.indexOf(':', startIndextagType + 1);
				int startIndexNewAlbum = arg.indexOf('"', endIndexOldAlbum + 1);
				int endIndexNewAlbum = arg.indexOf('"', startIndexNewAlbum + 1);

				String fileName = arg.substring(startIndexFileName + 1,
						endIndexFileName);
				String tagType = arg.substring(startIndextagType + 1,
						endIndexOldAlbum);
				String tagValue = arg.substring(startIndexNewAlbum + 1,
						endIndexNewAlbum);

				this.deleteTag(fileName, tagType, tagValue);
			} catch (Exception e) {
				System.out
						.println("You tried to delete a tag but your formmating was incorrect, try again");
			}
		} else if (arg.contains("listPhotoInfo \"")) {
			try {
				int startIndexFileName = arg.indexOf('"');
				int endIndexFileName = arg.indexOf('"', startIndexFileName + 1);
				String fileName = arg.substring(startIndexFileName + 1,
						endIndexFileName);

				this.listPhotoInfo(fileName);
			} catch (Exception e) {
				System.out
						.println("You tried to list phot info, but your formatting was incorrect");
			}
		} else {
			System.out.println("That command was not recognized.");
		}
	}

	/**
	 * 
	 * To create an album.
	 * 
	 * Queries the view controller to create an album with the inputed name.
	 * 
	 * Queries the view controller for the name to be printed.
	 * 
	 * If successful, the following is printed:
	 * 
	 * created album for user [user id]: [name]
	 * 
	 * If unsuccessful,
	 * 
	 * album exists for user [user id]: [name]
	 * 
	 * @param albumName
	 *            The name of the album the user wishes to create.
	 */
	private void createAlbum(String albumName) {
		try {
			this.viewController.createAlbum(albumName);
			System.out.println("created album for user "
					+ this.viewController.userId + ": ");
			System.out.println(albumName);
		} catch (PhotoAlbumException e) {
			System.out.println("album exists for user " + this.viewController.userId + ":");
			System.out.println(albumName + "\t\t" + e.getLocalizedMessage());
		}
	}

	/**
	 * 
	 * To delete an album.
	 * 
	 * If successful, the following is printed:
	 * 
	 * deleted album from user [user id]
	 * 
	 * Otherwise:
	 * 
	 * album does not exist for user [user id]
	 * 
	 * @param albumName
	 */
	private void deleteAlbum(String albumName) {
		try {
			this.viewController.deleteAlbum(albumName);
			System.out.println("deleted album from user "
					+ this.viewController.userId);
			System.out.println(albumName);
		} catch (PhotoAlbumException e) {
			System.out.println("album does not exist for user " + this.viewController.userId + ":");
			System.out.println(albumName + "\t\t" + e.getLocalizedMessage());
		}
	}

	/**
	 * 
	 * To list all albums, with their number of photos and the range of dates
	 * that the photos were taken:
	 * 
	 * The returned string from the view controller will include new lines, so
	 * all that has to be done here is a print.
	 * 
	 */
	private void listAlbums() {
		ArrayList<String> albums = this.viewController.listAlbums();

		if (albums.size() >= 1) {
			System.out.println("Albums for user "
					+ this.viewController.getUserId() + ":");
			for (String s : albums) {
				System.out.println(s);
			}
		} else {
			System.out.println("No albums exist for user "
					+ this.viewController.getUserId());
		}
	}

	/**
	 * 
	 * To list the photos in an album
	 * 
	 * @param albumName
	 *            The name of the album that the caller wishes to print to the
	 *            terminal
	 * 
	 *            This method blindly prints what the view controller returns.
	 * 
	 */
	private void listPhotos(String albumName) {
		ArrayList<String> photos;

		try {
			photos = this.viewController.listPhotos(albumName);

			System.out.println("Photos for albums " + albumName + ":");

			if (photos != null && photos.size() > 0) {
				for (String s : photos) {
					System.out.println("\t" + s);
				}
			} else {
				System.out.println("No albums exists for user "
						+ this.viewController.getUserId());
			}

		} catch (PhotoAlbumException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	/**
	 * 
	 * Usage: addPhoto [fileName] [caption] [albumName]
	 * 
	 * Adds the photo found in file name with caption caption to album
	 * albumName.
	 * 
	 * @return Added photo <fileName>: <caption> - Album: <albumName>
	 * @return Photo <fileName> already exists in album <albumName>
	 * @return File <fileName> does not exist
	 * 
	 * @param fileName
	 *            The name of the location of the photo the user wishes to
	 *            input.
	 * @param caption
	 *            An optional comment on the photograph, to be stored with it.
	 * @param albumName
	 *            The required album in which this photograph will be entered
	 *            into.
	 * 
	 *            Blindly prints the string returned by the view controller.
	 * 
	 * 
	 */
	private void addPhoto(String fileName, String caption, String albumName) {
		try {
			this.viewController.addPhoto(fileName, caption, albumName);
			System.out.println("Added photo <" + fileName + ">: <" + caption
					+ "> - Album: <" + albumName + ">");
		} catch (PhotoAlbumException pae) {
			System.out.println(pae.getLocalizedMessage());
		}
	}

	/**
	 * Call the view controller with the inputted parameters.
	 * 
	 * Expects a string to print the terminal.
	 * 
	 * @param fileName
	 * @param oldAlbumName
	 * @param newAlbumName
	 */
	private void movePhoto(String fileName, String oldAlbumName,
			String newAlbumName) {
		try {
			this.viewController.movePhoto(fileName, oldAlbumName, newAlbumName);
			System.out.println("Moved photo <" + fileName + ">:  " + fileName
					+ "> - From album <" + oldAlbumName + "> to album <"
					+ newAlbumName + ">");
		} catch (PhotoAlbumException pae) {
			System.out.println("Photo <" + fileName + "> does not exist in <" + oldAlbumName + "> - " + pae.getLocalizedMessage());
		}
	}

	/**
	 * Calls the view controller with the inputed arguments.
	 * 
	 * Expects a String to print to the terminal.
	 * 
	 * @param fileName
	 * @param albumName
	 */
	private void removePhoto(String fileName, String albumName) {
		try {
			this.viewController.removePhoto(fileName, albumName);
			System.out.println("<" + fileName + "> - From album <" + albumName + ">");
		} catch (PhotoAlbumException e) {
			System.out.println("Photo <" + fileName + "> is not in album <" + albumName + ">" + e.getLocalizedMessage());
		}
	}

	/**
	 * 
	 * Calls the view controller to add a tag.
	 * 
	 * Expects a String to print to the terminal.
	 * 
	 * @param fileName
	 * @param tagType
	 * @param tagValue
	 */
	private void addTag(String fileName, String tagType, String tagValue) {
		try {
			this.viewController.addTag(fileName, tagType, tagValue);
			System.out.println("Added tag:");
			System.out.println("Tag already exists for<" + fileName + "> <" + tagType + ">:<" + tagValue + ">");
		} catch (PhotoAlbumException e) {
			System.out.println("<" + fileName + "> <" + tagType + ">:<" + tagValue + ">");
			System.out.println(e.getLocalizedMessage());
		}
	}

	/**
	 * 
	 * Calls the view controller to delete a tag.
	 * 
	 * Expects a String to print to the terminal.
	 * 
	 * @param fileName
	 *            The name of the location of the photo the user wishes to
	 *            input.
	 * @param tagType
	 * @param tagValue
	 */
	private void deleteTag(String fileName, String tagType, String tagValue) {
		try {
			this.viewController.addTag(fileName, tagType, tagValue);
			System.out.println("Deleted tag:");
			System.out.println("<" + fileName + "> <" + tagType + ">:<" + tagValue + ">");
		} catch (PhotoAlbumException e) {
			System.out.println("Tag does not exist for<" + fileName + "> <" + tagType + ">:<" + tagValue + ">");
			System.out.println(e.getLocalizedMessage());
		}
	}

	/**
	 * Calls the view controller for a String to print to the terminal.
	 * 
	 * @param fileName
	 *            The name of the location of the photo the user wishes to
	 *            input.
	 */
	private void listPhotoInfo(String fileName) {
		System.out.println(this.viewController.listPhotoInfo(fileName));
	}

	/**
	 * Calls the view controller with two strings.
	 * 
	 * This method will parse the strings into Calendar items for the VC.
	 * 
	 * Expects a string to be printed to the terminal.
	 * 
	 * @param startDate
	 *            A String representing a date which the user wants to see, the
	 *            beginning, inclusive.
	 * @param endDate
	 *            A String represeting the end date which the user wants to see
	 *            the photos between - inclusive.
	 * 
	 */
	private void getPhotosByDate(Calendar startDate, Calendar endDate) {
	}

	/**
	 * Calls the view controller and expects a formatted String back
	 * 
	 * @param tagType
	 *            The "genre" of tag as a string.
	 * @param tagValue
	 *            The actual content of this tag.
	 */
	private void getPhotosByTag(String tagType, String tagValue) {
		this.viewController.getPhotosByTag(tagType, tagValue);
	}

	/**
	 * Tells the VC to logout.
	 * 
	 * Finishes up and cleans up here.
	 */
	private void logout() {
		this.viewController.logout();
	}
}
