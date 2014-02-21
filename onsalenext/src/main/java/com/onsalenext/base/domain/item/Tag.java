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
@Table(name = "TAG", schema="ONSALENEXT_ITEM")
public class Tag extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "TAG_ID")
	private Long id;
	@Column(name = "CATEGORY", unique=false, nullable=false, length=50)
	private String category;
	@Column(name = "TAG", unique=false, nullable=false, length=50)
	private String tag;
	@Column(name="STATUS")
	private boolean isActive;
	
	public Tag () {}
	
	public Tag ( Long id, String tag, String category, boolean isActive, Date upd, String user ){
		this.id = id;
		this.tag = tag;
		this.category = category;
		this.isActive = isActive;
		this.upd = upd;
		this.user = user;
	}

	public Tag ( Long id, String tag, String category, boolean isActive, Date cpd, Date upd, String user ){
		this.id = id;
		this.tag = tag;
		this.category = category;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
