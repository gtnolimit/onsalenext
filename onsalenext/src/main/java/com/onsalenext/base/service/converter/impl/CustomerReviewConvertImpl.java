package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.CustomerReview;
import com.onsalenext.base.service.converter.CustomerConvert;
import com.onsalenext.base.service.converter.CustomerReviewConvert;
import com.onsalenext.base.web.model.item.CustomerReviewBom;

@Service
public class CustomerReviewConvertImpl implements CustomerReviewConvert {

	@Autowired
	private CustomerConvert customerConvert;
	
	public CustomerReview convert(CustomerReviewBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new CustomerReview ( o.getId (), o.getReview (), 
					customerConvert.convert ( o.getCustomer (), action ), new Date (), new Date (), "admin");
		return new CustomerReview ( o.getId (), o.getReview (), 
				customerConvert.convert ( o.getCustomer (), action ), new Date (), "admin");
	}

	public CustomerReviewBom convert(CustomerReview o) {
		if ( o == null ) return null;
		return new CustomerReviewBom ( o.getId (), o.getReview (), 
				customerConvert.convert ( o.getCustomer (), "ITEM" ) );
	}

	public Set<CustomerReview> convert(Set<CustomerReviewBom> o, String action) {
		if ( o == null ) return null;
		Set<CustomerReview> cr = new HashSet <CustomerReview> ();
		for ( CustomerReviewBom c : o ) cr.add ( this.convert(c, action));
		return cr;
	}

	public Set<CustomerReviewBom> convert(Set<CustomerReview> o) {
		if ( o == null ) return null;
		Set<CustomerReviewBom> cr = new TreeSet <CustomerReviewBom> ();
		for ( CustomerReview c : o ) cr.add ( this.convert(c));
		return cr;
	}
}
