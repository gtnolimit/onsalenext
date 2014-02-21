package com.onsalenext.base.service.converter.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.person.UserInfo;
import com.onsalenext.base.service.converter.UserInfoConvert;
import com.onsalenext.base.web.model.person.UserInfoBom;

@Service
public class UserInfoConvertImpl implements UserInfoConvert {

	public UserInfo convert (UserInfoBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new UserInfo (o.getId(), o.getEmail(), o.getPassword(), new Date (), new Date (), "admin");
		return new UserInfo (o.getId(), o.getEmail(), o.getPassword(), new Date (), "admin");
	}
	
	public UserInfoBom convert ( UserInfo o ){
		if ( o == null ) return null;
		return new UserInfoBom ( o.getId(), o.getEmail(), o.getPassword() );
	}
}
