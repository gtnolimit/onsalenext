package com.onsalenext.base.web.model.person;

public class SubscriptionBom implements Comparable<SubscriptionBom>{

	private Long id; 
	private boolean promotional;
	private boolean newsLetter;
	private boolean coupons;
	
	public SubscriptionBom ( Long id, boolean promotional, boolean newsLetter, boolean coupons){
		this.coupons = coupons;
		this.id = id;
		this.promotional = promotional;
		this.newsLetter = newsLetter;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isPromotional() {
		return promotional;
	}
	public void setPromotional(boolean promotional) {
		this.promotional = promotional;
	}
	public boolean isNewsLetter() {
		return newsLetter;
	}
	public void setNewsLetter(boolean newsLetter) {
		this.newsLetter = newsLetter;
	}
	public boolean isCoupons() {
		return coupons;
	}
	public void setCoupons(boolean coupons) {
		this.coupons = coupons;
	}
	public int compareTo(SubscriptionBom o) {
		return id.compareTo(o.id);
	}
}
