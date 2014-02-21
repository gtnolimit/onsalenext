package com.onsalenext.base.service.converter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Color;
import com.onsalenext.base.service.converter.ColorConvert;
import com.onsalenext.base.web.model.item.ColorBom;

@Service
public class ColorConvertImpl implements ColorConvert {

	public Color convert (ColorBom o, String action) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD"))
			return new Color ( o.getId(), o.getColorGroup(), o.getColor(), o.getHexCode(), 
					o.isActive(), new Date (), new Date (), "admin" );
		return new Color ( o.getId(), o.getColorGroup(), o.getColor(), o.getHexCode(), 
				o.isActive(), new Date (), "admin" );
	}

	public ColorBom convert (Color o) {
		if ( o == null ) return null;
		return new ColorBom ( o.getId(), o.getColorGroup(), o.getColor(), o.getHexCode(), o.isActive() );
	}

	public Set<Color> convert (Set<ColorBom> o, String action) {
		if ( o == null ) return null;
		Set <Color> cs = new HashSet <Color> ();
		for ( ColorBom c : o ) cs.add( this.convert ( c, action ));
		return cs;
	}

	public Set<ColorBom> convert (Set<Color> o) {
		if ( o == null ) return null;
		Set <ColorBom> cs = new TreeSet <ColorBom> ();
		for ( Color c : o ) cs.add( this.convert ( c ));
		return cs;
	}
	
	public List<ColorBom> convert ( List<Color> o ){
		List<ColorBom> cl = new ArrayList <ColorBom> ();
		for ( Color c : o ) cl.add ( this.convert ( c ) );
		Collections.sort ( cl );
		return cl;
	}

}
