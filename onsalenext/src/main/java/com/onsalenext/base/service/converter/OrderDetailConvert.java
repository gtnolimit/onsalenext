package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.order.OrderDetail;
import com.onsalenext.base.web.model.order.OrderDetailBom;

public interface OrderDetailConvert {

	public Set<OrderDetail> convert ( Set <OrderDetailBom> orderDetails, String action );	
	public OrderDetail convert ( OrderDetailBom o, String action );	
	public Set<OrderDetailBom> convert ( Set <OrderDetail> orderDetails );
	public OrderDetailBom convert ( OrderDetail o );
}
