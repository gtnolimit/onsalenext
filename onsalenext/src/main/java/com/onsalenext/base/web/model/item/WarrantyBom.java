package com.onsalenext.base.web.model.item;

public class WarrantyBom implements Comparable<WarrantyBom>{

	private Long id;
	private String warranty;
	private boolean isActive;
	
	public WarrantyBom ( Long id, String warranty, boolean isActive ){
		this.id = id;
		this.warranty = warranty;
		this.isActive = isActive;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int compareTo(WarrantyBom o) {
		return warranty.compareTo(o.warranty);
	}
	
	
}
