package com.onsalenext.base.web.model.item;

public class SpecificationDetailBom implements Comparable<SpecificationDetailBom>{

	private Long id;
	private String value;
	
	public SpecificationDetailBom ( Long id, String value ){
		this.id = id;
		this.value = value;
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
	public int compareTo(SpecificationDetailBom o) {
		return value.compareTo(o.value);
	}

	
}
