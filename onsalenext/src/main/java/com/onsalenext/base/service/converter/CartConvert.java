package com.onsalenext.base.service.converter;

import java.util.List;

import com.onsalenext.base.domain.order.Cart;
import com.onsalenext.base.web.model.order.CartBom;

public interface CartConvert {

	public Cart convert (CartBom o, String action);
	public CartBom convert ( Cart o );
	public List <CartBom> convert ( List <Cart> o );
}
