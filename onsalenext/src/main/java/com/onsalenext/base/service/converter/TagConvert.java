package com.onsalenext.base.service.converter;

import java.util.List;
import java.util.Set;

import com.onsalenext.base.domain.item.Tag;
import com.onsalenext.base.web.model.item.TagBom;

public interface TagConvert {
	
	public TagBom convert ( Tag o );
	public Tag convert ( TagBom o, String action );
	public Set<TagBom> convert ( Set<Tag> o );
	public Set<Tag> convert ( Set<TagBom> o, String action );
	public List<TagBom> convert ( List<Tag> o );
}
