package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.item.Feature;
import com.onsalenext.base.web.model.item.FeatureBom;

public interface FeatureConvert {

	public FeatureBom convert ( Feature o );
	public Feature convert ( FeatureBom o, String action );
	public Set<FeatureBom> convert ( Set<Feature> o );
	public Set<Feature> convert ( Set<FeatureBom> o, String action );

}
