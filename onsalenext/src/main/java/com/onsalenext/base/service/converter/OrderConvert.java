package com.onsalenext.base.service.converter;

import java.util.List;
import java.util.Set;

import com.onsalenext.base.domain.order.Order;
import com.onsalenext.base.web.model.order.OrderBom;

public interface OrderConvert {
	
	public OrderBom convert ( Order o );
	public Order convert ( OrderBom o, String action );
	public Set<OrderBom> convert ( Set<Order> o );
	public Set<Order> convert ( Set<OrderBom> o, String action );
	public List<OrderBom> convert ( List<Order> o );
}
