package com.onsalenext.base.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.TaxDao;
import com.onsalenext.base.domain.Tax;

@Transactional
@Repository
public class TaxDaoImpl implements TaxDao {

	@Autowired
	private BaseDao baseDao; 
	
	public Long add(Tax tag) {
		return baseDao.add ( tag );
	}

	public void edit(Tax tag) {
		baseDao.merge( tag );
	}

	@SuppressWarnings("unchecked")
	public List<Tax> getAll() {
		return (List<Tax>) baseDao.findAll(Tax.class);
	}

	public Tax get(Long id) {
		return (Tax) baseDao.findById(Tax.class, id);
	}
}
