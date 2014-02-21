package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Accessories;
import com.onsalenext.base.service.converter.AccessoriesConvert;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.web.model.item.AccessoriesBom;

@Service
public class AccessoriesConvertImpl implements AccessoriesConvert {

	@Autowired
	private ItemConvert item;
	
	public AccessoriesBom convert(Accessories o) {
		if ( o == null ) return null;
		return new AccessoriesBom ( o.getId (), o.isActive(), item.convert ( o.getItem(), "SHORT" ));
	}

	public Accessories convert(AccessoriesBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Accessories ( o.getId (), o.isActive(), item.convert ( o.getItem(), action ), 
				new Date (), new Date (), "admin" );
		return new Accessories ( o.getId (), o.isActive(), item.convert ( o.getItem(), action ), 
				new Date (), "admin" );
	}

	public Set<AccessoriesBom> convert(Set<Accessories> o) {
		if ( o == null ) return null;
		Set<AccessoriesBom> as = new TreeSet <AccessoriesBom> ();
		for ( Accessories a : o ) as.add( this.convert( a ));
		return as;
	}

	public Set<Accessories> convert(Set<AccessoriesBom> o, String action) {
		if ( o == null ) return null;
		Set<Accessories> as = new HashSet <Accessories> ();
		for ( AccessoriesBom a : o ) as.add( this.convert( a, action ));
		return as;
	}

}
