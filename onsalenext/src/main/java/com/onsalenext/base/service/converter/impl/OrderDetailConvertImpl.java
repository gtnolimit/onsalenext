package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.order.OrderDetail;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.service.converter.OrderDetailConvert;
import com.onsalenext.base.service.converter.PictureConvert;
import com.onsalenext.base.web.model.order.OrderDetailBom;

@Service
public class OrderDetailConvertImpl implements OrderDetailConvert{
	
	@Autowired
	private PictureConvert pictureConvert;
	@Autowired
	private ItemConvert itemConvert;
	
	public Set<OrderDetail> convert ( Set <OrderDetailBom> orderDetails, String action ){
		Set<OrderDetail> od = new HashSet <OrderDetail>();
		for ( OrderDetailBom o : orderDetails ) od.add ( this.convert (o, action) );
		return od;
	}
	
	public OrderDetail convert ( OrderDetailBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new OrderDetail ( o.getId (), o.getPrice (), o.getQty (), o.getSubject (), 
					pictureConvert.convert ( o.getPicture (), action ), 
				itemConvert.convert ( o.getItem (), action ), new Date (), new Date (), "admin" );
		return new OrderDetail ( o.getId (), o.getPrice (), o.getQty (), o.getSubject (), 
				pictureConvert.convert ( o.getPicture (), action ), 
				itemConvert.convert ( o.getItem (), action ), new Date (), "admin" );
	}
	
	public Set<OrderDetailBom> convert ( Set <OrderDetail> orderDetails ){
		Set<OrderDetailBom> od = new TreeSet <OrderDetailBom>();
		for ( OrderDetail o : orderDetails ) od.add ( this.convert ( o ) );
		return od;
	}

	public OrderDetailBom convert ( OrderDetail o ){
		return new OrderDetailBom ( o.getId (), o.getPrice (), o.getQty (), o.getSubject (), 
				pictureConvert.convert ( o.getPicture () ), 
				itemConvert.convert ( o.getItem (), "SHORT" ) );
	}
}
