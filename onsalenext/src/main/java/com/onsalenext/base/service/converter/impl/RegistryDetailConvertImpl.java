package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.person.RegistryDetail;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.service.converter.RegistryDetailConvert;
import com.onsalenext.base.web.model.person.RegistryDetailBom;

@Service
public class RegistryDetailConvertImpl implements RegistryDetailConvert {

	@Autowired
	private ItemConvert itemConvert;

	public Set<RegistryDetail> convert ( Set<RegistryDetailBom> o, String action){
		if ( o == null ) return null;
		Set <RegistryDetail> is = new HashSet <RegistryDetail> ();
		for ( RegistryDetailBom i : o ) is.add( this.convert ( i, action ) );
		return is;
	}
	
	public Set<RegistryDetailBom> convert ( Set<RegistryDetail> o){
		if ( o == null ) return null;
		Set <RegistryDetailBom> is = new TreeSet <RegistryDetailBom> ();
		for ( RegistryDetail i : o) is.add( this.convert ( i ) );
		return is;
	}

	public RegistryDetail convert ( RegistryDetailBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new RegistryDetail (o.getId(), itemConvert.convert (o.getItem(), action), 
					new Date (), new Date (), "admin");
		return new RegistryDetail (o.getId(), itemConvert.convert (o.getItem(), action), 
				new Date (), "admin");
	}
	
	public RegistryDetailBom convert ( RegistryDetail o ){
		if ( o == null ) return null;
		return new RegistryDetailBom (o.getId(), itemConvert.convert (o.getItem(), "SHORT") );
	}
}
