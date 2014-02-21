package com.onsalenext.base.service.converter;

import java.util.Set;

import com.onsalenext.base.domain.Picture;
import com.onsalenext.base.web.model.PictureBom;

public interface PictureConvert {

	public Picture convert ( PictureBom o, String action );
	public PictureBom convert ( Picture o );
	public Set <Picture> convert ( Set <PictureBom> o, String action );
	public Set <PictureBom> convert ( Set <Picture> o );

}
