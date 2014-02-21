package com.onsalenext.base.service.test;

import java.util.List;

import com.onsalenext.base.domain.lookup.StateTypeLookup;

public interface TestService {

	public void setBrands ();
	public Long setStore ();
	public Long setCustomer ();
	public void setItem ();
	public void setColor ();
	public void setRating ();
	public void setSize ();
	public void setTag ();
	public List<StateTypeLookup> getStateTypes ();
	public void setTax ();
	public void createCart ();
	public void createOrder ();
}
