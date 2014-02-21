package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.person.WishListDetail;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.service.converter.WishListDetailConvert;
import com.onsalenext.base.web.model.person.WishListDetailBom;

@Service
public class WishListDetailConvertImpl implements WishListDetailConvert {

	@Autowired
	private ItemConvert itemConvert;
	
	public WishListDetail convert ( WishListDetailBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new WishListDetail (o.getId(), itemConvert.convert (o.getItem(), action), 
				new Date (), new Date (), "admin");
		return new WishListDetail (o.getId(), itemConvert.convert (o.getItem(), action), 
				new Date (), "admin");
	}
	
	public WishListDetailBom convert ( WishListDetail o ){
		if ( o == null ) return null;
		return new WishListDetailBom (o.getId(), itemConvert.convert (o.getItem(), "SHORT") );
	}

	public Set<WishListDetail> convert ( Set<WishListDetailBom> o, String action){
		if ( o == null ) return null;
		Set <WishListDetail> is = new HashSet <WishListDetail> ();
		for ( WishListDetailBom i : o) is.add( this.convert ( i, action ) );
		return is;
	}
	
	public Set<WishListDetailBom> convert ( Set<WishListDetail> o){
		if ( o == null ) return null;
		Set <WishListDetailBom> is = new TreeSet <WishListDetailBom> ();
		for ( WishListDetail i : o) is.add( this.convert ( i ) );
		return is;
	}

}
