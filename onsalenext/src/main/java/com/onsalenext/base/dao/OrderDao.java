package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.order.Order;

public interface OrderDao {

	public Long add ( Order order );	
	public void edit ( Order order );	
	public void delete ( Order order );
	public void delete ( Long id );	
	public List<Order> getAll ();
	public Order get ( Long id );
	
	public List <Order> getOrdersForCustomer ( Long customerId );
	public Order getByInvoice ( String invoiceNumber );
	public Order getByIp ( String ip);
	
}
