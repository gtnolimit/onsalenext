package com.onsalenext.base.service.converter;

import java.util.List;
import java.util.Set;

import com.onsalenext.base.domain.item.Color;
import com.onsalenext.base.web.model.item.ColorBom;

public interface ColorConvert {

	public ColorBom convert ( Color o );
	public Color convert ( ColorBom o, String action );
	public Set<ColorBom> convert ( Set<Color> o );
	public Set<Color> convert ( Set<ColorBom> o, String action );
	public List<ColorBom> convert ( List<Color> o ); 
}
