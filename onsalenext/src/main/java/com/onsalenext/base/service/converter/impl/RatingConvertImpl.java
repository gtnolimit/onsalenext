package com.onsalenext.base.service.converter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Rating;
import com.onsalenext.base.service.converter.RatingConvert;
import com.onsalenext.base.web.model.item.RatingBom;

@Service
public class RatingConvertImpl implements RatingConvert {

	public Rating convert (RatingBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Rating ( o.getId (), o.getRating(), new Date (), new Date (), "admin" );
		return new Rating ( o.getId (), o.getRating(), new Date (), "admin" );
	}

	public RatingBom convert (Rating o) {
		if ( o == null ) return null;
		return new RatingBom ( o.getId (), o.getRating() );
	}

	public Set<Rating> convert (Set<RatingBom> o, String action) {
		if ( o == null ) return null;
		Set <Rating> ss = new HashSet <Rating> ();
		for ( RatingBom s : o ) ss.add( this.convert ( s, action ));
		return ss;
	}

	public Set<RatingBom> convert (Set<Rating> o) {
		if ( o == null ) return null;
		Set <RatingBom> ss = new TreeSet <RatingBom> ();
		for ( Rating s : o ) ss.add( this.convert ( s ));
		return ss;
	}
	
	public List<RatingBom> convert ( List<Rating> o ){
		List<RatingBom> objectBom = new ArrayList <RatingBom> ();
		for ( Rating r : o ){
			objectBom.add( this.convert(r) );
		}
		Collections.sort(objectBom);
		return objectBom;	

	}
}
