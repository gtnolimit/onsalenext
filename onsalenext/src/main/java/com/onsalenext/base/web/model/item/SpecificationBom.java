package com.onsalenext.base.web.model.item;

import java.util.Set;
import java.util.TreeSet;

public class SpecificationBom implements Comparable<SpecificationBom>{

	private Long id;
	private String attribute;
	private Set<SpecificationDetailBom> specificationDetails = new TreeSet <SpecificationDetailBom> ();

	public SpecificationBom ( Long id, String attribute, Set<SpecificationDetailBom> specificationDetails){
		this.id = id;
		this.attribute = attribute;
		this.specificationDetails = specificationDetails;
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
	public Set<SpecificationDetailBom> getSpecificationDetails() {
		return specificationDetails;
	}
	public void setSpecificationDetails(
			Set<SpecificationDetailBom> specificationDetails) {
		this.specificationDetails = specificationDetails;
	}

	public int compareTo(SpecificationBom o) {
		return attribute.compareTo(o.attribute);
	}

	
}
