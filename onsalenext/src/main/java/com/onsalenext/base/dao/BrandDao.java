package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.item.Brand;

public interface BrandDao {
	public Long add ( Brand brand );	
	public void edit ( Brand brand );	
	public void delete ( Brand brand );
	public void delete ( Long id );	
	public List <Brand> getAll ();
	public Brand get ( Long id );
	public Brand findByName ( String name );
	
	public List<Brand> getStoreBrand ( long storeId );
}
