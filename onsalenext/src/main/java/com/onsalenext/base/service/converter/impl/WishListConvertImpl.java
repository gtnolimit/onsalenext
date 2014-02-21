package com.onsalenext.base.service.converter.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.person.WishList;
import com.onsalenext.base.service.converter.WishListConvert;
import com.onsalenext.base.service.converter.WishListDetailConvert;
import com.onsalenext.base.web.model.person.WishListBom;

@Service
public class WishListConvertImpl implements WishListConvert {

	@Autowired
	private WishListDetailConvert wishListDetail;
	
	public WishList convert ( WishListBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new WishList (o.getId(), wishListDetail.convert (o.getWishListDetails(), action),
					new Date (), new Date (), "admin");
		return new WishList (o.getId(), wishListDetail.convert (o.getWishListDetails(), action),
				new Date (), "admin");
	}
	
	public WishListBom convert ( WishList o ){
		if ( o == null ) return null;
		return new WishListBom ( o.getId(), wishListDetail.convert ( o.getWishListDetails () ) );
	}
}
