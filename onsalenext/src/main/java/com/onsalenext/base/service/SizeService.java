package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.item.SizeBom;

public interface SizeService {

	public Long add ( SizeBom size );	
	public void edit ( SizeBom size );	
	public void delete ( SizeBom size );
	public void delete ( Long id );	
	public List <SizeBom> getAll ();
	public SizeBom get ( Long id );
}
