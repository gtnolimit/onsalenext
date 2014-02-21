package com.onsalenext.base.service.converter.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.onsalenext.base.domain.item.Tag;
import com.onsalenext.base.service.converter.TagConvert;
import com.onsalenext.base.web.model.item.TagBom;

@Service
public class TagConvertImpl implements TagConvert {

	public Tag convert  ( TagBom o, String action ) {
		if ( o == null ) return null;
		if ( action.equalsIgnoreCase( "ADD" ))
			return new Tag ( o.getId(), o.getTag(), o.getCategory(), o.isActive(), new Date (), new Date (), "admin" );
		return new Tag ( o.getId(), o.getTag(), o.getCategory(), o.isActive(), new Date (), "admin" );
	}

	public TagBom convert (Tag o) {
		if ( o == null ) return null;
		return new TagBom ( o.getId(), o.getTag(), o.getCategory(), o.isActive() );
	}

	public Set<Tag> convert (Set<TagBom> o, String action) {
		if ( o == null ) return null;
		Set <Tag> ss = new HashSet <Tag> ();
		for ( TagBom s : o ) ss.add( this.convert ( s, action ));
		return ss;
	}

	public Set<TagBom> convert (Set<Tag> o) {
		if ( o == null ) return null;
		Set <TagBom> ss = new TreeSet <TagBom> ();
		for ( Tag s : o ) ss.add( this.convert ( s ));
		return ss;
	}

	public List<TagBom> convert (List<Tag> o) {
		if ( o == null ) return null;
		List<TagBom> tb = new ArrayList <TagBom> ();
		for ( Tag tag : o ) tb.add( this.convert (tag) );
		Collections.sort(tb);
		return tb;
	}
}
