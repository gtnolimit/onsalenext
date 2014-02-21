package com.onsalenext.base.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PICTURE", schema="ONSALENEXT_ITEM")
public class Picture  extends DBBase {

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PICTURE_ID")
	private Long id; 
	@Column(name = "PICTURE_LOCATION", unique=false, nullable = true, length = 500)
	private String pictureLocation;
	@Column(name = "PICTURE_FILE_NAME", unique=false, nullable = true, length = 500)
	private String pictureFileName;
	@Column(name = "ALT", unique=false, nullable = true, length = 500)
	private String alt;
	@Column(name="STATUS", unique=false, nullable = false)
	private boolean isActive;
	@Column(name="MAIN_PICTURE", unique=false, nullable = false)
	private boolean isMain;
	
	public Picture () {}
	
	public Picture ( Long id, String pictureLocation, String pictureFileName, String alt, boolean isActive, boolean isMain,
			Date upd, String user){
		this.id = id; 
		this.pictureLocation = pictureLocation;
		this.pictureFileName = pictureFileName;
		this.alt = alt;
		this.isActive = isActive;
		this.isMain = isMain;
		this.upd = upd;
		this.user = user;
	}

	public Picture ( Long id, String pictureLocation, String pictureFileName, String alt, boolean isActive, boolean isMain,
			Date cpd, Date upd, String user){
		this.id = id; 
		this.pictureLocation = pictureLocation;
		this.pictureFileName = pictureFileName;
		this.alt = alt;
		this.isActive = isActive;
		this.isMain = isMain;
		this.cpd = cpd;
		this.upd = upd;
		this.user = user;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isMain() {
		return isMain;
	}

	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}
	
}
