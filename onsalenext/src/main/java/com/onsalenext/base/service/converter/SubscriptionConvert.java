package com.onsalenext.base.service.converter;

import com.onsalenext.base.domain.person.Subscription;
import com.onsalenext.base.web.model.person.SubscriptionBom;

public interface SubscriptionConvert {

	public Subscription convert (SubscriptionBom o, String action );	
	public SubscriptionBom convert ( Subscription o );
}
