package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.person.Address;
import com.onsalenext.base.web.model.person.AddressBom;

public interface AddressConvert {

	public Set<Address> convert ( Set<AddressBom> o, String action);
	public Set<AddressBom> convert ( Set<Address> o);
	public Address convert	( AddressBom o, String action );
	public AddressBom convert ( Address o );

}
