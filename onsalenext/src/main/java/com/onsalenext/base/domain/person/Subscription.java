package com.onsalenext.base.domain.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;

@Entity
@Table(name = "SUBSCRIPTION", schema="ONSALENEXT_CUSTOMER")
public class Subscription   extends DBBase {

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name="SUBSCRIPTION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name = "PROMOTIONAL")
	private boolean promotional;
	@Column(name = "NEWLATTER")
	private boolean newsLetter;
	@Column(name = "COUPONS")
	private boolean coupons;
	
	public Subscription () {}
	
	public Subscription ( Long id, boolean promotional, boolean newsLetter, boolean coupons, Date upd, String user){
		this.coupons = coupons;
		this.id = id;
		this.promotional = promotional;
		this.newsLetter = newsLetter;
		this.upd = upd;
		this.user = user;
	}
	
	public Subscription ( Long id, boolean promotional, boolean newsLetter, boolean coupons, Date cpd, Date upd, String user){
		this.coupons = coupons;
		this.id = id;
		this.promotional = promotional;
		this.newsLetter = newsLetter;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
