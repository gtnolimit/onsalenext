package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.item.RatingBom;

public interface RatingService {

	public Long add ( RatingBom o );	
	public void edit ( RatingBom o );	
	public void delete ( RatingBom o );
	public void delete ( Long id );	
	public List <RatingBom> getAll ();
	public RatingBom get ( Long id );
}
