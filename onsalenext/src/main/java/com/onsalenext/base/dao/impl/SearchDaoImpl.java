package com.onsalenext.base.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.SearchDao;

@Transactional
@Repository
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SessionFactory sessionFactory;
}
