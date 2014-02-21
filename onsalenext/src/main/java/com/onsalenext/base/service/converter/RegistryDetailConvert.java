package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.person.RegistryDetail;
import com.onsalenext.base.web.model.person.RegistryDetailBom;

public interface RegistryDetailConvert {

	public Set<RegistryDetail> convert ( Set<RegistryDetailBom> o, String action);	
	public Set<RegistryDetailBom> convert ( Set<RegistryDetail> o);
	public RegistryDetail convert ( RegistryDetailBom o, String action );	
	public RegistryDetailBom convert ( RegistryDetail o );
}
