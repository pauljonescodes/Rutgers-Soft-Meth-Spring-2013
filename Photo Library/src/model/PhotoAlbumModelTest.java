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
}
