package com.onsalenext.base.web.model.person;

import java.util.Set;
import java.util.TreeSet;

public class RegistryBom implements Comparable<RegistryBom>{

	private Long id;
	private String number;
	private String name;
	private boolean isActive;
    private Set<RegistryDetailBom> registeryDetails = new TreeSet<RegistryDetailBom>();
	
    public RegistryBom ( Long id, String number, String name, boolean isActive, Set<RegistryDetailBom> registeryDetails){
    	this.id = id;
    	this.name = name;
    	this.number = number;
    	this.isActive = isActive;
    	this.registeryDetails = registeryDetails;
    }
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Set<RegistryDetailBom> getRegisteryDetails() {
		return registeryDetails;
	}
	public void setRegisteryDetails(Set<RegistryDetailBom> registeryDetails) {
		this.registeryDetails = registeryDetails;
	}

	public int compareTo(RegistryBom o) {
		return number.compareTo(o.number);
	}

    
}
