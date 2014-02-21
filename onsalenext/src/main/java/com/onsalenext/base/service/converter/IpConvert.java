package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.Ip;
import com.onsalenext.base.web.model.IpBom;

public interface IpConvert {

	public Ip convert ( IpBom o, String action );
	public IpBom convert ( Ip o );
	public Set <Ip> convert ( Set <IpBom> o, String action );
	public Set <IpBom> convert ( Set <Ip> o );

}
