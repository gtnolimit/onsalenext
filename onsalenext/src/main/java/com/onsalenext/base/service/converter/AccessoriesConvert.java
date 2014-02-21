package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.item.Accessories;
import com.onsalenext.base.web.model.item.AccessoriesBom;

public interface AccessoriesConvert {

	public AccessoriesBom convert ( Accessories o );
	public Accessories convert ( AccessoriesBom o, String action );
	public Set<AccessoriesBom> convert ( Set<Accessories> o );
	public Set<Accessories> convert ( Set<AccessoriesBom> o, String action );
}
