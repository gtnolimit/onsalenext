package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.person.CustomerBom;

public interface CustomerService {

	public Long add ( CustomerBom customer );	
	public void add ( List <CustomerBom> customer );
	public void edit ( CustomerBom customer );	
	public void delete ( CustomerBom customer );
	public void delete ( Long id );	
	public void addItemToWishList ( Long customerId, Long itemId );
	public void addItemToRegstry ( Long customerId, String registryName, Long itemId );
	public List <CustomerBom> getAll ();
	public CustomerBom get ( Long id );
}
