package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.order.CartDetail;
import com.onsalenext.base.service.converter.CartDetailConvert;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.service.converter.PictureConvert;
import com.onsalenext.base.web.model.order.CartDetailBom;

@Service
public class CartDetailConvertImpl implements CartDetailConvert {

	@Autowired
	private PictureConvert pictureConvert;
	@Autowired
	private ItemConvert itemConvert;

	public Set<CartDetail> convert(Set<CartDetailBom> o, String action) {
		Set<CartDetail> od = new HashSet <CartDetail>();
		for ( CartDetailBom c : o ) od.add ( this.convert (c, action) );
		return od;
	}

	public Set<CartDetailBom> convert(Set<CartDetail> o) {
		Set<CartDetailBom> od = new TreeSet <CartDetailBom>();
		for ( CartDetail c : o ) od.add ( this.convert ( c ) );
		return od;
	}

	public CartDetail convert(CartDetailBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new CartDetail ( o.getId (), o.getPrice (), o.getQty (), o.getSubject (), 
					pictureConvert.convert ( o.getPicture (), action ), 
				itemConvert.convert ( o.getItem (), action ), new Date (), new Date (), "admin" );
		return new CartDetail ( o.getId (), o.getPrice (), o.getQty (), o.getSubject (), 
				pictureConvert.convert ( o.getPicture (), action ), 
				itemConvert.convert ( o.getItem (), action ), new Date (), "admin" );	}

	public CartDetailBom convert(CartDetail o) {
		return new CartDetailBom ( o.getId (), o.getPrice (), o.getQty (), o.getSubject (), 
				pictureConvert.convert ( o.getPicture () ), 
				itemConvert.convert ( o.getItem (), "SHORT" ) );
	}

}
