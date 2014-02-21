package com.onsalenext.base.web.model.item;

public class SizeBom implements Comparable<SizeBom>{

	private Long id;
	private String size;
	private boolean isActive;
	
	public SizeBom ( Long id, String size, boolean isActive){
		this.id = id;
		this.size = size;
		this.isActive = isActive;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	public int compareTo(SizeBom o) {
		return size.compareTo(o.size);
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
}
