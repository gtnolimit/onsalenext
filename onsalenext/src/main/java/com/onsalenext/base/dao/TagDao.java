package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.item.Tag;

public interface TagDao {

	public Long add ( Tag tag );	
	public void edit ( Tag tag );	
	public List <Tag> getAll ();
	public Tag get ( Long id );

}
