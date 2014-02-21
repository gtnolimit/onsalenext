package com.onsalenext.base.domain.item;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;

@Entity
@Table(name = "COLOR", schema="ONSALENEXT_ITEM")
public class Color extends DBBase implements Serializable{
	
	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "COLOR_ID")
	private Long id;
	@Column(name = "COLORGROUP", unique=false, nullable = false, length = 15)
	private String colorGroup;
	@Column(name = "COLOR", unique=true, nullable = false, length = 30)
	private String color;
	@Column(name = "HEXCODE", unique=false, nullable = false, length = 8)
	private String hexCode;
	@Column(name="STATUS")
	private boolean isActive;
	
	public Color () {}

	public Color ( Long id, String colorGroup, String color, String hexCode, boolean isActive, Date upd, String user ){
		this.id = id;
		this.colorGroup = colorGroup;
		this.color = color;
		this.isActive = isActive;
		this.hexCode = hexCode;
		this.upd = upd;
		this.user = user;
	}

	public Color ( Long id, String colorGroup, String color, String hexCode, boolean isActive, Date cpd, Date upd, String user ){
		this.id = id;
		this.colorGroup = colorGroup;
		this.color = color;
		this.isActive = isActive;
		this.hexCode = hexCode;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
