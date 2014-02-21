package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.item.TagBom;

public interface TagService {

	public Long add ( TagBom tag );	
	public void edit ( TagBom tag );	
	public void delete ( TagBom tag );
	public void delete ( Long id );	
	public List <TagBom> getAll ();
	public TagBom get ( Long id );
	
}
