package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.Tax;
import com.onsalenext.base.web.model.TaxBom;

public interface TaxConvert {

	public Tax convert (TaxBom o, String action);
	public TaxBom convert (Tax o);
	public Set<Tax> convert (Set<TaxBom> o, String action);
	public Set<TaxBom> convert (Set<Tax> o);
}
