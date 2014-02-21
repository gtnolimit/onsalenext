package com.onsalenext.base.web.model.item;

import java.util.Set;
import java.util.TreeSet;

public class FeatureBom implements Comparable<FeatureBom>{

	private Long id;
	private String attribute;
	private boolean isActive;
	private Set<FeatureDetailBom>featureDetails = new TreeSet <FeatureDetailBom> ();
	
	public FeatureBom ( Long id, String attribute, boolean isActive, Set<FeatureDetailBom> featureDetails){
		this.id = id;
		this.attribute = attribute;
		this.isActive = isActive;
		this.featureDetails = featureDetails;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Set<FeatureDetailBom> getFeatureDetails() {
		return featureDetails;
	}
	public void setFeatureDetails(Set<FeatureDetailBom> featureDetails) {
		this.featureDetails = featureDetails;
	}
	public int compareTo(FeatureBom o) {
		return this.attribute.compareTo(o.attribute);
	}

	
}
