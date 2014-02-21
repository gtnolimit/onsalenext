package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.menu.SubCategory;
import com.onsalenext.base.web.model.menu.SubCategoryBom;

public interface SubCategoryConvert {

	public SubCategoryBom convert ( SubCategory o );
	public SubCategory convert ( SubCategoryBom o, String action );
	public Set<SubCategoryBom> convert ( Set<SubCategory> o );
	public Set<SubCategory> convert ( Set<SubCategoryBom> o, String action );

}
