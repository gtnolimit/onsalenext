package com.onsalenext.base.dao;

import com.onsalenext.base.domain.person.Customer;

public interface LoginDao {

	public Customer login ( String user, String password );
	public Customer login ( String user );
	public Customer resetPassword ( String user );

}
