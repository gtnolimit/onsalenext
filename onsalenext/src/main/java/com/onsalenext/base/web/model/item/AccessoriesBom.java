package com.onsalenext.base.web.model.item;

public class AccessoriesBom implements Comparable<AccessoriesBom>{

	private Long id;
	private boolean isActive;
	private ItemBom item;

	public AccessoriesBom (Long id, boolean isActive, ItemBom item){
		this.id = id;
		this.isActive = isActive;
		this.item = item;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public ItemBom getItem() {
		return item;
	}
	public void setItem(ItemBom item) {
		this.item = item;
	}
	public int compareTo(AccessoriesBom o) {
		return id.compareTo(o.id);
	}

	
}
