package com.onsalenext.base.service.converter;

import java.util.List;

import com.onsalenext.base.domain.person.Customer;
import com.onsalenext.base.web.model.person.CustomerBom;

public interface CustomerConvert {

	public List<CustomerBom> convert ( List <Customer> o );
	public Customer convert ( CustomerBom o, String action );	
	public CustomerBom convert ( Customer o, String action );

}
