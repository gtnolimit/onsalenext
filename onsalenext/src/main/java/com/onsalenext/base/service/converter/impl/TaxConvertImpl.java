package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.Tax;
import com.onsalenext.base.service.converter.TaxConvert;
import com.onsalenext.base.web.model.TaxBom;

@Service
public class TaxConvertImpl implements TaxConvert{

	public Tax convert (TaxBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD "))
			return new Tax ( o.getId (), o.getTax (), o.isActive (), o.getStateType (), 
				new Date (), new Date (), "admin" );
		return new Tax ( o.getId (), o.getTax (), o.isActive (), o.getStateType (), 
				new Date (), "admin" );
	}

	public TaxBom convert (Tax o) {
		if ( o == null ) return null;
		return new TaxBom ( o.getId (), o.getTax (), o.isActive (), o.getStateType () );
	}

	public Set<Tax> convert (Set<TaxBom> o, String action) {
		if ( o == null ) return null;
		Set <Tax > ts = new HashSet <Tax> ();
		for ( TaxBom t : o){
			ts.add ( this.convert  ( t, action ) );
		}
		return ts;
	}

	public Set<TaxBom> convert (Set<Tax> o) {
		if ( o == null ) return null;
		Set <TaxBom > ts = new TreeSet <TaxBom> ();
		for ( Tax t : o){
			ts.add ( this.convert  ( t ) );
		}
		return ts;
	}
}
