package com.onsalenext.base.web.model;

public class PictureBom  implements Comparable <PictureBom>{

	private Long id; 
	private String pictureLocation;
	private String pictureFileName;
	private String alt;
	private boolean isActive;
	private boolean isMain; 
	
	public PictureBom ( Long id, String pictureLocation, String pictureFileName, String alt, boolean isActive, boolean isMain){
		this.id = id;
		this.alt = alt;
		this.pictureFileName = pictureFileName;
		this.pictureLocation = pictureLocation;
		this.isActive = isActive;
		this.isMain = isMain;		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPictureLocation() {
		return pictureLocation;
	}

	public void setPictureLocation(String pictureLocation) {
		this.pictureLocation = pictureLocation;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isMain() {
		return isMain;
	}

	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}

	public int compareTo(PictureBom o) {
		return this.id.compareTo(o.id);
	}

}
