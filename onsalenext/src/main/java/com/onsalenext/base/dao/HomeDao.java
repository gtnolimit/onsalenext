package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.Store;

public interface HomeDao {

	public Long add ( Store store );	
	public void edit ( Store store );	
	public void delete ( Store store );
	public void delete ( Long id );	
	public List <Store> getAll ();
	public Store get ( Long id );
	public Store getInfo ( Long id );
	public List <Store> getAllInfo ();
	public Store findByName ( String name );
	public Store findByNameInfo ( String name );
	public Store findByIp ( String ip );
	public Store findByIpInfo ( String ip );
}
