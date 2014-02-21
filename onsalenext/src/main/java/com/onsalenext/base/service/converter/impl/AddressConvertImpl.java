package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.person.Address;
import com.onsalenext.base.service.converter.AddressConvert;
import com.onsalenext.base.web.model.person.AddressBom;

@Service
public class AddressConvertImpl implements AddressConvert {

	public Set<Address> convert ( Set<AddressBom> o, String action){
		if ( o == null ) return null;
		Set <Address> is = new HashSet <Address> ();
		for ( AddressBom i : o) is.add( this.convert ( i, action ) );
		return is;
	}
	
	public Set<AddressBom> convert ( Set<Address> o){
		if ( o == null ) return null;
		Set <AddressBom> is = new TreeSet <AddressBom> ();
		for ( Address i : o) is.add( this.convert ( i ) );
		return is;
	}

	public Address convert	( AddressBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Address (o.getId (), o.getAddressType (), o.getAddressLine1 (), o.getAddressLine2 (), o.getCity (), 
				o.getStateType (), o.getZip (), o.isActive (), new Date (), new Date (), "admin");
		return new Address (o.getId (), o.getAddressType (), o.getAddressLine1 (), o.getAddressLine2 (), o.getCity (), 
				o.getStateType (), o.getZip (), o.isActive (), new Date (), "admin");
	}
	
	public AddressBom convert ( Address o ){
		if ( o == null ) return null;
		return new AddressBom (o.getId (), o.getAddressType (), o.getAddressLine1 (), o.getAddressLine2 (), o.getCity (), 
				o.getStateType (), o.getZip (), o.isActive () );
	}

}
