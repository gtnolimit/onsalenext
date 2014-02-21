package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.order.OrderBom;

public interface OrderService {

	public Long add ( OrderBom order );	
	public void edit ( OrderBom order );	
	public void delete ( OrderBom order );
	public void delete ( Long id );	
	public List<OrderBom> getAll ();
	public OrderBom get ( Long id );
	
	public List <OrderBom> getOrdersForCustomer ( Long customerId );
	public OrderBom getByInvoice ( String invoiceNumber );
	public OrderBom getByIp ( String ip );
	
}
