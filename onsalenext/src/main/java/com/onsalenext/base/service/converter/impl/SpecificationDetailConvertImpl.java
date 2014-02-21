package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.SpecificationDetail;
import com.onsalenext.base.service.converter.SpecificationDetailConvert;
import com.onsalenext.base.web.model.item.SpecificationDetailBom;

@Service
public class SpecificationDetailConvertImpl implements SpecificationDetailConvert {

	public Set<SpecificationDetail> convert ( Set <SpecificationDetailBom> o, String action  ){
		if ( o == null ) return null;
		Set<SpecificationDetail> ss = new HashSet <SpecificationDetail> ();
		for ( SpecificationDetailBom s : o ) ss.add ( this.convert ( s, action ) );
		return ss;
	}
	
	public Set<SpecificationDetailBom> convert ( Set <SpecificationDetail> o ){
		if ( o == null ) return null;
		Set<SpecificationDetailBom> ss = new TreeSet <SpecificationDetailBom> ();
		for ( SpecificationDetail s : o ) ss.add ( this.convert ( s ) );
		return ss;
	}
	
	public SpecificationDetail convert ( SpecificationDetailBom o, String action  ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new SpecificationDetail ( o.getId (), o.getValue (), new Date (), new Date (), "admin" );
		return new SpecificationDetail ( o.getId (), o.getValue (), new Date (), "admin" );
	}
	
	public SpecificationDetailBom convert ( SpecificationDetail o ){
		if ( o == null ) return null;
		return new SpecificationDetailBom ( o.getId (), o.getValue () );
	}
}
