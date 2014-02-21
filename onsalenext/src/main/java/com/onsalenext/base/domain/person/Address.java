package com.onsalenext.base.domain.person;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;
import com.onsalenext.base.domain.lookup.AddressTypeLookup;
import com.onsalenext.base.domain.lookup.StateTypeLookup;


@Entity
@Table(name="ADDRESS", schema="ONSALENEXT_CUSTOMER")
public class Address extends DBBase implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name = "ADDRESS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn (name="ADDRESS_TYPE")
	private AddressTypeLookup addressType;
	@Column(name="ADDRESS_1", unique=false, nullable=false, length=250)
	private String addressLine1;
	@Column(name="ADDRESS_2", unique=false, nullable=true, length=250)
	private String addressLine2;
	@Column(name="CITY", unique=false, nullable=false, length=50)
	private String city;
	@OneToOne
	@JoinColumn (name="TYPE_STATE")
	private StateTypeLookup stateType;
	@Column(name="ZIP", unique=false, nullable=false, length=10)
	private String zip;
	@Column(name="STATUS")
	private boolean isActive;
	
	public Address () {}
	
	public Address (Long id, AddressTypeLookup addressType, String addressLine1, 
			String addressLine2, String city, StateTypeLookup stateType, String zip, 
			boolean isActive, Date upd, String user){
		
		this.id = id; 
		this.addressType = addressType; 
		this.addressLine1 = addressLine1; 
		this.addressLine2 = addressLine2; 
		this.city = city; 
		this.stateType = stateType; 
		this.zip = zip; 
		this.isActive = isActive;
		this.upd = upd;
		this.user = user;
	}
	
	public Address (Long id, AddressTypeLookup addressType, String addressLine1, 
			String addressLine2, String city, StateTypeLookup stateType, String zip, 
			boolean isActive, Date cpd, Date upd, String user){
		
		this.id = id; 
		this.addressType = addressType; 
		this.addressLine1 = addressLine1; 
		this.addressLine2 = addressLine2; 
		this.city = city; 
		this.stateType = stateType; 
		this.zip = zip; 
		this.isActive = isActive;
		this.cpd = cpd;
		this.upd = upd;
		this.user = user;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public StateTypeLookup getStateType() {
		return stateType;
	}

	public void setStateType(StateTypeLookup stateType) {
		this.stateType = stateType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
