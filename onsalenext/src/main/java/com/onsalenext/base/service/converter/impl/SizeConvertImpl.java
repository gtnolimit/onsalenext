package com.onsalenext.base.service.converter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Size;
import com.onsalenext.base.service.converter.SizeConvert;
import com.onsalenext.base.web.model.item.SizeBom;

@Service
public class SizeConvertImpl implements SizeConvert {

	public Size convert (SizeBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Size ( o.getId (), o.getSize(), o.isActive(), new Date (), new Date (), "admin" );
		return new Size ( o.getId (), o.getSize(), o.isActive(), new Date (), "admin" );
	}

	public SizeBom convert (Size o) {
		if ( o == null ) return null;
		return new SizeBom ( o.getId (), o.getSize(), o.isActive() );
	}

	public Set<Size> convert (Set<SizeBom> o, String action) {
		if ( o == null ) return null;
		Set <Size> ss = new HashSet <Size> ();
		for ( SizeBom s : o ) ss.add( this.convert ( s, action ));
		return ss;
	}

	public Set<SizeBom> convert (Set<Size> o) {
		if ( o == null ) return null;
		Set <SizeBom> ss = new TreeSet <SizeBom> ();
		for ( Size s : o ) ss.add( this.convert ( s ));
		return ss;
	}
	
	public List<SizeBom> convert ( List<Size> o ) {
		List<SizeBom> objectBom = new ArrayList <SizeBom> ();
		for ( Size s : o ){
			objectBom.add( new SizeBom ( s.getId(), s.getSize(), s.isActive() ) );
		}
		Collections.sort(objectBom);
		return objectBom;	
	}
}
