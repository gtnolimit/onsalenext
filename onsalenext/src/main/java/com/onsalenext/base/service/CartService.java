package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.order.CartBom;

public interface CartService {

	public Long add ( CartBom cart );	
	public void edit ( CartBom cart );	
	public void delete ( CartBom cart );
	public void delete ( Long id );	
	public List<CartBom> getAll ();
	public CartBom get ( Long id );
	
	public CartBom findCartByCustomerId ( Long customerId );
	public CartBom findCartBySession ( String session );
	public CartBom findCartByIp ( String ip );
}
