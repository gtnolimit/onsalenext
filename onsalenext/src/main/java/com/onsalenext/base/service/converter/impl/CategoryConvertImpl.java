package com.onsalenext.base.service.converter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.menu.Category;
import com.onsalenext.base.service.converter.BrandConvert;
import com.onsalenext.base.service.converter.CategoryConvert;
import com.onsalenext.base.service.converter.SubCategoryConvert;
import com.onsalenext.base.web.model.menu.CategoryBom;

@Service
public class CategoryConvertImpl implements CategoryConvert {

	@Autowired
	private BrandConvert brandConvert;
	@Autowired
	private SubCategoryConvert subCategoryConvert;
	
	public List<CategoryBom> convert ( List <Category> o ){
		List<CategoryBom> ss = new ArrayList <CategoryBom> ();
		for ( Category s : o ) ss.add( this.convert ( s ));
		Collections.sort(ss);
		return ss;
	}
	
	public Category convert ( CategoryBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Category ( o.getId(), o.getAttribute(), o.isActive(), 
					subCategoryConvert.convert ( o.getSubCategories(), action), 
					brandConvert.convert ( o.getBrands(), action),
				new Date (), new Date (), "admin");
		return new Category ( o.getId(), o.getAttribute(), o.isActive(), 
				subCategoryConvert.convert ( o.getSubCategories(), action), 
				brandConvert.convert ( o.getBrands(), action),
				new Date (), "admin");
	}
	
	public CategoryBom convert ( Category o ){
		return new CategoryBom ( o.getId(), o.getAttribute(), o.isActive(), 
				subCategoryConvert.convert ( o.getSubCategories()),
				brandConvert.convert ( o.getBrands()));
	}
	
	
	public Set<CategoryBom> convert ( Set <Category> o ){
		Set<CategoryBom> ss = new TreeSet <CategoryBom> ();
		for ( Category s : o ) ss.add( this.convert ( s ));
		return ss;
	}
	
	public Set<Category> convert ( Set <CategoryBom> o, String action ){
		Set<Category> ss = new HashSet <Category> ();
		for ( CategoryBom s : o ) ss.add( this.convert ( s, action ));
		return ss;
	}
}
