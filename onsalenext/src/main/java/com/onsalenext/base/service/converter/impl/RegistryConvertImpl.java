package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.person.Registry;
import com.onsalenext.base.service.converter.RegistryConvert;
import com.onsalenext.base.service.converter.RegistryDetailConvert;
import com.onsalenext.base.web.model.person.RegistryBom;

@Service
public class RegistryConvertImpl implements RegistryConvert {

	@Autowired
	private RegistryDetailConvert registryDetail;
	
	public Set<Registry> convert ( Set<RegistryBom> o, String action){
		if ( o == null ) return null;
		Set <Registry> is = new HashSet <Registry> ();
		for ( RegistryBom i : o) is.add( this.convert ( i, action ) );
		return is;
	}
	
	public Set<RegistryBom> convert ( Set<Registry> o){
		if ( o == null ) return null;
		Set <RegistryBom> is = new TreeSet <RegistryBom> ();
		for ( Registry i : o) is.add( this.convert ( i ) );
		return is;
	}
	
	public Registry convert ( RegistryBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Registry (o.getId(),o.getNumber(), o.getName(), o.isActive(), 
					registryDetail.convert (o.getRegisteryDetails(), action), new Date (), new Date (), "admin");
		return new Registry (o.getId(),o.getNumber(), o.getName(), o.isActive(), 
				registryDetail.convert (o.getRegisteryDetails(), action), new Date (), "admin");
	}
	
	public RegistryBom convert ( Registry o ){
		if ( o == null ) return null;
		return new RegistryBom (o.getId(),o.getNumber(), o.getName(), o.isActive(), 
				registryDetail.convert(o.getRegisteryDetails()) );
	}
}
