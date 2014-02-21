package com.onsalenext.base.service.rules;

import com.onsalenext.base.domain.person.Customer;

public interface LoginService {
	
	public Customer login ( String user, String password );
	public String resetPassword ( String user );

}
