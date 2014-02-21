package com.onsalenext.base.dao.impl;

import java.util.List;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.LookupTypeDao;
import com.onsalenext.base.domain.lookup.LookupType;

@Repository
@Transactional
public class LookupTypeDaoImpl implements LookupTypeDao {

	static final Logger logger = Logger.getLogger(LookupTypeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
	public <T extends LookupType> List<T> findReferenceTypes(Class<T> type) {
		return	sessionFactory.getCurrentSession ( ).createQuery("from " + type.getName()).list();
    }

}
