package com.onsalenext.base.domain.order;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;
import com.onsalenext.base.domain.Ip;
import com.onsalenext.base.domain.person.Customer;

@Entity
@Table(name = "CART", schema="ONSALENEXT_ORDER")
public class Cart extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CART_ID")
	private Long id;
	@Column(name="CART_SUB_TOTAL", unique=false, nullable=false)
	private double shoppingCartSubTotal;
	@Column(name="ITEMS_COUNT", unique=false, nullable=false)
	private int itemCount;
 
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CART_DETAIL_LINK", 
		joinColumns = { @JoinColumn(name = "CART_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "DETAIL_ID") })
	private Set<CartDetail> cartDetails = new HashSet <CartDetail> (0);
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ip ip;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Customer customer;
	
	public Cart () {}; 
	
	public Cart (Long id, double shoppingCartSubTotal, int itemCount, Set<CartDetail> cartDetails, 
			Ip ip, Customer customer, Date upd, String user ){
		this.shoppingCartSubTotal = shoppingCartSubTotal;
		this.id = id;
		this.itemCount = itemCount;
		this.cartDetails = cartDetails;
		this.ip = ip;
		this.customer = customer;
		this.upd = upd;
		this.user = user;
	}
	
	public Cart (Long id, double shoppingCartSubTotal, int itemCount, Set<CartDetail> cartDetails, 
			Ip ip, Customer customer, Date cpd, Date upd, String user ){
		this.shoppingCartSubTotal = shoppingCartSubTotal;
		this.id = id;
		this.itemCount = itemCount;
		this.cartDetails = cartDetails;
		this.ip = ip;
		this.customer = customer;
		this.cpd = cpd;
		this.upd = upd;
		this.user = user;
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

	public Set<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(Set<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public Ip getIp() {
		return ip;
	}

	public void setIp(Ip ip) {
		this.ip = ip;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
