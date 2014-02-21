package com.onsalenext.base.web.model.order;

import java.util.Date;
import java.util.Set;

import com.onsalenext.base.domain.lookup.OrderTypeLookup;

public class OrderViewBom implements Comparable<OrderViewBom>{

	private Long id;
	private String invoiceNumber;
	private String trackingNumber;
	private String urlTrackingNumber;
	private Date purchaseDate;
	private double orderTotal;
	private String invoicePdfLocator;
	private boolean isActive;
	private OrderTypeLookup orderStatus;

	public OrderViewBom ( Long id, String invoiceNumber, String trackingNumber, String urlTrackingNumber, 
			Date purchaseDate, double orderTotal, String invoicePdfLocator,
			boolean isActive, Set<OrderDetailBom> orderDetails, OrderTypeLookup orderStatus){
		
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.trackingNumber = trackingNumber;
		this.urlTrackingNumber = urlTrackingNumber;
		this.purchaseDate = purchaseDate;
		this.orderTotal = orderTotal;
		this.invoicePdfLocator = invoicePdfLocator;
		this.isActive = isActive;
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

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
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

	public OrderTypeLookup getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderTypeLookup orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int compareTo(OrderViewBom o) {
		return invoiceNumber.compareTo(o.invoiceNumber);
	}
}
