package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

public class PhotoAlbumModelTest {

	PhotoAlbumModel library;

	@Before
	public void setUp() throws Exception {
		this.library = new PhotoAlbumModel();
	}

	@Test
	public void testCreateAlbum() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");
		} catch (PhotoAlbumException e) {
			fail("Unique album creation failed with message: "
					+ e.getLocalizedMessage());
		}
	}

	@Test
	public void testCreateAlbumDuplicate() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Fall colors");
			fail("This should throw an exception.");
		} catch (PhotoAlbumException e) {

		}
	}

	@Test
	public void testDeleteAlbum() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");

			assertTrue(this.library.getNumberOfAlbums() == 2);

			this.library.deleteAlbum("Fall colors");
			this.library.deleteAlbum("Colorado Springs");

			assertTrue(this.library.getNumberOfAlbums() == 0);

		} catch (PhotoAlbumException e) {
			fail("Album deletion failed with message: "
					+ e.getLocalizedMessage());
		}
	}

	@Test
	public void testAddPhoto() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");

			assertTrue(this.library.getNumberOfAlbums() == 2);

			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");
			this.library.addPhoto("DSC_005.jpg", "DSC_005", "Fall colors");
			this.library.addPhoto("DSC_007.jpg", "DSC_007", "Colorado Springs");

			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 2);
			assertTrue(this.library
					.getNumberOfPhotosInAlbum("Colorado Springs") == 1);

		} catch (PhotoAlbumException pae) {
			fail("Photo addition failed with message: "
					+ pae.getLocalizedMessage());
		}
	}
	
	@Test
	public void testAddPhotoDuplicate() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");

			assertTrue(this.library.getNumberOfAlbums() == 2);

			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");
			this.library.addPhoto("DSC_001.jpg", "DSC_005", "Fall colors");

			fail("You should not be able to add a photo with a duplicate name, even if it's caption is different.");
			
			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 2);
			assertTrue(this.library
					.getNumberOfPhotosInAlbum("Colorado Springs") == 1);

		} catch (PhotoAlbumException pae) {
			
		}
	}

	@Test
	public void testGetAlbumNames() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");
			ArrayList<String> albumNamesTest = new ArrayList<String>();
			albumNamesTest.add("Fall colors");
			albumNamesTest.add("Colorado Springs");

			assertTrue(this.library.getAlbumNames().equals(albumNamesTest));
		} catch (Exception e) {
			fail("Album listing failed with message: "
					+ e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testRemovePhoto() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");

			assertTrue(this.library.getNumberOfAlbums() == 2);

			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");
			this.library.addPhoto("DSC_005.jpg", "DSC_005", "Fall colors");
			this.library.addPhoto("DSC_007.jpg", "DSC_007", "Colorado Springs");

			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 2);
			assertTrue(this.library.getNumberOfPhotosInAlbum("Colorado Springs") == 1);
			
			this.library.removePhoto("DSC_001.jpg", "Fall colors");
			this.library.removePhoto("DSC_005.jpg", "Fall colors");
			this.library.removePhoto("DSC_007.jpg", "Colorado Springs");
			
			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 0);
			assertTrue(this.library.getNumberOfPhotosInAlbum("Colorado Springs") == 0);

		} catch (PhotoAlbumException pae) {
			fail("Photo addition failed with message: "
					+ pae.getLocalizedMessage());
		}
	}
	
	@Test
	public void testRemoveNonExistantPhoto() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.removePhoto("DSC_001.jpg", "Fall colors");
		} catch (PhotoAlbumException pae) {
			
		}
	}
	
	@Test
	public void testMovePhoto() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");

			assertTrue(this.library.getNumberOfAlbums() == 2);

			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");
			this.library.addPhoto("DSC_005.jpg", "DSC_005", "Fall colors");
			this.library.addPhoto("DSC_007.jpg", "DSC_007", "Colorado Springs");

			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 2);
			assertTrue(this.library.getNumberOfPhotosInAlbum("Colorado Springs") == 1);
			
			this.library.movePhoto("DSC_001.jpg", "Fall colors", "Colorado Springs");
			this.library.movePhoto("DSC_005.jpg", "Fall colors", "Colorado Springs");
			
			assertTrue(this.library.getNumberOfPhotosInAlbum("Colorado Springs") == 3);

		} catch (PhotoAlbumException pae) {
			fail("Photo move failed with message: "
					+ pae.getLocalizedMessage());
		}
	}
	
	@Test
	public void testMoveNonExistantPhoto() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");

			assertTrue(this.library.getNumberOfAlbums() == 2);

			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");
			this.library.addPhoto("DSC_005.jpg", "DSC_005", "Fall colors");
			this.library.addPhoto("DSC_007.jpg", "DSC_007", "Colorado Springs");

			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 2);
			assertTrue(this.library.getNumberOfPhotosInAlbum("Colorado Springs") == 1);
			
			this.library.movePhoto("DSC_002.jpg", "Fall colors", "Colorado Springs");
			this.library.movePhoto("DSC_003.jpg", "Fall colors", "Colorado Springs");
			
			fail("Should not have not thrown an exception.");
			
			assertTrue(this.library.getNumberOfPhotosInAlbum("Colorado Springs") != 3);

			fail("Should not have not thrown an exception.");
			
		} catch (PhotoAlbumException pae) {
			
		}
	}
	
	@Test
	public void testAddTag() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");

			assertTrue(this.library.getNumberOfAlbums() == 2);

			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");
			this.library.addPhoto("DSC_005.jpg", "DSC_005", "Fall colors");
			this.library.addPhoto("DSC_007.jpg", "DSC_007", "Colorado Springs");

			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 2);
			assertTrue(this.library.getNumberOfPhotosInAlbum("Colorado Springs") == 1);
			
			this.library.addTag("DSC_001.jpg", "person", "Paul Jones");
			this.library.addTag("DSC_007.jpg", "person", "David Boyle");
			
		} catch (PhotoAlbumException pae) {
			fail("Add tag failed with message: "
					+ pae.getLocalizedMessage());
		}
	}
	
	@Test
	public void testAddTagToNonExistantPhoto() {
		try {
			this.library.createAlbum("Fall colors");
			assertTrue(this.library.getNumberOfAlbums() == 1);
			
			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");

			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 1);
			
			this.library.addTag("DSC_002.jpg", "person", "Paul Jones");
			
			fail("The last call should have thrown an exception because the photo does not exist.");
			
		} catch (PhotoAlbumException pae) {
			
		}
	}
	
	@Test
	public void testAddDuplicateTag() {
		try {
			this.library.createAlbum("Fall colors");
			assertTrue(this.library.getNumberOfAlbums() == 1);
			
			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");

			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 1);
			
			this.library.addTag("DSC_001.jpg", "person", "Paul Jones");
			this.library.addTag("DSC_001.jpg", "person", "Paul Jones");
			
			fail("The last call should have thrown an exception because that tag already exists.");
			
		} catch (PhotoAlbumException pae) {
			
		}
	}
	
	@Test
	public void testRemoveTag() {
		try {
			this.library.createAlbum("Fall colors");
			assertTrue(this.library.getNumberOfAlbums() == 1);
			
			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");

			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 1);
			
			this.library.addTag("DSC_001.jpg", "person", "Paul Jones");
			this.library.deleteTag("DSC_001.jpg", "person", "Paul Jones");
			
		} catch (PhotoAlbumException pae) {
			fail("Remove tag failed with message: " + pae.getLocalizedMessage());
		}
	}
	
	@Test
	public void testGetTag() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");

			assertTrue(this.library.getNumberOfAlbums() == 2);

			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");
			this.library.addPhoto("DSC_005.jpg", "DSC_005", "Fall colors");
			this.library.addPhoto("DSC_007.jpg", "DSC_007", "Colorado Springs");

			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 2);
			assertTrue(this.library.getNumberOfPhotosInAlbum("Colorado Springs") == 1);
			
			this.library.addTag("DSC_001.jpg", "person", "Paul Jones");
			this.library.addTag("DSC_007.jpg", "person", "Paul Jones");
			this.library.addTag("DSC_005.jpg", "person", "Paul Jones");
			
			ArrayList<Photo> photosWithPaul = this.library.getPhotosByTag("person", "Paul Jones");
			
			assertTrue(photosWithPaul.size() == 3);
			
		} catch (PhotoAlbumException pae) {
			fail("Add tag failed with message: "
					+ pae.getLocalizedMessage());
		}
	}
	
	@Test
	public void testGetNonExistantTag() {
		try {
			this.library.createAlbum("Fall colors");
			this.library.createAlbum("Colorado Springs");

			assertTrue(this.library.getNumberOfAlbums() == 2);

			this.library.addPhoto("DSC_001.jpg", "DSC_001", "Fall colors");
			this.library.addPhoto("DSC_005.jpg", "DSC_005", "Fall colors");
			this.library.addPhoto("DSC_007.jpg", "DSC_007", "Colorado Springs");

			assertTrue(this.library.getNumberOfPhotosInAlbum("Fall colors") == 2);
			assertTrue(this.library.getNumberOfPhotosInAlbum("Colorado Springs") == 1);
			
			this.library.addTag("DSC_001.jpg", "person", "Paul Jones");
			this.library.addTag("DSC_007.jpg", "person", "Paul Jones");
			this.library.addTag("DSC_005.jpg", "person", "Paul Jones");
			
			ArrayList<Photo> photosWithDave = this.library.getPhotosByTag("person", "David Boyle");
			
			fail("There are no photos with Dave, it should have thrown an exception.");
			
		} catch (PhotoAlbumException pae) {
			
		}
	}
}
