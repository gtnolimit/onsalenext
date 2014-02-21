package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.order.Cart;

public interface CartDao {

	public Long add ( Cart cart );	
	public void edit ( Cart cart );	
	public void delete ( Cart cart );
	public void delete ( Long id );	
	public List <Cart> getAll ();
	public Cart get ( Long id );
	
	public Cart findByCustomerId ( Long customerId );
	public Cart findBySession ( String session );
	public Cart findByIp ( String ip );

}
