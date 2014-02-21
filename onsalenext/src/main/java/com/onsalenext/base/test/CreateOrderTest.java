package com.onsalenext.base.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.onsalenext.base.domain.lookup.OrderTypeLookup;
import com.onsalenext.base.web.model.TaxBom;
import com.onsalenext.base.web.model.order.CartBom;
import com.onsalenext.base.web.model.order.CartDetailBom;
import com.onsalenext.base.web.model.order.OrderBom;
import com.onsalenext.base.web.model.order.OrderDetailBom;
import com.onsalenext.base.web.model.person.CustomerBom;

public class CreateOrderTest {
	
	public CreateOrderTest (){}
	
	public OrderBom createOrder ( CartBom cart ){
		double shippingHandling = 3.25;
		return new OrderBom ( null, "INV-34555433", "USPS-3445443322", null, "USPS",
				new Date(), null, null, new Date (), cart.getShoppingCartSubTotal(), shippingHandling,
				0.00, this.culcOrderTotal (), this.calcOrderTax(), null, true, this.createOrderDetails(cart.getCartDetails()),
				cart.getIp(), cart.getCustomer(), this.getTax(cart.getCustomer()) , OrderTypeLookup.C);
	}

	private double calcOrderTax (){
		return 0.00;
	}
	private TaxBom getTax (CustomerBom c) {
		return null;
	}
	private double culcOrderTotal (){
		return 300.00;
	}
 	private Set<OrderDetailBom> createOrderDetails ( Set<CartDetailBom> cart ){
		Set<OrderDetailBom> o = new HashSet <OrderDetailBom> ();
		for ( CartDetailBom c : cart ) o.add( this.createOrderDetail(c));
		return o;
	}
	private OrderDetailBom createOrderDetail ( CartDetailBom c ){
		return new OrderDetailBom (null, c.getPrice(), c.getQty(), c.getSubject(), c.getPicture(), c.getItem());
	}
}
