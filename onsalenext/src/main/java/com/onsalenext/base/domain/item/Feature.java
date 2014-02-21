package com.onsalenext.base.domain.item;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;

@Entity
@Table(name = "FEATURES", schema="ONSALENEXT_ITEM")
public class Feature extends DBBase implements Serializable{
	
	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "FEATURES_ID")
	private Long id;
	@Column(name = "ATTRIBUTE", nullable = true, length = 1000)
	private String attribute;
	@Column(name="STATUS")
	private boolean isActive;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "FEATURE_DETAIL_LINK", 
		joinColumns = { @JoinColumn(name = "FEATURE_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "DETAIL_ID") })
	private Set<FeatureDetail>featureDetails = new HashSet <FeatureDetail> (0);
	
	public Feature () {}
	
	public Feature ( Long id, String attribute, boolean isActive, Set<FeatureDetail> featureDetails, Date upd, String user){
		this.id = id;
		this.attribute = attribute;
		this.featureDetails = featureDetails;
		this.isActive = isActive;
		this.upd = upd;
		this.user = user;
	}

	public Feature ( Long id, String attribute, boolean isActive, Set<FeatureDetail> featureDetails, Date cpd, Date upd, String user){
		this.id = id;
		this.attribute = attribute;
		this.featureDetails = featureDetails;
		this.isActive = isActive;
		this.cpd = cpd;
		this.upd = upd;
		this.user = user;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<FeatureDetail> getFeatureDetails() {
		return featureDetails;
	}
	public void setFeatureDetails(Set<FeatureDetail> featureDetails) {
		this.featureDetails = featureDetails;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
