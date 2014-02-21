package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.menu.SubCategory;
import com.onsalenext.base.service.converter.ProductConvert;
import com.onsalenext.base.service.converter.SubCategoryConvert;
import com.onsalenext.base.web.model.menu.SubCategoryBom;

@Service
public class SubCategoryConvertImpl implements SubCategoryConvert {

	@Autowired
	private ProductConvert productConvert;
	
	public Set<SubCategoryBom> convert ( Set <SubCategory> o ){
		Set<SubCategoryBom> ss = new TreeSet <SubCategoryBom> ();
		for ( SubCategory s : o ){
			ss.add( this.convert ( s ));
		}
		return ss;
	}
	
	public Set<SubCategory> convert ( Set <SubCategoryBom> o, String action ){
		Set<SubCategory> ss = new HashSet <SubCategory> ();
		for ( SubCategoryBom s : o ){
			ss.add( this.convert ( s, action ));
		}
		return ss;
	}
	
	public SubCategory convert ( SubCategoryBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new SubCategory (o.getId(), o.getAttribute(), o.isActive(), 
					productConvert.convert (o.getProducts(), action),
				new Date (), new Date (), "admin");
		return new SubCategory (o.getId(), o.getAttribute(), o.isActive(), 
				productConvert.convert (o.getProducts(), action),
				new Date (), "admin");
	}
	
	public SubCategoryBom convert ( SubCategory o ){
		return new SubCategoryBom (o.getId(), o.getAttribute(), o.isActive(), 
				productConvert.convert ( o.getProducts()));
	}
}
