package com.onsalenext.base.service.converter;

import java.util.List;
import java.util.Set;

import com.onsalenext.base.domain.item.Brand;
import com.onsalenext.base.web.model.item.BrandBom;

public interface BrandConvert {

	public Brand convert (BrandBom o, String action );
	public BrandBom convert ( Brand o );
	public Set <Brand> convert ( Set <BrandBom> o, String action );
	public Set <BrandBom> convert ( Set <Brand> o );
	public List<BrandBom> convert ( List<Brand> o );

}
