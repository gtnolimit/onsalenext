package com.onsalenext.base.web.model.order;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import com.onsalenext.base.domain.lookup.OrderTypeLookup;
import com.onsalenext.base.web.model.IpBom;
import com.onsalenext.base.web.model.TaxBom;
import com.onsalenext.base.web.model.person.CustomerBom;

public class OrderBom implements Comparable<OrderBom>{

	private Long id;
	private String invoiceNumber;
	private String trackingNumber;
	private String urlTrackingNumber;
	private String shippingCompany;
	private Date purchaseDate;
	private Date canceledDate;
	private Date refundedDate;
	private Date shippedDate;
	private double totalBeforeTax;
	private double shippingHandling;
	private double refundableTotal;
	private double orderTotal;
	private double orderTax;
	private String invoicePdfLocator;
	private boolean isActive;
	private OrderTypeLookup orderStatus;
	private Set<OrderDetailBom> orderDetails = new TreeSet <OrderDetailBom> ();
	private IpBom ip;
	private CustomerBom customer;
	private TaxBom tax;
	
	public OrderBom (Long id, String invoiceNumber, String trackingNumber, String urlTrackingNumber, String shippingCompany,
			Date purchaseDate, Date canceledDate, Date refundedDate, Date shippedDate, double totalBeforeTax,
			double shippingHandling, double refundableTotal, double orderTotal, double orderTax, String invoicePdfLocator,
			boolean isActive, Set<OrderDetailBom> orderDetails, IpBom ip, CustomerBom customer, TaxBom tax, 
			OrderTypeLookup orderStatus){
		
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
	public Set<OrderDetailBom> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<OrderDetailBom> orderDetails) {
		this.orderDetails = orderDetails;
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
	public TaxBom getTax() {
		return tax;
	}
	public void setTax(TaxBom tax) {
		this.tax = tax;
	}

	public int compareTo(OrderBom o) {
		return id.compareTo(o.id);
	}

	public OrderTypeLookup getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderTypeLookup orderStatus) {
		this.orderStatus = orderStatus;
	}

}
