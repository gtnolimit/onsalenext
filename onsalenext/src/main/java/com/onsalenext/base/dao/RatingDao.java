package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.item.Rating;

public interface RatingDao {

	public Long add ( Rating o );	
	public void edit ( Rating o );	
	public List <Rating> getAll ();
	public Rating get ( Long id );

}
