package com.onsalenext.base.domain.person;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;

@Entity
@Table(name = "REGISTRY", schema="ONSALENEXT_CUSTOMER")
public class Registry extends DBBase implements Serializable{

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name = "REGISTRY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "NUMBER", unique=false, nullable=false, length=200)
	private String number;
	@Column(name = "NAME", unique=false, nullable=false, length=200)
	private String name;
	@Column(name="STATUS")
	private boolean isActive;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name="REGISTRY_DETAIL_LINK", 
                joinColumns={@JoinColumn(name="REGISTRY_ID")}, 
                inverseJoinColumns={@JoinColumn(name="DETAIL_ID")})
    private Set<RegistryDetail> registeryDetails = new HashSet<RegistryDetail>();

	public Registry () {}
	
    public Registry ( Long id, String number, String name, boolean isActive, 
    		Set<RegistryDetail> registeryDetails, Date upd, String user){
    	this.id = id;
    	this.name = name;
    	this.number = number;
    	this.isActive = isActive;
    	this.registeryDetails = registeryDetails;
    	this.upd = upd;
    	this.user = user;
    }
    
    public Registry ( Long id, String number, String name, boolean isActive, 
    		Set<RegistryDetail> registeryDetails, Date cpd, Date upd, String user){
    	this.id = id;
    	this.name = name;
    	this.number = number;
    	this.isActive = isActive;
    	this.registeryDetails = registeryDetails;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Set<RegistryDetail> getRegisteryDetails() {
		return registeryDetails;
	}

	public void setRegisteryDetails(Set<RegistryDetail> registeryDetails) {
		this.registeryDetails = registeryDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
