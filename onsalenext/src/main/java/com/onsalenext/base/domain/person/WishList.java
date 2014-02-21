package com.onsalenext.base.domain.person;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.onsalenext.base.domain.DBBase;

@Entity
@Table(name = "WISH_LIST", schema="ONSALENEXT_CUSTOMER")
public class WishList extends DBBase implements Serializable {

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@Column(name = "WISHLIST_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	public WishList () {}
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name="WISHLIST_DETAIL_LINK", 
                joinColumns={@JoinColumn(name="WISHLIST_ID")}, 
                inverseJoinColumns={@JoinColumn(name="DETAIL_ID")})
    private Set<WishListDetail> wishListDetails = new HashSet<WishListDetail>();

	public WishList ( Long id, Set<WishListDetail> wishListDetails, Date upd, String user){
		this.id = id;
		this.wishListDetails = wishListDetails;
		this.upd = upd;
		this.user = user;
	}

	public WishList ( Long id, Set<WishListDetail> wishListDetails, Date cpd, Date upd, String user){
		this.id = id;
		this.wishListDetails = wishListDetails;
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

	public Set<WishListDetail> getWishListDetails() {
		return wishListDetails;
	}

	public void setWishListDetails(Set<WishListDetail> wishListDetails) {
		this.wishListDetails = wishListDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
