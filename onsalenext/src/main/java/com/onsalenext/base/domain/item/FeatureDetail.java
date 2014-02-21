package com.onsalenext.base.domain.item;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;

@Entity
@Table(name = "FEATURE_DETAIL", schema="ONSALENEXT_ITEM")
public class FeatureDetail extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "FEATURE_DETAIL_ID")
	private Long id;
	@Column(name = "VALUE", nullable = true, length = 500)
	private String value;
	
	public FeatureDetail () {}
	
	public FeatureDetail ( Long id, String value, Date upd, String user ){
		this.id = id;
		this.value = value;
		this.upd = upd;
		this.user = user;
	
	}

	public FeatureDetail ( Long id, String value, Date cpd, Date upd, String user ){
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
