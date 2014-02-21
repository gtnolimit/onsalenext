package com.onsalenext.base.service.converter;

import com.onsalenext.base.domain.item.Dimensions;
import com.onsalenext.base.web.model.item.DimensionsBom;

public interface DimensionsConvert {

	public DimensionsBom convert ( Dimensions o );
	public Dimensions convert ( DimensionsBom o, String action );
}
