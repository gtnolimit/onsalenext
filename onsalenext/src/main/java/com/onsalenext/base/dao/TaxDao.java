package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.Tax;

public interface TaxDao {

	public Long add ( Tax tax );	
	public void edit ( Tax tax );	
	public List <Tax> getAll ();
	public Tax get ( Long id );

}
