package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.person.Registry;
import com.onsalenext.base.web.model.person.RegistryBom;

public interface RegistryConvert {

	public Set<Registry> convert ( Set<RegistryBom> o, String action);	
	public Set<RegistryBom> convert ( Set<Registry> o);	
	public Registry convert ( RegistryBom o, String action );	
	public RegistryBom convert ( Registry o );
}
