package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.item.Review;
import com.onsalenext.base.web.model.item.ReviewBom;

public interface ReviewConvert {

	public ReviewBom convert ( Review o );
	public Review convert ( ReviewBom o, String action );
	public Set<ReviewBom> convert ( Set<Review> o );
	public Set<Review> convert ( Set<ReviewBom> o, String action );

}
