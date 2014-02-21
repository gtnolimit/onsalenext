package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.item.BrandBom;

public interface BrandService {

	public Long add ( BrandBom brand );	
	public void edit ( BrandBom brand );	
	public void delete ( BrandBom brand );
	public void delete ( Long id );	
	public List <BrandBom> getAll ();
	public BrandBom get ( Long id );
	public BrandBom findByName ( String name );
	
	public List<BrandBom> getStoreBrand ( long storeId );
}
