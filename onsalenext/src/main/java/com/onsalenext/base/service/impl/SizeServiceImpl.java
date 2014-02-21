package com.onsalenext.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.SizeDao;
import com.onsalenext.base.service.SizeService;
import com.onsalenext.base.service.converter.SizeConvert;
import com.onsalenext.base.web.model.item.SizeBom;

@Service
public class SizeServiceImpl implements SizeService {

	@Autowired
	private SizeDao sizeDao;
	@Autowired
	private SizeConvert sizeConvert;
	
	public Long add ( SizeBom o ) {
		return sizeDao.add ( sizeConvert.convert ( o, "ADD" ) );
	}

	public void edit ( SizeBom size ) {
		sizeDao.edit ( sizeConvert.convert ( size, "EDIT" ) );
	}

	public void delete(SizeBom o) {
		this.edit ( o );
	}

	public void delete(Long id) {
		SizeBom o = this.get ( id );
		o.setActive ( false );
		this.edit ( o );
	}

	public List<SizeBom> getAll() {
		return sizeConvert.convert ( sizeDao.getAll() );
	}

	public SizeBom get(Long id) {
		return sizeConvert.convert ( sizeDao.get ( id ) );
	}

}
