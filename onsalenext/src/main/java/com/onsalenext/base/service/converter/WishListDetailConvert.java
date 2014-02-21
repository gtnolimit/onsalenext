package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.person.WishListDetail;
import com.onsalenext.base.web.model.person.WishListDetailBom;

public interface WishListDetailConvert {

	public WishListDetail convert ( WishListDetailBom o, String action );	
	public WishListDetailBom convert ( WishListDetail o );
	public Set<WishListDetail> convert ( Set<WishListDetailBom> o, String action);	
	public Set<WishListDetailBom> convert ( Set<WishListDetail> o);
}
