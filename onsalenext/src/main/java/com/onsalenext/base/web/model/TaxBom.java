package com.onsalenext.base.web.model;

import com.onsalenext.base.domain.lookup.StateTypeLookup;

public class TaxBom  implements Comparable<TaxBom>{

	private Long id;
	private double tax;
	private boolean isActive;
	private StateTypeLookup stateType;
	
	public TaxBom ( Long id, double tax, boolean isActive, StateTypeLookup stateType ){
		this.id = id;
		this.tax = tax;
		this.isActive = isActive;
		this.stateType = stateType;
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

	public int compareTo(TaxBom o) {
		return this.id.compareTo(o.id);
	}
}
