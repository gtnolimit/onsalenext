package com.onsalenext.base.service.converter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.Store;
import com.onsalenext.base.service.MenuService;
import com.onsalenext.base.service.converter.CategoryConvert;
import com.onsalenext.base.service.converter.IpConvert;
import com.onsalenext.base.service.converter.StoreConvert;
import com.onsalenext.base.web.model.StoreBom;

@Service
public class StoreConvertImpl implements StoreConvert {

	@Autowired
	private IpConvert ipConvert;
	@Autowired
	private MenuService menuService;
	@Autowired
	private CategoryConvert categoryConvert;
	
	public List <StoreBom> convert ( List <Store> o ){
		List <StoreBom> sl = new ArrayList <StoreBom> ();
		for ( Store s : o ){
			sl.add( this.convert ( s ) );
		}
		Collections.sort ( sl );
		return sl;
	}
	
	public Store convert ( StoreBom o, String action ) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD"))
			return new Store (o.getId (), o.getStoreName (), ipConvert.convert (o.getIp (), action), o.getCertificate (), 
				o.getSmtpUser (),o.getHomeState (), o.getSmtpPass (), o.getInfoEmail (), 
				o.getSmtpHost (), o.getSmtpPort (), o.isActive (), categoryConvert.convert ( o.getCategories (), action),
				new Date (), new Date (), "admin") ;
		return new Store (o.getId (), o.getStoreName (), ipConvert.convert (o.getIp (), action), o.getCertificate (), 
				o.getSmtpUser (),o.getHomeState (), o.getSmtpPass (), o.getInfoEmail (), 
				o.getSmtpHost (), o.getSmtpPort (), o.isActive (), categoryConvert.convert ( o.getCategories (), action),
				new Date (), "admin") ;
	}

	public StoreBom convert (Store o) {
		return new StoreBom (o.getId (), o.getStoreName (), ipConvert.convert ( o.getIp () ), o.getCertificate (), 
				o.getSmtpUser (),o.getHomeState (), o.getSmtpPass (), o.getInfoEmail (), 
				o.getSmtpHost (), o.getSmtpPort (), o.isActive (), categoryConvert.convert ( o.getCategories ()));
	}

}
