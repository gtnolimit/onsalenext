package com.onsalenext.base.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onsalenext.base.domain.lookup.StateTypeLookup;

@Entity
@Table(name = "TAX", schema="ONSALENEXT_HOME")
public class Tax  extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "TAX_ID")
	private Long id;
	@Column(name = "TAX", unique=false, nullable=false)
	private double tax;
	@Column(name="STATUS")
	private boolean isActive;
	
	@OneToOne(cascade=CascadeType.MERGE)
	private StateTypeLookup stateType;
	
	public Tax () {}
	
	public Tax ( Long id, double tax, boolean isActive, StateTypeLookup stateType, Date upd, String user ){
		this.id = id;
		this.tax = tax;
		this.isActive = isActive;
		this.stateType = stateType;
		this.upd = upd;
		this.user = user;
	}
	
	public Tax ( Long id, double tax, boolean isActive, StateTypeLookup stateType, Date cpd, Date upd, String user ){
		this.id = id;
		this.tax = tax;
		this.isActive = isActive;
		this.stateType = stateType;
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
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
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
