package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.item.CustomerReview;
import com.onsalenext.base.web.model.item.CustomerReviewBom;

public interface CustomerReviewConvert {

	public CustomerReviewBom convert ( CustomerReview o );
	public CustomerReview convert ( CustomerReviewBom o, String action );
	public Set<CustomerReviewBom> convert ( Set<CustomerReview> o );
	public Set<CustomerReview> convert ( Set<CustomerReviewBom> o, String action );

}
