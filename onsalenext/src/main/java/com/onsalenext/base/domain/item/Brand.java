package com.onsalenext.base.domain.item;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;
import com.onsalenext.base.domain.Picture;

@Entity
@Table(name = "BRAND", schema="ONSALENEXT_ITEM")
public class Brand extends DBBase implements Serializable {
	
	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name="BRAND_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "BRAND_NAME", unique=true, nullable=false, length=200)
	private String attribute;
	@Column(name = "STATUS", unique=false, nullable=false)
	private boolean isActive;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Picture picture;

	public Brand () {}
	
	public Brand ( Long id, String attribute, boolean isActive, Picture picture, Date upd, String user) {
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.picture = picture;
		this.upd = upd;
		this.user = user;
	}

	public Brand ( Long id, String attribute, boolean isActive, Picture picture, Date cpd, Date upd, String user) {
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.picture = picture;
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

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}
}
