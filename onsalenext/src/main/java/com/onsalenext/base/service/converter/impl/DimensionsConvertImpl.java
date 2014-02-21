package com.onsalenext.base.service.converter.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Dimensions;
import com.onsalenext.base.service.converter.DimensionsConvert;
import com.onsalenext.base.web.model.item.DimensionsBom;

@Service
public class DimensionsConvertImpl implements DimensionsConvert {

	public Dimensions convert ( DimensionsBom o, String action ) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Dimensions ( o.getId(), o.getHeight(), o.getWidth(), o.getDepth(), o.getWeight(), 
				o.getShippingHeight(), o.getShippingWidth(), o.getShippingDepth(), 
				o.getShippingWeight(), o.getWeightType(), o.getLengthType(), new Date (), 
				new Date (), "admin" );
		return new Dimensions ( o.getId(), o.getHeight(), o.getWidth(), o.getDepth(), o.getWeight(), 
				o.getShippingHeight(), o.getShippingWidth(), o.getShippingDepth(), 
				o.getShippingWeight(), o.getWeightType(), o.getLengthType(), new Date (), "admin" );
	}

	public DimensionsBom convert(Dimensions o) {
		if ( o == null ) return null;
		return new DimensionsBom ( o.getId(), o.getHeight(), o.getWidth(), o.getDepth(), o.getWeight(), 
				o.getShippingHeight(), o.getShippingWidth(), o.getShippingDepth(), 
				o.getShippingWeight(), o.getWeightType(), o.getLengthType() );
	}

}
