package com.onsalenext.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.OrderDao;
import com.onsalenext.base.service.OrderService;
import com.onsalenext.base.service.converter.OrderConvert;
import com.onsalenext.base.web.model.order.OrderBom;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderConvert orderConvert;
	
	public Long add ( OrderBom o ) {
		return orderDao.add ( orderConvert.convert ( o, "ADD" ) );
	}

	public void edit ( OrderBom order ) {
		orderDao.edit ( orderConvert.convert ( order, "EDIT" ) );
	}

	public void delete ( OrderBom order ) {
		orderDao.delete ( orderConvert.convert ( order, "DELETE" ) );
	}

	public void delete ( Long id ) {
		orderDao.delete(id);
	}

	public List<OrderBom> getAll() {
		return orderConvert.convert ( orderDao.getAll ( ) );
	}

	public OrderBom get(Long id) {
		return orderConvert.convert ( orderDao.get ( id ) );
	}

	public List<OrderBom> getOrdersForCustomer(Long customerId) {
		return orderConvert.convert ( orderDao.getOrdersForCustomer ( customerId ) );
	}
	
	public OrderBom getByInvoice(String invoiceNumber) {
		return orderConvert.convert ( orderDao.getByInvoice ( invoiceNumber ) );
	}
	
 	public OrderBom getByIp(String ip) {
		return orderConvert.convert ( orderDao.getByIp ( ip ) );
	}
}
