package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.item.Size;

public interface SizeDao {

	public Long add ( Size size );	
	public void edit ( Size size );	
	public List <Size> getAll ();
	public Size get ( Long id );
}
