package model;

public class Tag {

	public String tagType;
	public String tagValue;

	public Tag(String tagType, String tagValue) {
		this.tagType = tagType;
		this.tagValue = tagValue;
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof Tag)) {
			return false;
		} else {
			Tag tag = ((Tag) o);

			if (this.tagType.compareTo(tag.tagType) == 0
					&& this.tagValue.compareTo(tag.tagValue) == 0) {
				return true;
			} else {
				return false;
			}
		}
	}
}
