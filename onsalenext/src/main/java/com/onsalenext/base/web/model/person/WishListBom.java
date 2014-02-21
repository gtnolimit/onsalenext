package com.onsalenext.base.web.model.person;

import java.util.Set;
import java.util.TreeSet;

public class WishListBom implements Comparable<WishListBom>{

	private Long id; 
    private Set<WishListDetailBom> wishListDetails = new TreeSet<WishListDetailBom>();
	
    public WishListBom ( Long id, Set<WishListDetailBom> wishListDetails){
    	this.id = id;
    	this.wishListDetails = wishListDetails;
    }
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<WishListDetailBom> getWishListDetails() {
		return wishListDetails;
	}
	public void setWishListDetails(Set<WishListDetailBom> wishListDetails) {
		this.wishListDetails = wishListDetails;
	}
	public int compareTo(WishListBom o) {
		return id.compareTo(o.id);
	}

    
}
