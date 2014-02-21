package com.onsalenext.base.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.CustomerDao;
import com.onsalenext.base.domain.person.Customer;
import com.onsalenext.base.domain.person.Registry;
import com.onsalenext.base.domain.person.WishList;

import com.onsalenext.base.dao.BaseDao;

@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao {

	protected static Logger logger = Logger.getLogger ( "CustomerDao" );

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private BaseDao baseDao;	
	
	public Long add(Customer customer) {
		return baseDao.add ( customer );
	}

	public void edit(Customer customer) {
		baseDao.merge( customer );
	}

	public void delete(Customer customer) {
		edit(customer);
	}

	public void delete(Long id) {
		 Customer customer = (Customer) get ( id );
		customer.setActive( false );
		edit ( customer );
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {
		logger.debug ( "Retrieving all Customers" );
		return  (List<Customer>) baseDao.findAll(Customer.class);
	}
/*
	@SuppressWarnings("unchecked")
	public List <Order> getCustomerOrders(Long id) {
		logger.debug ( "Getting Customer" + id );
		System.out.println("inside get costomer dao");
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "SELECT " +
						"c.orders " +
						"FROM Customer c " +
						"JOIN c.orders " +
						"WHERE c.id = :id")
				.setParameter("id", id);
		return (List<Order>) query.list();
	}
*/	
	public Customer get ( Long id ) {
		logger.debug ( "Getting Customer" + id );
		return (Customer) baseDao.findById(Customer.class, id);
	}
	
	public WishList getWishList(Long customerId) {
		logger.debug ( "Getting Customer" + customerId );
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "SELECT " +
						"c.wishList " +
						"FROM Customer c " +
						"JOIN c.wishList " +
						"WHERE c.id = :id")
				.setParameter("id", customerId);
		return (WishList) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Registry> getRegistry(Long customerId) {
		logger.debug ( "Getting Customer" + customerId );
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "SELECT " +
						"c.registries " +
						"FROM Customer c " +
						"JOIN c.registeries " +
						"WHERE c.id = :id")
				.setParameter("id", customerId);
		return (List<Registry>) query.list();	}
}
