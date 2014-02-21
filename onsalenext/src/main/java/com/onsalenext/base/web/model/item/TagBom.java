package com.onsalenext.base.web.model.item;

public class TagBom implements Comparable<TagBom>{

	private Long id;
	private String tag;
	private boolean isActive;
	private String category;

	public TagBom ( Long id, String tag, String category, boolean isActive ){
		this.id = id;
		this.tag = tag;
		this.isActive = isActive;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int compareTo(TagBom o) {
		return category.compareTo(o.category);
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}	
}
