package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.item.Color;

public interface ColorDao {

	public Long add ( Color color );	
	public void edit ( Color color );	
	public void delete ( Color color );
	public void delete ( Long id );	
	public List <Color> getAll ();
	public Color get ( Long id );
}
