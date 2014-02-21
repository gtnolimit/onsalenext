package com.onsalenext.base.web.model.order;

import com.onsalenext.base.web.model.PictureBom;
import com.onsalenext.base.web.model.item.ItemBom;


public class CartDetailBom implements Comparable<CartDetailBom>{

	private Long id;
	private double price;
	private int qty;
	private String subject;
	private PictureBom picture;
	private ItemBom item;

	public CartDetailBom (Long id, double price, int qty, String subject, PictureBom picture, ItemBom item){
		this.id = id;
		this.price = price;
		this.qty = qty;
		this.subject = subject;
		this.picture = picture;
		this.item = item;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public ItemBom getItem() {
		return item;
	}
	public void setItem(ItemBom item) {
		this.item = item;
	}

	public PictureBom getPicture() {
		return picture;
	}
	public void setPicture(PictureBom picture) {
		this.picture = picture;
	}
	public int compareTo(CartDetailBom o) {
		return subject.compareTo(o.subject);
	}

}
