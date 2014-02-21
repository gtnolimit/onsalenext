package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.order.CartDetail;
import com.onsalenext.base.web.model.order.CartDetailBom;

public interface CartDetailConvert {

	public Set <CartDetail> convert ( Set<CartDetailBom> o, String action );
	public Set <CartDetailBom> convert ( Set<CartDetail> o );
	public CartDetail convert ( CartDetailBom o, String action );	
	public CartDetailBom convert ( CartDetail o );
}
