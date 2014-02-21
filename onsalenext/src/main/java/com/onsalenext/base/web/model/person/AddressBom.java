package com.onsalenext.base.web.model.person;

import com.onsalenext.base.domain.lookup.AddressTypeLookup;
import com.onsalenext.base.domain.lookup.StateTypeLookup;

public class AddressBom implements Comparable<AddressBom>{

	private Long id;
	private AddressTypeLookup addressType;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private StateTypeLookup stateType;
	private String zip;
	private boolean isActive;
	
	public AddressBom (Long id, AddressTypeLookup addressType, String addressLine1, String addressLine2,
			String city, StateTypeLookup stateType, String zip, boolean isActive){
		this.id = id;
		this.addressType = addressType;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.stateType = stateType;
		this.zip = zip;
		this.isActive = isActive;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AddressTypeLookup getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressTypeLookup addressType) {
		this.addressType = addressType;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public StateTypeLookup getStateType() {
		return stateType;
	}
	public void setStateType(StateTypeLookup stateType) {
		this.stateType = stateType;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int compareTo(AddressBom o) {
		return id.compareTo(o.id);
	}

}
