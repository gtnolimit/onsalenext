package com.onsalenext.base.service.converter.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.Picture;
import com.onsalenext.base.service.converter.PictureConvert;
import com.onsalenext.base.web.model.PictureBom;

@Service
public class PictureConvertImpl implements PictureConvert {

	public Picture convert (PictureBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Picture ( o.getId(), o.getPictureLocation(), o.getPictureFileName(), o.getAlt(), 
				o.isActive(), o.isMain(), new Date (), new Date (), "admin");
		return new Picture ( o.getId(), o.getPictureLocation(), o.getPictureFileName(), o.getAlt(), 
				o.isActive(), o.isMain(), new Date (), "admin");
	}

	public PictureBom convert (Picture o) {
		if ( o == null ) return null;
		return new PictureBom ( o.getId(), o.getPictureLocation(), o.getPictureFileName(), o.getAlt(), 
				o.isActive(), o.isMain() );
	}

	public Set<Picture> convert (Set<PictureBom> o, String action) {
		if ( o == null ) return null;
		Set <Picture> ps = new HashSet <Picture> ();
		for ( PictureBom p : o) ps.add ( this.convert ( p, action ) );
		return ps;
	}

	public Set<PictureBom> convert (Set<Picture> o) {
		if ( o == null ) return null;
		Set <PictureBom> ps = new TreeSet <PictureBom> ();
		for ( Picture p : o) ps.add ( this.convert ( p ) );
		return ps;
	}
}
