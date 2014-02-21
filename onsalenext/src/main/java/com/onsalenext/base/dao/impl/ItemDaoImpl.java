package com.onsalenext.base.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.ItemDao;
import com.onsalenext.base.domain.item.Item;

@Transactional
@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private BaseDao baseDao; 
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Long add(Item item) {
		return baseDao.add ( item );
	}

	public void edit(Item item) {
		baseDao.merge( item );
	}

	public void delete(Item item) {
		// TODO Auto-generated method stub

	}

	public void delete(Long id) {
		
	}

	@SuppressWarnings("unchecked")
	public List<Item> getAll() {
		return (List<Item>) baseDao.findAll(Item.class);
	}

	public Item get(Long id) {
		return (Item) baseDao.findById(Item.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItemsSale ( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.saleDateStart <= NOW()" +
				" AND i.saleDateEnd >= NOW()");
		q.setMaxResults ( 5 );
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItemsOver250( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.saleDateStart <= NOW()" +
				" AND i.saleDateEnd >= NOW()" +
				" AND i.salePrice > 250" +
			" ORDER BY i.subject");
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItems250_100( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.saleDateStart <= NOW()" +
				" AND i.saleDateEnd >= NOW()" +
				" AND i.salePrice <= 250" +
				" AND i.salePrice > 100" +
			" ORDER BY i.subject");
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItems100_50( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.saleDateStart <= NOW()" +
				" AND i.saleDateEnd >= NOW()" +
				" AND i.salePrice <= 100" +
				" AND i.salePrice > 50" +
			" ORDER BY i.subject");
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItems50_20( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.saleDateStart <= NOW()" +
				" AND i.saleDateEnd >= NOW()" +
				" AND i.salePrice <= 50" +
				" AND i.salePrice > 20" +
			" ORDER BY i.subject");
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItems20_10( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.saleDateStart <= NOW()" +
				" AND i.saleDateEnd >= NOW()" +
				" AND i.salePrice <= 20" +
				" AND i.salePrice > 10" +
			" ORDER BY i.subject");
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItems10_5( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.saleDateStart <= NOW()" +
				" AND i.saleDateEnd >= NOW()" +
				" AND i.salePrice <= 10" +
				" AND i.salePrice > 5" +
			" ORDER BY i.subject");
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItemsBelow5( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.saleDateStart <= NOW()" +
				" AND i.saleDateEnd >= NOW()" +
				" AND i.salePrice <= 5" +
			" ORDER BY i.subject");
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItemsFreeShipping( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.saleDateStart <= NOW()" +
				" AND i.saleDateEnd >= NOW()" +
				" AND i.salePrice <= 250" +
				" AND i.salePrice > 100" +
			" ORDER BY i.subject");
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItemsSaleEmail( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.emailSale = true" +
			" ORDER BY i.subject");
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

	@SuppressWarnings("unchecked")
	public List<Item> getItemsClerance( Long storeId ) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (i)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" JOIN c.subCategories sc" +
				" JOIN sc.products p" +
				" JOIN p.items i" +
				" WHERE s.id = :storeId" +
				" AND i.isActive = true" +
				" AND i.clearancePriceActive = true" +
			" ORDER BY i.subject");
		q.setParameter("storeId", storeId);
		return (List<Item>) q.list();
	}

}
