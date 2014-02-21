package com.onsalenext.base.domain.order;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;
import com.onsalenext.base.domain.Picture;
import com.onsalenext.base.domain.item.Item;

@Entity
@Table(name = "ORDER_DETAILS", schema="ONSALENEXT_ORDER")
public class OrderDetail extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="ORDER_DETAIL_ID")
		private Long id;
		@Column(name="PRICE", unique=false, nullable=false)
		private double price;
		@Column(name="QTY", unique=false, nullable=false)
		private int qty;
		@Column(name="SUBJECT", unique=false, nullable = true, length = 1500)
		private String subject;
		
		@OneToOne(cascade=CascadeType.MERGE)
		private Picture picture;
		
		@OneToOne(cascade = CascadeType.MERGE)
		private Item item;
		
		public OrderDetail () {}
		
		public OrderDetail (Long id, double price, int qty, String subject, Picture picture, Item item, Date upd, String user){
			this.id = id;
			this.price = price;
			this.qty = qty;
			this.subject = subject;
			this.picture = picture;
			this.item = item;
			this.upd = upd;
			this.user = user;
		}

		public OrderDetail (Long id, double price, int qty, String subject, Picture picture, Item item, Date cpd, Date upd, String user){
			this.id = id;
			this.price = price;
			this.qty = qty;
			this.subject = subject;
			this.picture = picture;
			this.item = item;
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

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}

		public Picture getPicture() {
			return picture;
		}

		public void setPicture(Picture picture) {
			this.picture = picture;
		}
		
}
