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
import com.onsalenext.base.domain.person.Customer;

@Entity
@Table(name = "CUSOMER_REVIEW", schema="ONSALENEXT_ITEM")
public class CustomerReview extends DBBase implements Serializable{

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name = "REVIEW_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "REVIEW", unique=false, nullable = false, length = 2000)
	private String review;

	@OneToOne(cascade=CascadeType.MERGE)
	private Customer customer;
	
	public CustomerReview () {}
	
	public CustomerReview ( Long id, String review, Customer customer, Date upd, String user ){
		this.id = id;
		this.review = review;
		this.customer = customer;
		this.upd = upd;
		this.user = user;
	}

	public CustomerReview ( Long id, String review, Customer customer, Date cpd, Date upd, String user ){
		this.id = id;
		this.review = review;
		this.customer = customer;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
