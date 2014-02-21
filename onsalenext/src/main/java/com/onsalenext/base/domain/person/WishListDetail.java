package com.onsalenext.base.domain.person;

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
import com.onsalenext.base.domain.item.Item;

@Entity
@Table(name = "WISHLIST_DETAIL", schema="ONSALENEXT_CUSTOMER")
public class WishListDetail extends DBBase implements Serializable{

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name = "WISHLIST_DETAIL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.MERGE)
	private Item item;

	public WishListDetail () {}
	
	public WishListDetail ( Long id, Item item, Date upd, String user ) {
		this.upd = upd;
		this.user = user;
		this.id = id;
		this.item = item;
	}
	
	public WishListDetail ( Long id, Item item, Date cpd, Date upd, String user ) {
		this.cpd = cpd;
		this.upd = upd;
		this.user = user;
		this.id = id;
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}
