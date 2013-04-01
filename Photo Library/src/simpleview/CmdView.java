package simpleview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import model.PhotoAlbumModel;
import control.InteractiveModeViewController;

/**
 * 
 * This represents the beginning of this program's design, where the first calls
 * are made.
 * 
 * This class contains static methods which respond to command line arguments.
 * 
 * When a user is logged in, it sets off the larger program.
 * 
 * Specification: For this first stage of the project, you will implement a
 * simple text-based view with two modes of input - a command line mode, and an
 * interactive mode.
 * 
 * @author Paul Jones
 * @author Sujish Patel
 */

public class CmdView {
	public static final String dirName = "./Users";
	private static final String fileExtension = ".photoAlbum31User";

	/**
	 * @author Paul Jones
	 * Processes command line arguments.
	 * 
	 * @param args
	 *            Valid commands: listusers, adduser <user id> <user name>,
	 *            deleteuser <user id>, login <user id>
	 */

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Error: no arguments given");
		}
		
		// command line mode - list users
		else if (args[0].equals("listusers")) {
			if (args.length != 1) { // too many arguments given
				System.out.println("Error: only one argument needed for listusers");
			} else {
				listusers();
			}
		} // WORKING
		
		// command line mode - add a new user
		else if (args[0].equals("adduser")) {
			if (args.length != 3) { // incorrect number of arguments given
				System.out.println("Error: wrong number of arguments given");
				System.out.println("adduser usage: adduser <user id> \"<user name>\"");
			} else {
				adduser(args[1], args[2]);
			}
		} // WORKING
		
		// command line mode - delete a user
		else if (args[0].equals("deleteuser")) {
			if (args.length != 2) { // incorrect number of arguments given
				System.out.println("Error: wrong number of arguments given");
				System.out.println("deleteuser usage: deleteuser <user id>");
			} else {
				deleteuser(args[1]);
			}
		} // WORKING
		
		// command line mode - login as existing user
		else if (args[0].equals("login")) {
			if (args.length != 2) { // incorrect number of arguments given
				System.out.println("Error: wrong number of arguments given");
				System.out.println("login usage: login <user id>");
			} else {
				login(args[1]);
			}
		} // WORKING
		
		// handle any other unexpected input
		else {
			System.out.println("unexpected input");
		}
	}

	/**
	 * Command line responder which prints the list of users. Our implementation
	 * is that this method will look at the serialized users, which are stored
	 * as "[userId].dat". This renders this method as a simple looking in the
	 * users directory and printing the base names of the files serialized.
	 * 
	 * Usage: listusers Usage: cs213.photoAlbum.simpleview.CmdView listusers
	 * 
	 * @return <userId1> <userId2> ... Or: no users exist
	 * 
	 */

	public static void listusers() {
		String files;
		File folder = new File(dirName + File.separator);
		File[] listOfFiles = folder.listFiles(); 

		for (int i = 0; i < listOfFiles.length; i++) 
		{

			if (listOfFiles[i].isFile()) 
			{
				files = listOfFiles[i].getName();
				
				if (files.contains(".photoAlbum31User"))
					System.out.println(files.substring(0, files.indexOf(".photoAlbum31User")));
			}
		}
	}

	/**
	 * Adding a user creates a new instance of the User class and serializes it
	 * in the user directory.
	 * 
	 * This is all that is required to make a new user, with an empty Library.
	 * 
	 * Usage: java cs213.photoAlbum.simpleview.CmdView adduser <user id> <user
	 * name>
	 * 
	 * @param userId
	 *            A user's unique identification, used for deleting, listing,
	 *            and logging in. This field is unique, but can be identical to
	 *            their name.
	 * 
	 * @param UserName
	 *            A user's username, used for logging in
	 * 
	 * @return created user <user id> with name <user name> Or: user <user id>
	 *         already exists with name <user name>
	 */
	public static void adduser(String userId, String userName) {
		PhotoAlbumModel pam = new PhotoAlbumModel(userId, userName);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dirName + File.separator + userId + fileExtension));
			oos.writeObject(pam);
			oos.close();
		} catch (Exception e) {
			System.out.println("I'm afraid we couldn't create your user. " + e.getLocalizedMessage());
			System.out.println("Working Directory = " + System.getProperty("user.dir"));
		}
	}

	/**
	 * This simply takes the serialized data stored in the user directory and
	 * deletes the entry for the name inputted.
	 * 
	 * Usage: java cs213.photoAlbum.simpleview.CmdView deleteuser <user id>
	 * 
	 * @param userId
	 *            A user's unique identification, which can be found by listing
	 *            users.
	 * 
	 * @return Output: deleted user <user id> Or: user <user id> does not exist
	 */
	public static void deleteuser(String userId) {
		File file = new File(dirName + File.separator + userId + fileExtension);
		if (file.delete()) {
			System.out.println("Successfully deleted.");
		} else {
			System.out.println("I'm afraid I could not delete that, Dave.");
		}
	}

	/**
	 * 
	 * To login as an existing user.
	 * 
	 * This is where there interesting programming begins. After checking the
	 * user directory for the serialized file "[userId].dat" (which, if exists,
	 * it loads, and if not, the user does not exist), this method loads the
	 * serialized user into a new User variable. It then creates a new
	 * InteractiveModeView and InteractiveModeViewController to present to the
	 * user.
	 * 
	 * While the user hasn't logged out, this continues to run. When the user
	 * does log out, the structure also concludes here.
	 * 
	 * This is where arguments are read in and sent to interactive mode view. It
	 * is the interactive mode view, however, that accepts those arguments and
	 * determines if they are valid and executes them.
	 * 
	 * In short, based on the user identification entered here, in this method,
	 * a User object is created. This User is passed to an
	 * InteractiveModeViewController. This InteractiveModeViewController is
	 * passed to an InteractiveModeView. Pseudo-code:
	 * 
	 * User user = retrieveSerializedUser(userId); InteractiveModeViewController
	 * vc = new InteractiveModeViewController(user); InteractiveModeView v = new
	 * InteractiveModeView(vc);
	 * 
	 * while (!loggedout) [send arguments to view]
	 * 
	 * After logout, data is serialized for future use and the program
	 * terminates.
	 * 
	 * Usage: java cs213.photoAlbum.simpleview.CmdView login <user id>
	 * 
	 * @param userId
	 * 
	 * @return (*view now goes into interactive mode*) Or: user <user id> does
	 *         not exist `
	 */
	public static void login(String userId) {
		ObjectInputStream ois;
		PhotoAlbumModel user = null;
		Scanner in;
		InteractiveModeViewController vc = null;

		try {
			ois = new ObjectInputStream(new FileInputStream(dirName + File.separator + userId + fileExtension));
			user = (PhotoAlbumModel) ois.readObject();
			System.out.println(user.getFullName());
			
			vc = new InteractiveModeViewController(user);
			InteractiveView v = new InteractiveView(vc);
			
			while (vc.isLoggedIn) {
				in = new Scanner(System.in);
				String cmd = in.nextLine();
				v.giveArgument(cmd);
			}
			
			write(user, userId);
			
		} catch (Exception e) {
			System.out.println("Invalid input. Logging out and saving to file to protect data.");
			System.out.println(e.getLocalizedMessage());
			if (user != null){
				write(user, userId);
			}
		}


	}
	
	private static void write(PhotoAlbumModel user, String userId) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dirName + File.separator + userId + fileExtension));
			oos.writeObject(user);
			System.out.println("Save");
		} catch (Exception e) {
			System.out.println("Save failed.");
		}
	}

}
