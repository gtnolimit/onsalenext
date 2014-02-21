package com.onsalenext.base.web.model.item;

import com.onsalenext.base.web.model.person.CustomerBom;


public class CustomerReviewBom implements Comparable<CustomerReviewBom>{

	private Long id;
	private String review;
	private CustomerBom customer;
	
	public CustomerReviewBom ( Long id, String review, CustomerBom customer){
		this.id = id;
		this.review = review;
		this.customer = customer;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public CustomerBom getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBom customer) {
		this.customer = customer;
	}

	public int compareTo(CustomerReviewBom o) {
		return id.compareTo(o.id);
	}

	
}
