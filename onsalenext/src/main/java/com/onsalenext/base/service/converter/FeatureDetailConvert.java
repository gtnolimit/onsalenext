package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.item.FeatureDetail;
import com.onsalenext.base.web.model.item.FeatureDetailBom;

public interface FeatureDetailConvert {

	public FeatureDetailBom convert ( FeatureDetail o );
	public FeatureDetail convert ( FeatureDetailBom o, String action );
	public Set<FeatureDetailBom> convert ( Set<FeatureDetail> o );
	public Set<FeatureDetail> convert ( Set<FeatureDetailBom> o, String action );

}
