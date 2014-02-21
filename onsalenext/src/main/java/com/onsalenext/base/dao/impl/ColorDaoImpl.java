package com.onsalenext.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.ColorDao;
import com.onsalenext.base.domain.item.Color;

@Transactional
@Repository
public class ColorDaoImpl implements ColorDao {
	@Autowired
	private BaseDao baseDao; 
	
	public Long add(Color color) {
		return baseDao.add ( color );
	}

	public void edit(Color color) {
		baseDao.merge( color );
	}

	public void delete(Color color) {
		// TODO Auto-generated method stub
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	public List<Color> getAll() {
		return (List<Color>) baseDao.findAll(Color.class);
	}

	public Color get(Long id) {
		return (Color) baseDao.findById(Color.class, id);
	}
}
