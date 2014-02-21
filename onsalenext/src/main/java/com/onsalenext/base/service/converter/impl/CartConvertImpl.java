package com.onsalenext.base.service.converter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.order.Cart;
import com.onsalenext.base.service.converter.CartConvert;
import com.onsalenext.base.service.converter.CartDetailConvert;
import com.onsalenext.base.service.converter.CustomerConvert;
import com.onsalenext.base.service.converter.IpConvert;
import com.onsalenext.base.web.model.order.CartBom;

@Service
public class CartConvertImpl implements CartConvert {

	@Autowired
	private CartDetailConvert cartDetailConvert;
	@Autowired
	private IpConvert ipConvert;
	@Autowired
	private CustomerConvert customerConvert;
	
	public List <CartBom> convert ( List <Cart> o ){
		List <CartBom> cl = new ArrayList <CartBom> ();
		for ( Cart c : o ) cl.add ( this.convert (c) );
		Collections.sort( cl );
		return cl;
	}
	
	public Cart convert (CartBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD"))
			return new Cart (o.getId (), o.getShoppingCartSubTotal (), o.getItemCount (), 
					cartDetailConvert.convert ( o.getCartDetails (), action ), ipConvert.convert ( o.getIp (), action ), 
					customerConvert.convert ( o.getCustomer (), action ), 
				new Date (), new Date (), "admin");
		return new Cart (o.getId (), o.getShoppingCartSubTotal (), o.getItemCount (), 
				cartDetailConvert.convert ( o.getCartDetails (), action ), ipConvert.convert ( o.getIp (), action ), 
				customerConvert.convert ( o.getCustomer (), action ), 
				new Date (), "admin");
	}

	public CartBom convert ( Cart o ) {
		return new CartBom (o.getId (), o.getShoppingCartSubTotal (), o.getItemCount (), 
				cartDetailConvert.convert ( o.getCartDetails () ), ipConvert.convert ( o.getIp () ), 
				customerConvert.convert ( o.getCustomer (), "ITEM" ));
	}
}
