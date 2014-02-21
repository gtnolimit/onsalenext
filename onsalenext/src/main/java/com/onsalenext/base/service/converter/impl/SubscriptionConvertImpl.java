package com.onsalenext.base.service.converter.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.person.Subscription;
import com.onsalenext.base.service.converter.SubscriptionConvert;
import com.onsalenext.base.web.model.person.SubscriptionBom;

@Service
public class SubscriptionConvertImpl implements SubscriptionConvert {

	public Subscription convert (SubscriptionBom o, String action ){
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Subscription (o.getId(), o.isPromotional(), o.isNewsLetter(), o.isCoupons(), 
				new Date (), new Date (), "admin");
		return new Subscription (o.getId(), o.isPromotional(), o.isNewsLetter(), o.isCoupons(), 
				new Date (), "admin");
	}
	
	public SubscriptionBom convert ( Subscription o ){
		if ( o == null ) return null;
		return new SubscriptionBom (o.getId(), o.isPromotional(), o.isNewsLetter(), o.isCoupons() );
	}
}
