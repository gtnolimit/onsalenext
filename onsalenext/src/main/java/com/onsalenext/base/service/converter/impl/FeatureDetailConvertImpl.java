package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.FeatureDetail;
import com.onsalenext.base.service.converter.FeatureDetailConvert;
import com.onsalenext.base.web.model.item.FeatureDetailBom;

@Service
public class FeatureDetailConvertImpl implements FeatureDetailConvert {

	public Set <FeatureDetail> convert ( Set <FeatureDetailBom> o, String action ){
		if ( o == null ) return null;
		Set <FeatureDetail> fs = new HashSet <FeatureDetail> ();
		for ( FeatureDetailBom f : o ) fs.add ( this.convert ( f, action ) );
		return fs;
	}
	
	public Set <FeatureDetailBom> convert ( Set <FeatureDetail> o ){
		if ( o == null ) return null;
		Set <FeatureDetailBom> fs = new TreeSet <FeatureDetailBom> ();
		for ( FeatureDetail f : o ) fs.add ( this.convert ( f ) );
		return fs;
	}
	
	public FeatureDetail convert( FeatureDetailBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new FeatureDetail ( o.getId (), o.getValue (), new Date (), new Date (), "admin" );
		return new FeatureDetail ( o.getId (), o.getValue (), new Date (), "admin" );
	}
	
	public FeatureDetailBom convert( FeatureDetail o ){
		if ( o == null ) return null;
		return new FeatureDetailBom ( o.getId (), o.getValue () );
	}
}
