package com.onsalenext.base.web.model.menu;

import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.onsalenext.base.web.model.PictureBom;
import com.onsalenext.base.web.model.item.ItemBom;


@XmlRootElement(name = "product")
public class ProductBom implements Comparable<ProductBom>{
	
	private Long id;
	private String attribute;
	private boolean isActive;
	private Set <ItemBom> items;
	private PictureBom picture;
	
	public ProductBom ( Long id, String attribute, Set<ItemBom> item ){
		this.id = id;
		this.attribute = attribute;
		this.items = item;
	}
	
	public ProductBom (Long id, String attribute, boolean isActive, PictureBom picture, Set<ItemBom> items ){
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.picture = picture;
		this.items = items;
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
	public int compareTo(ProductBom o) {
		return attribute.compareTo(o.attribute);
	}

	public Set<ItemBom> getItems() {
		return items;
	}

	public void setItems(Set<ItemBom> items) {
		this.items = items;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public PictureBom getPicture() {
		return picture;
	}

	public void setPicture(PictureBom picture) {
		this.picture = picture;
	}
}
