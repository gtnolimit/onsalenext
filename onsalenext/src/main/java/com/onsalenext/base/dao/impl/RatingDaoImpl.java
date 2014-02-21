package com.onsalenext.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.RatingDao;
import com.onsalenext.base.domain.item.Rating;

@Transactional
@Repository
public class RatingDaoImpl implements RatingDao{

	@Autowired
	private BaseDao baseDao; 
	
	public Long add ( Rating o) {
		return baseDao.add ( o );
	}

	public void edit( Rating o) {
		baseDao.merge( o );
	}

	@SuppressWarnings("unchecked")
	public List<Rating> getAll() {
		return (List<Rating>) baseDao.findAll(Rating.class);
	}

	public Rating get(Long id) {
		return (Rating) baseDao.findById(Rating.class, id);
	}

}
