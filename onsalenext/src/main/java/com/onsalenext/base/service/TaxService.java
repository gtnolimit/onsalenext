package com.onsalenext.base.service;

import java.util.List; 

import com.onsalenext.base.web.model.TaxBom;

public interface TaxService {

	public Long add ( TaxBom tax );	
	public void edit ( TaxBom tax );	
	public List <TaxBom> getAll ();
	public TaxBom get ( Long id );

}
