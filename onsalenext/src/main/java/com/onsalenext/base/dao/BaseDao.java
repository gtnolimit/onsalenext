package com.onsalenext.base.dao;

import java.util.List;

/**
 * @author sgrigorovichs
 */
public interface BaseDao {
	
	public Long add (  Object o );
	
	public <T> T findById(Class<T> entityClass, Object primaryKey);
	
    public List<?> findAll(Class<?> entityClass);
    
    public List<?> findByProperty(Class<?> entity, String prop, Object val);

    public Object merge(Object o);
	
	public void persist(Object o) throws Exception;
	
	public void refresh(Object o);
	
    public void remove(Object o);

    public void flush();

}