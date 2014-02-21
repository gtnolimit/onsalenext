package com.onsalenext.base.service.converter;

import com.onsalenext.base.domain.person.UserInfo;
import com.onsalenext.base.web.model.person.UserInfoBom;

public interface UserInfoConvert {

	public UserInfo convert (UserInfoBom o, String action );	
	public UserInfoBom convert ( UserInfo o );
}
