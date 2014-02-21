package com.onsalenext.base.domain.menu;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;
import com.onsalenext.base.domain.Picture;
import com.onsalenext.base.domain.item.Item;

@Entity
@Table(name = "PRODUCT", schema="ONSALENEXT_HOME")
public class Product extends DBBase implements Serializable {

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "ATTRIBUTE", unique=false, nullable=false, length=100)
	private String attribute;
	@Column(name = "STATUS", unique=false, nullable=false)
	private boolean isActive;

	@OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="PRODUCT_ITEM_LINK", 
                joinColumns={@JoinColumn(name="PRODUCT_ID")}, 
                inverseJoinColumns={@JoinColumn(name="ITEM_ID")})
    private Set<Item> items = new HashSet<Item> (0);
	
	@OneToOne(cascade=CascadeType.ALL)
	private Picture picture;

	public Product (){}
	
	public Product (Long id, String attribute, boolean isActive, Picture picture, Set<Item> items,
			Date upd, String user){
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.picture = picture;
		this.items = items;
		this.upd = upd;
		this.user = user;
	}

	public Product (Long id, String attribute, boolean isActive, Picture picture, Set<Item> items,
			Date cpd, Date upd, String user){
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.picture = picture;
		this.items = items;
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

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
