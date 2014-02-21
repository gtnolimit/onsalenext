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
@Table(name = "SPECIFICATION", schema="ONSALENEXT_ITEM")
public class Specification extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SPECIFICATION_ID")
	private Long id;
	@Column(name = "ATTRIBUTE", nullable = true, length = 200)
	private String attribute;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "SPECIFICATION_DETAIL_LINK", 
		joinColumns = { @JoinColumn(name = "SPECIFICATION_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "DETAIL_ID") })
	private Set<SpecificationDetail> specificationDetails = new HashSet <SpecificationDetail> ();
	
	public Specification () {}
	
	public Specification ( Long id, String attribute, Set<SpecificationDetail> specificationDetails, Date upd, String user){
		this.id = id;
		this.attribute = attribute;
		this.specificationDetails = specificationDetails;
		this.upd = upd;
		this.user = user;
	}

	public Specification ( Long id, String attribute, Set<SpecificationDetail> specificationDetails, Date cpd, Date upd, String user){
		this.id = id;
		this.attribute = attribute;
		this.specificationDetails = specificationDetails;
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

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public Set<SpecificationDetail> getSpecificationDetails() {
		return specificationDetails;
	}

	public void setSpecificationDetails(
			Set<SpecificationDetail> specificationDetails) {
		this.specificationDetails = specificationDetails;
	}
}
