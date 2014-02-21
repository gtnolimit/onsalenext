package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.item.SpecificationDetail;
import com.onsalenext.base.web.model.item.SpecificationDetailBom;

public interface SpecificationDetailConvert {

	public SpecificationDetailBom convert ( SpecificationDetail o );
	public SpecificationDetail convert ( SpecificationDetailBom o, String action );
	public Set<SpecificationDetailBom> convert ( Set<SpecificationDetail> o );
	public Set<SpecificationDetail> convert ( Set<SpecificationDetailBom> o, String action );

}
