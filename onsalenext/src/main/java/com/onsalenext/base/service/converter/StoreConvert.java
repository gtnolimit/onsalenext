package com.onsalenext.base.service.converter;

import java.util.List;

import com.onsalenext.base.domain.Store;
import com.onsalenext.base.web.model.StoreBom;

public interface StoreConvert {
	
	public StoreBom convert ( Store o );
	public Store convert ( StoreBom o, String action );
	public List <StoreBom> convert ( List<Store> o );

}
