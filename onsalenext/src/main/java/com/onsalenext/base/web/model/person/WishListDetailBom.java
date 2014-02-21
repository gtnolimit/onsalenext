package com.onsalenext.base.web.model.person;

import com.onsalenext.base.web.model.item.ItemBom;


public class WishListDetailBom implements Comparable<WishListDetailBom>{

	private Long id;
	private ItemBom item;
	
	public WishListDetailBom ( Long id, ItemBom item ) {
		this.id = id;
		this.item = item;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ItemBom getItem() {
		return item;
	}
	public void setItem(ItemBom item) {
		this.item = item;
	}

	public int compareTo(WishListDetailBom o) {
		return id.compareTo(o.id);
	}

}
