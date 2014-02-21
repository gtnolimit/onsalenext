package com.onsalenext.base.service.converter;

import java.util.List;
import java.util.Set;

import com.onsalenext.base.domain.item.Size;
import com.onsalenext.base.web.model.item.SizeBom;

public interface SizeConvert {

	public SizeBom convert ( Size o );
	public Size convert ( SizeBom o, String action );
	public Set<SizeBom> convert ( Set<Size> o );
	public Set<Size> convert ( Set<SizeBom> o, String action );
	public List<SizeBom> convert ( List<Size> o );
}
