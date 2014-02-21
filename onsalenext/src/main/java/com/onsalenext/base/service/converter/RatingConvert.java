package com.onsalenext.base.service.converter;

import java.util.List;
import java.util.Set;

import com.onsalenext.base.domain.item.Rating;
import com.onsalenext.base.web.model.item.RatingBom;

public interface RatingConvert {

	public RatingBom convert ( Rating o );
	public Rating convert ( RatingBom o, String action );
	public Set<RatingBom> convert ( Set<Rating> o );
	public Set<Rating> convert ( Set<RatingBom> o, String action );
	public List<RatingBom> convert ( List<Rating> o );
}
