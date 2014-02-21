package com.onsalenext.base.service.converter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.order.Order;
import com.onsalenext.base.service.converter.CustomerConvert;
import com.onsalenext.base.service.converter.IpConvert;
import com.onsalenext.base.service.converter.OrderConvert;
import com.onsalenext.base.service.converter.OrderDetailConvert;
import com.onsalenext.base.service.converter.TaxConvert;
import com.onsalenext.base.web.model.order.OrderBom;

@Service
public class OrderConvertImpl implements OrderConvert{
	
	@Autowired
	private OrderDetailConvert orderDetailConvert;
	@Autowired
	private TaxConvert taxConvert;
	@Autowired
	private IpConvert ipConvert;
	@Autowired
	private CustomerConvert customerConvert;
	
	public Order convert  ( OrderBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Order ( o.getId (), o.getInvoiceNumber (), o.getTrackingNumber (), o.getUrlTrackingNumber (), 
				o.getShippingCompany (), o.getPurchaseDate (), o.getCanceledDate (), o.getRefundedDate (), 
				o.getShippedDate (), o.getTotalBeforeTax (), o.getShippingHandling (), o.getRefundableTotal (), 
				o.getOrderTotal (), o.getOrderTax (), o.getInvoicePdfLocator (), o.isActive (), 
				orderDetailConvert.convert ( o.getOrderDetails(), action ), 
				ipConvert.convert ( o.getIp (), action ), 
				customerConvert.convert ( o.getCustomer (), action ), 
				taxConvert.convert ( o.getTax (), action ), 
				o.getOrderStatus (), new Date (), new Date (), "admin" );
		return new Order ( o.getId (), o.getInvoiceNumber (), o.getTrackingNumber (), o.getUrlTrackingNumber (), 
				o.getShippingCompany (), o.getPurchaseDate (), o.getCanceledDate (), o.getRefundedDate (), 
				o.getShippedDate (), o.getTotalBeforeTax (), o.getShippingHandling (), o.getRefundableTotal (), 
				o.getOrderTotal (), o.getOrderTax (), o.getInvoicePdfLocator (), o.isActive (), 
				orderDetailConvert.convert ( o.getOrderDetails(), action ), 
				ipConvert.convert ( o.getIp (), action ), 
				customerConvert.convert ( o.getCustomer (),action ),
				taxConvert.convert ( o.getTax (), action ), 
				o.getOrderStatus (), new Date (), "admin" );
	}

	public OrderBom convert  ( Order o ){
		return new OrderBom ( o.getId (), o.getInvoiceNumber (), o.getTrackingNumber (), o.getUrlTrackingNumber (), 
				o.getShippingCompany (), o.getPurchaseDate (), o.getCanceledDate (), o.getRefundedDate (), 
				o.getShippedDate (), o.getTotalBeforeTax (), o.getShippingHandling (), o.getRefundableTotal (), 
				o.getOrderTotal (), o.getOrderTax (), o.getInvoicePdfLocator (), o.isActive (), 
				orderDetailConvert.convert  ( o.getOrderDetails() ), 
				ipConvert.convert  ( o.getIp () ), 
				customerConvert.convert  ( o.getCustomer (), "ITEM" ), 
				taxConvert.convert  ( o.getTax () ), 
				o.getOrderStatus () );
	}

	public Set<OrderBom> convert(Set<Order> o) {
		Set<OrderBom> ss = new TreeSet <OrderBom> ();
		for ( Order s : o ) ss.add( this.convert ( s ));
		return ss;
	}

	public Set<Order> convert(Set<OrderBom> o, String action) {
		Set<Order> ss = new HashSet <Order> ();
		for ( OrderBom s : o ) ss.add( this.convert ( s, action ));
		return ss;
	}

	public List<OrderBom> convert(List<Order> o) {
		List<OrderBom> ss = new ArrayList <OrderBom> ();
		for ( Order s : o ) ss.add( this.convert ( s ));
		Collections.sort(ss);
		return ss;
	}
}
