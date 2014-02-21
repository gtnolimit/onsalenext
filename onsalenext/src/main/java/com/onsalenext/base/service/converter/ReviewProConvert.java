package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.item.ReviewPro;
import com.onsalenext.base.web.model.item.ReviewProBom;

public interface ReviewProConvert {

	public ReviewProBom convert ( ReviewPro o );
	public ReviewPro convert ( ReviewProBom o, String action );
	public Set<ReviewProBom> convert ( Set<ReviewPro> o );
	public Set<ReviewPro> convert ( Set<ReviewProBom> o, String action );

}
