package com.onsalenext.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.BrandDao;
import com.onsalenext.base.domain.item.Brand;

@Transactional
@Repository
public class BrandDaoImpl implements BrandDao{

	@Autowired
	private BaseDao baseDao; 
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Long add(Brand brand) {
		return baseDao.add ( brand );
	}

	public void edit(Brand brand) {
		baseDao.merge( brand );
	}

	public void delete(Brand brand) {
		// TODO Auto-generated method stub
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
	}

	@SuppressWarnings("unchecked")
	public List<Brand> getAll() {
		return (List<Brand>) baseDao.findAll(Brand.class);
	}

	public Brand get(Long id) {
		return (Brand) baseDao.findById(Brand.class, id);
	}
	
	public Brand findByName ( String name ){
		return (Brand) baseDao.findByProperty(Brand.class, "attribute", name);
	}

	@SuppressWarnings("unchecked")
	public List<Brand> getStoreBrand(long storeId) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (b)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.brands b" +
				" WHERE s.id = :storeId" +
			" ORDER BY b.attribute");
		q.setParameter("storeId", storeId);
		return (List<Brand>) q.list();
	}
}
