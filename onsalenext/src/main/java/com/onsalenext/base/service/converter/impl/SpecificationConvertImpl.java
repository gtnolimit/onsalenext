package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Specification;
import com.onsalenext.base.service.converter.SpecificationConvert;
import com.onsalenext.base.service.converter.SpecificationDetailConvert;
import com.onsalenext.base.web.model.item.SpecificationBom;

@Service
public class SpecificationConvertImpl implements SpecificationConvert {

	@Autowired
	private SpecificationDetailConvert specificationDetailConvert;
	
	public Specification convert(SpecificationBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Specification ( o.getId (), o.getAttribute (),  
					specificationDetailConvert.convert (o.getSpecificationDetails(), action), new Date (), new Date (), "admin" );
		return new Specification ( o.getId (), o.getAttribute (),  
				specificationDetailConvert.convert (o.getSpecificationDetails(), action), new Date (), "admin" );
	}

	public SpecificationBom convert (Specification o) {
		if ( o == null ) return null;
		return new SpecificationBom ( o.getId (), o.getAttribute (),  
				specificationDetailConvert.convert (o.getSpecificationDetails()) );
	}

	public Set<Specification> convert (Set<SpecificationBom> o, String action) {
		if ( o == null ) return null;
		Set<Specification> ss = new HashSet <Specification> ();
		for ( SpecificationBom s : o ) 	ss.add ( this.convert( s, action ) );
		return ss;
	}

	public Set<SpecificationBom> convert (Set<Specification> o) {
		if ( o == null ) return null;
		Set<SpecificationBom> ss = new TreeSet <SpecificationBom> ();
		for ( Specification s : o ) ss.add ( this.convert( s ) );
		return ss;
	}
}
