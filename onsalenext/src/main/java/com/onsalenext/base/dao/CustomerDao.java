package com.onsalenext.base.dao;

import java.util.List;

//import com.onsalenext.base.domain.order.Order;
import com.onsalenext.base.domain.person.Customer;
import com.onsalenext.base.domain.person.Registry;
import com.onsalenext.base.domain.person.WishList;

public interface CustomerDao {
	
	public Long add ( Customer customer );	
	public void edit ( Customer customer );	
	public void delete ( Customer customer );
	public void delete ( Long id );	
	public List <Customer> getAll ();
	//public List<Order> getCustomerOrders ( Long id );
	public WishList getWishList ( Long customerId );
	public List<Registry> getRegistry ( Long customerId );
	public Customer get ( Long id );

}
