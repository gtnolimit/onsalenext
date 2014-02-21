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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;
import com.onsalenext.base.domain.Ip;
import com.onsalenext.base.domain.Tax;
import com.onsalenext.base.domain.lookup.OrderTypeLookup;
import com.onsalenext.base.domain.person.Customer;

@Entity
@Table(name = "ORDER", schema="ONSALENEXT_ORDER")
public class Order extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private Long id;
	
	@Column(name="INVOICE_NUMBER")
	private String invoiceNumber;

	@Column(name="TRACKING_NUMBER", unique=false, nullable=true, length=50)
	private String trackingNumber;
	@Column(name="URL_TRACKING_NUMBER", unique=false, nullable=true, length=250)
	private String urlTrackingNumber;
	@Column(name="SHIPPING_COMPANY", unique=false, nullable=true, length=100)
	private String shippingCompany;
	@Column(name="PURCHASE_DATE", unique=false, nullable=false)
	private Date purchaseDate;
	@Column(name="CANCELED_DATE", unique=false, nullable=true)
	private Date canceledDate;
	@Column(name="REFUNDED_DATE", unique=false, nullable=true)
	private Date refundedDate;
	@Column(name="SHIPPED_DATE", unique=false, nullable=true)
	private Date shippedDate;
	@Column(name="BEFORE_TAX_TOTAL", unique=false, nullable=false)
	private double totalBeforeTax;
	@Column(name="SHIPPING_TOTAL", unique=false, nullable=true)
	private double shippingHandling;
	@Column(name="REFUNDABLE_TOTAL", unique=false, nullable=true)
	private double refundableTotal;
	@Column(name="ORDER_TOTAL", unique=false, nullable=false)
	private double orderTotal;
	@Column(name="ORDER_TAX", unique=false, nullable=false)
	private double orderTax;
	@Column(name="INVOICE_PDF_LOCATOR")
	private String invoicePdfLocator;
	@Column(name="STATUS")
	private boolean isActive;
	
	@OneToOne
	@JoinColumn (name="ORDER_STATUS")
	private OrderTypeLookup orderStatus;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ORDER_DETAIL_LINK", 
		joinColumns = { @JoinColumn(name = "ORDER_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "DETAIL_ID") })
	private Set<OrderDetail> orderDetails = new HashSet <OrderDetail> (0);
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Ip ip;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Customer customer;

	@OneToOne(cascade = CascadeType.MERGE)
	private Tax tax;

	public Order () {};
	
	public Order (Long id, String invoiceNumber, String trackingNumber, String urlTrackingNumber, String shippingCompany,
			Date purchaseDate, Date canceledDate, Date refundedDate, Date shippedDate, double totalBeforeTax,
			double shippingHandling, double refundableTotal, double orderTotal, double orderTax, String invoicePdfLocator,
			boolean isActive, Set<OrderDetail> orderDetails, Ip ip, Customer customer, Tax tax, 
			OrderTypeLookup orderStatus, Date upd, String user){
		
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.trackingNumber = trackingNumber;
		this.urlTrackingNumber = urlTrackingNumber;
		this.shippingCompany = shippingCompany;
		this.purchaseDate = purchaseDate;
		this.canceledDate = canceledDate;
		this.refundedDate = refundedDate;
		this.shippedDate = shippedDate;
		this.totalBeforeTax = totalBeforeTax;
		this.shippingHandling = shippingHandling;
		this.refundableTotal = refundableTotal;
		this.orderTotal = orderTotal;
		this.orderTax = orderTax;
		this.invoicePdfLocator = invoicePdfLocator;
		this.isActive = isActive;
		this.orderDetails = orderDetails;
		this.ip = ip;
		this.customer = customer;
		this.tax = tax;
		this.orderStatus = orderStatus;
		this.upd = upd;
		this.user = user;
	}
	
	public Order (Long id, String invoiceNumber, String trackingNumber, String urlTrackingNumber, String shippingCompany,
			Date purchaseDate, Date canceledDate, Date refundedDate, Date shippedDate, double totalBeforeTax,
			double shippingHandling, double refundableTotal, double orderTotal, double orderTax, String invoicePdfLocator,
			boolean isActive, Set<OrderDetail> orderDetails, Ip ip, Customer customer, Tax tax, 
			OrderTypeLookup orderStatus, Date cpd, Date upd, String user){
		
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.trackingNumber = trackingNumber;
		this.urlTrackingNumber = urlTrackingNumber;
		this.shippingCompany = shippingCompany;
		this.purchaseDate = purchaseDate;
		this.canceledDate = canceledDate;
		this.refundedDate = refundedDate;
		this.shippedDate = shippedDate;
		this.totalBeforeTax = totalBeforeTax;
		this.shippingHandling = shippingHandling;
		this.refundableTotal = refundableTotal;
		this.orderTotal = orderTotal;
		this.orderTax = orderTax;
		this.invoicePdfLocator = invoicePdfLocator;
		this.isActive = isActive;
		this.orderDetails = orderDetails;
		this.ip = ip;
		this.customer = customer;
		this.tax = tax;
		this.orderStatus = orderStatus;
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


	public String getInvoiceNumber() {
		return invoiceNumber;
	}


	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}


	public String getTrackingNumber() {
		return trackingNumber;
	}


	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}


	public String getUrlTrackingNumber() {
		return urlTrackingNumber;
	}


	public void setUrlTrackingNumber(String urlTrackingNumber) {
		this.urlTrackingNumber = urlTrackingNumber;
	}


	public String getShippingCompany() {
		return shippingCompany;
	}


	public void setShippingCompany(String shippingCompany) {
		this.shippingCompany = shippingCompany;
	}


	public Date getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public Date getCanceledDate() {
		return canceledDate;
	}


	public void setCanceledDate(Date canceledDate) {
		this.canceledDate = canceledDate;
	}


	public Date getRefundedDate() {
		return refundedDate;
	}


	public void setRefundedDate(Date refundedDate) {
		this.refundedDate = refundedDate;
	}


	public OrderTypeLookup getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(OrderTypeLookup orderStatus) {
		this.orderStatus = orderStatus;
	}


	public Date getShippedDate() {
		return shippedDate;
	}


	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}


	public double getTotalBeforeTax() {
		return totalBeforeTax;
	}


	public void setTotalBeforeTax(double totalBeforeTax) {
		this.totalBeforeTax = totalBeforeTax;
	}


	public double getShippingHandling() {
		return shippingHandling;
	}


	public void setShippingHandling(double shippingHandling) {
		this.shippingHandling = shippingHandling;
	}


	public double getRefundableTotal() {
		return refundableTotal;
	}


	public void setRefundableTotal(double refundableTotal) {
		this.refundableTotal = refundableTotal;
	}


	public double getOrderTotal() {
		return orderTotal;
	}


	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}


	public double getOrderTax() {
		return orderTax;
	}


	public void setOrderTax(double orderTax) {
		this.orderTax = orderTax;
	}


	public String getInvoicePdfLocator() {
		return invoicePdfLocator;
	}


	public void setInvoicePdfLocator(String invoicePdfLocator) {
		this.invoicePdfLocator = invoicePdfLocator;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}


	public Ip getIp() {
		return ip;
	}


	public void setIp(Ip ip) {
		this.ip = ip;
	}


	public Tax getTax() {
		return tax;
	}


	public void setTax(Tax tax) {
		this.tax = tax;
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
