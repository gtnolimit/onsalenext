package com.onsalenext.base.web.model.order;

import java.util.Set;
import java.util.TreeSet;

import com.onsalenext.base.web.model.IpBom;
import com.onsalenext.base.web.model.person.CustomerBom;


public class CartBom implements Comparable<CartBom>{

	private Long id;
	private double shoppingCartSubTotal;
	private int itemCount;
 	private Set<CartDetailBom> cartDetails = new TreeSet <CartDetailBom> ();
	private IpBom ip;
	private CustomerBom customer;
	
	public CartBom (Long id, double shoppingCartSubTotal, int itemCount, Set<CartDetailBom> cartDetails, 
			IpBom ip, CustomerBom customer){
		this.shoppingCartSubTotal = shoppingCartSubTotal;
		this.id = id;
		this.itemCount = itemCount;
		this.cartDetails = cartDetails;
		this.ip = ip;
		this.customer = customer;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getShoppingCartSubTotal() {
		return shoppingCartSubTotal;
	}
	public void setShoppingCartSubTotal(double shoppingCartSubTotal) {
		this.shoppingCartSubTotal = shoppingCartSubTotal;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public Set<CartDetailBom> getCartDetails() {
		return cartDetails;
	}
	public void setCartDetails(Set<CartDetailBom> cartDetails) {
		this.cartDetails = cartDetails;
	}
	public IpBom getIp() {
		return ip;
	}
	public void setIp(IpBom ip) {
		this.ip = ip;
	}
	public CustomerBom getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBom customer) {
		this.customer = customer;
	}

	public int compareTo(CartBom o) {
		return id.compareTo(o.id);
	}

}
