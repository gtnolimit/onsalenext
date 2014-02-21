package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.ReviewCon;
import com.onsalenext.base.service.converter.ReviewConConvert;
import com.onsalenext.base.web.model.item.ReviewConBom;

@Service
public class ReviewConConverterImpl implements ReviewConConvert {

	public Set <ReviewCon> convert ( Set <ReviewConBom> o, String action ){
		if ( o == null ) return null;
		Set <ReviewCon> rs = new HashSet <ReviewCon> ();
		for ( ReviewConBom r : o ) 	rs.add ( this.convert ( r, action ) );
		return rs;
	}
	
	public Set <ReviewConBom> convert ( Set <ReviewCon> o ){
		if ( o == null ) return null;
		Set <ReviewConBom> rs = new TreeSet <ReviewConBom> ();
		for ( ReviewCon r : o ) rs.add ( this.convert ( r ) );
		return rs;
	}

	public ReviewCon convert ( ReviewConBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new ReviewCon ( o.getId(), o.getValue(), new Date (), new Date (), "admin" );
		return new ReviewCon ( o.getId(), o.getValue(), new Date (), "admin" );
	}
	
	public ReviewConBom convert ( ReviewCon o ){
		if ( o == null ) return null;
		return new ReviewConBom ( o.getId(), o.getValue() );
	}

	
}
