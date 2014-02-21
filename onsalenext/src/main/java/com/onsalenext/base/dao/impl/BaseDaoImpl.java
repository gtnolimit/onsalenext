package com.onsalenext.base.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onsalenext.base.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Long add ( Object o ){
		return (Long) sessionFactory.getCurrentSession ( ).save ( o );
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findById(Class<T> entityClass, Object id) {
		return (T) sessionFactory.getCurrentSession ( ).get(entityClass, (Serializable) id);
	}

    public List<?> findAll(Class<?> entityClass) {
        return sessionFactory.getCurrentSession ( ).createQuery("from " + entityClass.getName()).list();
    }
    
    public List<?> findByProperty(Class<?> entity, String prop, Object val) {
    	return sessionFactory.getCurrentSession ( ).createQuery(
    		"from " + entity.getName() + " where " + prop + " = :prop ")
    		.setParameter("prop", val)
    		.list();
	}

   public Object merge(Object o) {
		return sessionFactory.getCurrentSession ( ).merge(o);
	}

	public void persist(Object o) {
		sessionFactory.getCurrentSession ( ).persist(o);
	}

	public void refresh(Object o) {
		sessionFactory.getCurrentSession ( ).refresh(o);
	}

	public void flush(){
		sessionFactory.getCurrentSession ( ).flush();
	}

    public void remove(Object o) {
    	sessionFactory.getCurrentSession ( ).delete(o);
    }
}
