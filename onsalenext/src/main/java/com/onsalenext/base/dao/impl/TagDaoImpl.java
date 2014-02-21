package com.onsalenext.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.TagDao;
import com.onsalenext.base.domain.item.Tag;

@Transactional
@Repository
public class TagDaoImpl implements TagDao {

	@Autowired
	private BaseDao baseDao; 
	
	public Long add(Tag tag) {
		return baseDao.add ( tag );
	}

	public void edit(Tag tag) {
		baseDao.merge( tag );
	}

	@SuppressWarnings("unchecked")
	public List<Tag> getAll() {
		return (List<Tag>) baseDao.findAll(Tag.class);
	}

	public Tag get(Long id) {
		return (Tag) baseDao.findById(Tag.class, id);
	}
}
