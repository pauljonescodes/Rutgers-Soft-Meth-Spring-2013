package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Photo {
	
	protected String photoName;
	protected String caption;
	protected ArrayList<Tag> tags;
	protected Calendar dateCreated;
	
	public Photo(String fileName, String caption) {
		this.photoName = fileName;
		this.caption = caption;
		
		this.tags = new ArrayList<Tag>();
		
		//this.dateCreated.set(Calendar.MILLISECOND,0);
	}
	
	public void addTag(String tagType, String tagValue) {
		this.tags.add(new Tag(tagType, tagValue));
	}
	
	public void deleteTag() {
		
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

}
