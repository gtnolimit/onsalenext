package com.onsalenext.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.ColorDao;
import com.onsalenext.base.service.ColorService;
import com.onsalenext.base.service.converter.ColorConvert;
import com.onsalenext.base.web.model.item.ColorBom;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired
	private ColorDao colorDao;
	@Autowired
	private ColorConvert colorConvert;
	
	public Long add(ColorBom color) {
		return colorDao.add(colorConvert.convert (color, "ADD"));
	}

	public void edit(ColorBom color) {
		colorDao.edit(colorConvert.convert (color, "EDIT"));
	}

	public void delete(ColorBom color) {
		colorDao.delete(colorConvert.convert (color, "EDIT"));
	}

	public void delete(Long id) {
		colorDao.delete(id);
	}

	public List<ColorBom> getAll() {
		return colorConvert.convert (colorDao.getAll());
	}

	public ColorBom get(Long id) {
		return colorConvert.convert(colorDao.get(id));
	}

}
