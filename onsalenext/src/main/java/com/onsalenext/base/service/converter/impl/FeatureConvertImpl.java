package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Feature;
import com.onsalenext.base.service.converter.FeatureConvert;
import com.onsalenext.base.service.converter.FeatureDetailConvert;
import com.onsalenext.base.web.model.item.FeatureBom;

@Service
public class FeatureConvertImpl implements FeatureConvert {

	@Autowired
	private FeatureDetailConvert featureDetail;
	
	public Feature convert  ( FeatureBom o, String action ) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Feature ( o.getId (), o.getAttribute (), o.isActive(), 
					featureDetail.convert (o.getFeatureDetails (), action ), new Date (), new Date (), "admin" );
		return new Feature ( o.getId (), o.getAttribute (), o.isActive(), 
				featureDetail.convert (o.getFeatureDetails (), action ), new Date (), "admin" );
	}

	public FeatureBom convert(Feature o) {
		if ( o == null ) return null;
		return new FeatureBom ( o.getId (), o.getAttribute (), o.isActive(), 
				featureDetail.convert ( o.getFeatureDetails() ));
	}

	public Set<Feature> convert(Set<FeatureBom> o, String action ) {
		if ( o == null ) return null;
		Set <Feature> fs = new HashSet <Feature> ();
		for ( FeatureBom f : o ) fs.add ( this.convert ( f, action ) );
		return fs;
	}

	public Set<FeatureBom> convert (Set<Feature> o) {
		if ( o == null ) return null;
		Set <FeatureBom> fs = new TreeSet <FeatureBom> ();
		for ( Feature f : o ) fs.add ( this.convert ( f ) );
		return fs;
	}

}
