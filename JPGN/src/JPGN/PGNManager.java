package JPGN;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PGNManager {
	public static final String dirName = "./games";
	private static final String fileExtension = ".pgn";

	public static PGNList deserializeFromFile(String file) throws IOException,
			ClassNotFoundException {
		ObjectInputStream ois;
		PGNList list = null;

		ois = new ObjectInputStream(new FileInputStream(dirName
				+ File.separator + file + fileExtension));
		list = (PGNList) ois.readObject();

		return list;
	}

	public static File[] getSerializedFiles() {
		File folder = new File(dirName + File.separator);
		File[] listOfFiles = folder.listFiles();
		return listOfFiles;
	}

	public static void serializeToFile(String file, PGNList list)
			throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				dirName + File.separator + file + fileExtension));
		oos.writeObject(list);
	}
}