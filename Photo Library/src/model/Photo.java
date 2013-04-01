package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Photo implements Serializable {
	
	private static final long serialVersionUID = 969092331882216851L;
	
	protected String photoName;
	protected String caption;
	protected ArrayList<Tag> tags;
	protected Calendar dateCreated;
	
	public Photo(String fileName, String caption) {
		this.photoName = fileName;
		this.caption = caption;
		
		this.tags = new ArrayList<Tag>();
		this.dateCreated = Calendar.getInstance();
		this.dateCreated.set(Calendar.MILLISECOND,0);
	}
	
	public void addTag(String tagType, String tagValue) throws PhotoAlbumException {
		if (this.hasTag(tagType, tagValue)) {
			throw new PhotoAlbumException("This tag already exists for this photo.");
		} else {
			this.tags.add(new Tag(tagType, tagValue));
		}
	}
	
	public void deleteTag(String tagType, String tagValue) throws PhotoAlbumException {
		if (!this.hasTag(tagType, tagValue)) {
			throw new PhotoAlbumException("This tag already exists for this photo.");
		} else {
			this.tags.remove(this.getTagIndex(tagType, tagValue));
		}
	}
	
	private int getTagIndex(String tagType, String tagValue) {
		for (int i = 0; i < this.getNumberOfTags(); i++) {
			if (tags.get(i) != null && tags.get(i).equals(new Tag(tagType, tagValue))) {
				return i;
			}
		}

		return -1;
	}
	
	public boolean hasTag(String tagType, String tagValue) {
		for (Tag tag : tags) {
			if (tag.equals(new Tag(tagType, tagValue))) {
				return true;
			}
		} return false;
	}
	
	public int getNumberOfTags() {
		return this.tags.size();
	}
	
	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String toString() {
		return this.photoName;
	}
	
}
