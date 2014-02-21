package com.onsalenext.base.web.model.item;

public class ColorBom implements Comparable<ColorBom>{

	private Long id;
	private String colorGroup;
	private String color;
	private String hexCode;
	boolean isActive;
	
	public ColorBom ( Long id, String colorGroup, String color, String hexCode, boolean isActive){
		this.id = id;
		this.colorGroup = colorGroup;
		this.color = color;
		this.isActive = isActive;
		this.hexCode = hexCode;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public int compareTo(ColorBom o) {
		return colorGroup.compareTo(o.colorGroup);
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getHexCode() {
		return hexCode;
	}

	public void setHexCode(String hexCode) {
		this.hexCode = hexCode;
	}

	public String getColorGroup() {
		return colorGroup;
	}

	public void setColorGroup(String colorGroup) {
		this.colorGroup = colorGroup;
	}
}
