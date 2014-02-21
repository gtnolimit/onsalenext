package com.onsalenext.base.domain.item;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;

@Entity
@Table(name = "RATING", schema="ONSALENEXT_ITEM")
public class Rating extends DBBase{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "RATING_ID")
	private Long id;
	@Column(name = "RATING", unique=true, nullable = false)
	private Double rating;
	
	public Rating () {}

	public Rating ( Long id, Double rating, Date upd, String user ){
		this.id = id;
		this.rating = rating;
		this.upd = upd;
		this.user = user;
	}

	public Rating ( Long id, Double rating, Date cpd, Date upd, String user ){
		this.id = id;
		this.rating = rating;
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
	
	public Double getRating() {
		return rating;
	}
	
	public void setRating( Double rating ) {
		this.rating = rating;
	}
}
