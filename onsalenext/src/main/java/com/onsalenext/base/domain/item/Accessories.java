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

@Entity
@Table(name = "ACCESSORIES", schema="ONSALENEXT_ITEM")
public class Accessories extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ACCESSORIES_ID")
	private Long id;
	@Column(name="STATUS")
	private boolean isActive;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private Item item;
	
	public Accessories () {}

	public Accessories ( Long id, boolean isActive, Item item, Date upd, String user){
		this.id = id;
		this.isActive = isActive;
		this.item = item;
		this.upd = upd;
		this.user = user;
	}
	
	public Accessories ( Long id, boolean isActive, Item item, Date cpd, Date upd, String user){
		this.id = id;
		this.isActive = isActive;
		this.item = item;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
