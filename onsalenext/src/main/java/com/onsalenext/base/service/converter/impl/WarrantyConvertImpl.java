package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Warranty;
import com.onsalenext.base.service.converter.WarrantyConvert;
import com.onsalenext.base.web.model.item.WarrantyBom;

@Service
public class WarrantyConvertImpl implements WarrantyConvert {

	public Warranty convert (WarrantyBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Warranty ( o.getId (), o.getWarranty (), o.isActive (), new Date (), "admin" );
		return new Warranty ( o.getId (), o.getWarranty (), o.isActive (), new Date (), new Date (), "admin" );
	}

	public WarrantyBom convert (Warranty o) {
		if ( o == null ) return null;
		return new WarrantyBom ( o.getId (), o.getWarranty (), o.isActive () );
	}

	public Set<Warranty> convert (Set<WarrantyBom> o, String action) {
		if ( o == null ) return null;
		Set<Warranty> cr = new HashSet <Warranty> ();
		for ( WarrantyBom c : o ) cr.add ( this.convert(c, action));
		return cr;
	}

	public Set<WarrantyBom> convert (Set<Warranty> o) {
		if ( o == null ) return null;
		Set<WarrantyBom> cr = new TreeSet <WarrantyBom> ();
		for ( Warranty c : o ) cr.add ( this.convert(c));
		return cr;
	}
}
