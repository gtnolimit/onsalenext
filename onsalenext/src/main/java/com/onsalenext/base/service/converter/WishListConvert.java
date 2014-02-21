package com.onsalenext.base.service.converter;

import com.onsalenext.base.domain.person.WishList;
import com.onsalenext.base.web.model.person.WishListBom;

public interface WishListConvert {

	public WishList convert ( WishListBom o, String action );	
	public WishListBom convert ( WishList o );

}
