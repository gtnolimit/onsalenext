package com.onsalenext.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.SizeDao;
import com.onsalenext.base.domain.item.Size;

@Transactional
@Repository
public class SizeDaoImpl implements SizeDao{

	@Autowired
	private BaseDao baseDao; 
	
	public Long add(Size size) {
		return baseDao.add ( size );
	}

	public void edit(Size size) {
		baseDao.merge( size );
	}

	@SuppressWarnings("unchecked")
	public List<Size> getAll() {
		return (List<Size>) baseDao.findAll(Size.class);
	}

	public Size get(Long id) {
		return (Size) baseDao.findById(Size.class, id);
	}

}
