package com.onsalenext.base.web.model.item;

import com.onsalenext.base.web.model.PictureBom;


public class BrandBom  implements Comparable<BrandBom>{

	private Long id;
	private String attribute;
	private boolean isActive;
	private PictureBom picture;
	
	public BrandBom (Long id, String attribute, boolean isActive, PictureBom picture) {
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.picture = picture;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public PictureBom getPicture() {
		return picture;
	}
	public void setPicture(PictureBom picture) {
		this.picture = picture;
	}

	public int compareTo(BrandBom o) {
		return attribute.compareTo(o.attribute);
	}

	
}
