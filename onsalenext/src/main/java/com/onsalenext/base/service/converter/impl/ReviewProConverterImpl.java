package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.ReviewPro;
import com.onsalenext.base.service.converter.ReviewProConvert;
import com.onsalenext.base.web.model.item.ReviewProBom;

@Service
public class ReviewProConverterImpl implements ReviewProConvert {

	public Set <ReviewPro> convert ( Set <ReviewProBom> o, String action ){
		if ( o == null ) return null;
		Set <ReviewPro> rs = new HashSet <ReviewPro> ();
		for ( ReviewProBom r : o ) rs.add ( this.convert ( r, action ) );
		return rs;
	}
	
	public Set <ReviewProBom> convert ( Set <ReviewPro> o ){
		if ( o == null ) return null;
		Set <ReviewProBom> rs = new TreeSet <ReviewProBom> ();
		for ( ReviewPro r : o ) rs.add ( this.convert ( r ) );
		return rs;
	}
 
	public ReviewPro convert ( ReviewProBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new ReviewPro ( o.getId(), o.getValue(), new Date (), new Date (), "admin" );
		return new ReviewPro ( o.getId(), o.getValue(), new Date (), "admin" );
	}
	
	public ReviewProBom convert ( ReviewPro o ){
		if ( o == null ) return null;
		return new ReviewProBom ( o.getId(), o.getValue() );
	}
	
}
