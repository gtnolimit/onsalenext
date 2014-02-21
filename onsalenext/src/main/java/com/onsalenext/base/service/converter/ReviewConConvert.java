package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.item.ReviewCon;
import com.onsalenext.base.web.model.item.ReviewConBom;

public interface ReviewConConvert {

	public ReviewConBom convert ( ReviewCon o );
	public ReviewCon convert ( ReviewConBom o, String action );
	public Set<ReviewConBom> convert ( Set<ReviewCon> o );
	public Set<ReviewCon> convert ( Set<ReviewConBom> o, String action );

}
