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

import com.onsalenext.base.domain.item.Brand;
import com.onsalenext.base.service.converter.BrandConvert;
import com.onsalenext.base.service.converter.PictureConvert;
import com.onsalenext.base.web.model.item.BrandBom;

@Service
public class BrandConvertImpl implements BrandConvert {

	@Autowired
	private PictureConvert picture;
	
	public Brand convert(BrandBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase ( "ADD" ))
			return new Brand ( o.getId (), o.getAttribute (), o.isActive (), 
				picture.convert ( o.getPicture (), action ), new Date (), new Date (), "admin" );
		return new Brand ( o.getId (), o.getAttribute (), o.isActive (), 
				picture.convert ( o.getPicture (), action ), new Date (), "admin" );
	}

	public BrandBom convert(Brand o) {
		if ( o == null )	return null;
		return new BrandBom ( o.getId (), o.getAttribute (), o.isActive (), 
				picture.convert ( o.getPicture () ));
	}

	public Set<Brand> convert(Set<BrandBom> o, String action) {
		if ( o == null ) return null;
		Set <Brand> ss = new HashSet <Brand> ();
		for ( BrandBom s : o ) ss.add ( this.convert ( s, action ));
		return ss;
	}

	public Set<BrandBom> convert(Set<Brand> o) {
		if ( o == null ) return null;
		Set <BrandBom> ss = new TreeSet <BrandBom> ();
		for ( Brand s : o ) ss.add ( this.convert ( s ));
		return ss;
	}
	
	public List<BrandBom> convert ( List<Brand> o ) {
		if ( o == null ) return null;
		List <BrandBom> ss = new ArrayList <BrandBom> ();
		for ( Brand s : o ) ss.add( this.convert ( s ));
		Collections.sort ( ss );
		return ss;
	}

}
