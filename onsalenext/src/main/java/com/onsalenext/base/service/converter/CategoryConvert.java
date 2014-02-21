package com.onsalenext.base.service.converter;

import java.util.List;
import java.util.Set;

import com.onsalenext.base.domain.menu.Category;
import com.onsalenext.base.web.model.menu.CategoryBom;

public interface CategoryConvert {
	
	public CategoryBom convert ( Category o );
	public Category convert ( CategoryBom o, String action );
	public Set<CategoryBom> convert ( Set<Category> o );
	public Set<Category> convert ( Set<CategoryBom> o, String action );
	public List<CategoryBom> convert ( List <Category> o );
}
