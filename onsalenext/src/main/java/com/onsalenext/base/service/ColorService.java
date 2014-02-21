package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.item.ColorBom;

public interface ColorService {

	public Long add ( ColorBom color );	
	public void edit ( ColorBom color );	
	public void delete ( ColorBom color );
	public void delete ( Long id );	
	public List <ColorBom> getAll ();
	public ColorBom get ( Long id );
	
}
