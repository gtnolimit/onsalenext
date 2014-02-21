package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.item.Specification;
import com.onsalenext.base.web.model.item.SpecificationBom;

public interface SpecificationConvert {

	public SpecificationBom convert ( Specification o );
	public Specification convert ( SpecificationBom o, String action );
	public Set<SpecificationBom> convert ( Set<Specification> o );
	public Set<Specification> convert ( Set<SpecificationBom> o, String action );

}
