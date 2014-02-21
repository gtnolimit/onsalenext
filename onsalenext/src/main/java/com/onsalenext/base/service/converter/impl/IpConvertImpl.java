package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.Ip;
import com.onsalenext.base.service.converter.IpConvert;
import com.onsalenext.base.web.model.IpBom;

@Service
public class IpConvertImpl implements IpConvert {

	public Ip convert ( IpBom o, String action ) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Ip ( o.getId(), o.getIp(), o.getSession(), new Date (), new Date (), "admin");
		return new Ip ( o.getId(), o.getIp(), o.getSession(), new Date (), "admin");
	}

	public IpBom convert (Ip o) {
		return new IpBom ( o.getId(), o.getIp(), o.getSession() );
	}

	public Set<Ip> convert ( Set<IpBom> o, String action ) {
		Set <Ip > ips = new HashSet <Ip> ();
		for ( IpBom ip : o) ips.add ( this.convert ( ip, action ) );
		return ips;
	}

	public Set<IpBom> convert (Set<Ip> o) {
		Set <IpBom > ips = new TreeSet <IpBom> ();
		for ( Ip ip : o) ips.add ( this.convert ( ip ) );
		return ips;
	}

}
