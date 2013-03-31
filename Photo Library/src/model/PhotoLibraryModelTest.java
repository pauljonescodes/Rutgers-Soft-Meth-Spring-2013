package model;
import static org.junit.Assert.*;

import org.junit.*;

public class PhotoLibraryModelTest {
	
	UserLibrary library;

	@Before
	public void setUp() throws Exception {
		this.library = new UserLibrary();
	}

	@Test
	public void testUniqueAlbumCreation() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");
		} catch (PhotoAlbumException e) {
			fail("Unique album creation failed with message: " + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testNonUniqueAlbumCreation() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Fall colors");
			fail("This should throw an exception.");
		} catch (PhotoAlbumException e) {
			
		}
	}
	
	@Test
	public void testAlbumDeletion() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");
			
			if (this.library.getNumberOfAlbums() != 2)
				fail("Album creation failed.");
			
			this.library.deleteAlbum("Fall colors");
			this.library.deleteAlbum("Colorado Springs");
			
			if (this.library.getNumberOfAlbums() != 0) {
				fail("Album deletion failed");
			}
			
		} catch (PhotoAlbumException e) {
			fail("Album deletion failed with message: " + e.getLocalizedMessage());
		}
	}
}
