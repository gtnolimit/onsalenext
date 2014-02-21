package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Review;
import com.onsalenext.base.service.converter.ReviewConConvert;
import com.onsalenext.base.service.converter.ReviewConvert;
import com.onsalenext.base.service.converter.ReviewProConvert;
import com.onsalenext.base.web.model.item.ReviewBom;

@Service
public class ReviewConvertImpl implements ReviewConvert {

	@Autowired
	private ReviewConConvert conConverter;
	@Autowired
	private ReviewProConvert proConverter;
	
	public Review convert (ReviewBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Review ( o.getId(), o.getDescription(), 
					conConverter.convert (o.getReviewCons(), action), proConverter.convert (o.getReviewPros(), action),
				new Date (), new Date (), "admin");
		return new Review ( o.getId(), o.getDescription(), 
				conConverter.convert (o.getReviewCons(), action), proConverter.convert (o.getReviewPros(), action),
				new Date (), "admin");
	}

	public ReviewBom convert (Review o) {
		if ( o == null ) return null;
		return new ReviewBom ( o.getId(), o.getDescription(), 
				conConverter.convert (o.getReviewCons()), proConverter.convert (o.getReviewPros()) );
	}

	public Set<Review> convert (Set<ReviewBom> o, String action) {
		if ( o == null ) return null;
		Set <Review> rs = new HashSet <Review> ();
		for ( ReviewBom r : o ) rs.add( this.convert( r, action ));
		return null;
	}

	public Set<ReviewBom> convert (Set<Review> o) {
		if ( o == null ) return null;
		Set <ReviewBom> rs = new TreeSet <ReviewBom> ();
		for ( Review r : o ) rs.add( this.convert ( r ));
		return null;
	}

}
