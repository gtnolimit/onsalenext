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
@Table(name = "REVIEW_CON", schema="ONSALENEXT_ITEM")
public class ReviewCon extends DBBase{

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name = "CON_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	@Column(name = "VALUE", unique=false, nullable = false, length = 1000)
	private String value;

	public ReviewCon () {}
	
	public ReviewCon ( Long id, String value, Date upd, String user ){
		this.id = id;
		this.value = value;
		this.upd = upd;
		this.user = user;
	}
	
	public ReviewCon ( Long id, String value, Date cpd, Date upd, String user ){
		this.id = id;
		this.value = value;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
