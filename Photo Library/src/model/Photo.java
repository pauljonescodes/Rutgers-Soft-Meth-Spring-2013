package model;

public class Photo {
	
	protected String photoName;
	protected String caption;
	
	public Photo(String fileName, String caption) {
		this.photoName = fileName;
		this.caption = caption;
	}
	
	public void addTag() {
		
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
