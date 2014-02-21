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
@Table(name = "WARRANTY", schema="ONSALENEXT_ITEM")
public class Warranty extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "WARRANTY_ID")
	private Long id;
	@Column(name = "WARRANTY", unique=false, nullable=false, length=250)
	private String warranty;
	@Column(name="STATUS")
	private boolean isActive;
	
	public Warranty () {}
	
	public Warranty ( Long id, String warranty, boolean isActive, Date upd, String user ){
		this.id = id;
		this.warranty = warranty;
		this.isActive = isActive;
		this.upd = upd;
		this.user = user;
	}

	public Warranty ( Long id, String warranty, boolean isActive, Date cpd, Date upd, String user ){
		this.id = id;
		this.warranty = warranty;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
