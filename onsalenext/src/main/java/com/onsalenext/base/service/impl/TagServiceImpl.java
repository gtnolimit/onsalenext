package com.onsalenext.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.TagDao;
import com.onsalenext.base.service.TagService;
import com.onsalenext.base.service.converter.TagConvert;
import com.onsalenext.base.web.model.item.TagBom;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;
	@Autowired
	private TagConvert tagConvert;
	
	public Long add ( TagBom o ) {
		return tagDao.add ( tagConvert.convert ( o, "ADD" ) );
	}

	public void edit ( TagBom o ) {
		tagDao.edit ( tagConvert.convert ( o, "EDIT" ) );
	}

	public void delete ( TagBom o ) {
		this.edit ( o );
	}

	public void delete ( Long id ) {
		TagBom o = this.get ( id );
		o.setActive ( false );
		this.edit ( o );
	}

	public List<TagBom> getAll() {
		return tagConvert.convert ( tagDao.getAll() );

	}

	public TagBom get ( Long id ) {
		return tagConvert.convert ( tagDao.get ( id ) );
	}
}
