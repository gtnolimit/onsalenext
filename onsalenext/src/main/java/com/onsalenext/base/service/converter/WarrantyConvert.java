package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.item.Warranty;
import com.onsalenext.base.web.model.item.WarrantyBom;

public interface WarrantyConvert {

	public WarrantyBom convert ( Warranty o );
	public Warranty convert ( WarrantyBom o, String action );
	public Set<WarrantyBom> convert ( Set<Warranty> o );
	public Set<Warranty> convert ( Set<WarrantyBom> o, String action );

}
