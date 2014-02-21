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
@Table(name = "SIZE", schema="ONSALENEXT_ITEM")
public class Size extends DBBase implements Serializable{
	
	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SIZE_ID")
	private Long id;
	@Column(name = "SIZE", unique=false, nullable = true, length = 30)
	private String size;
	@Column(name = "STATUS", unique=false, nullable = true)
	private boolean isActive;
	
	public Size () {}
	
	public Size ( Long id, String size, boolean isActive, Date upd, String user){
		this.id = id;
		this.size = size;
		this.isActive = isActive;
		this.upd = upd;
		this.user = user;
	}

	public Size ( Long id, String size, boolean isActive, Date cpd, Date upd, String user){
		this.id = id;
		this.size = size;
		this.isActive = isActive;
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
