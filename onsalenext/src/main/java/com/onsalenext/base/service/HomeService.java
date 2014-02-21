package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.StoreBom;

public interface HomeService {
	
	public Long add ( StoreBom store );	
	public void edit ( StoreBom store );	
	public void delete ( StoreBom store );
	public void delete ( Long id );	
	public List <StoreBom> getAll ();
	public StoreBom get ( Long id );
	public StoreBom getInfo ( Long id );
	public List <StoreBom> getAllInfo ();
	public StoreBom findByName ( String name );
	public StoreBom findByNameInfo ( String name );
	public StoreBom findByIp ( String ip );
	public StoreBom findByIpInfo ( String ip );
}
