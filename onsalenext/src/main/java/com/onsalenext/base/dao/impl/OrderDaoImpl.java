package com.onsalenext.base.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.OrderDao;
import com.onsalenext.base.domain.order.Order;

@Transactional
@Repository
public class OrderDaoImpl implements OrderDao {

	protected static Logger logger = Logger.getLogger ( "OrderDao" );

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private BaseDao baseDao;
	
	public Long add(Order order) {
		logger.debug ( "Adding new Order" );
		order.setCpd( new Date () );
		order.setUpd( new Date () );
		return baseDao.add ( order );
	}

	public void edit(Order order) {
		logger.debug ( "Editting new Order" );
		order.setUpd( new Date () );
		baseDao.merge(order);	
	}

	public void delete (Order order) {
		logger.debug ( "Deleting Order" );
		order.setActive(false);
		edit(order);
	}

	public void delete (Long id) {
		logger.debug ( "Deleting Order" + id );
		//Order Order = bd.findById(Order, id);
		 Order order = (Order) get ( id );
		order.setActive( false );
		edit ( order );
	}

	@SuppressWarnings("unchecked")
	public List <Order> getAll () {
		logger.debug ( "Retrieving all Orders" );
		return (List <Order>) sessionFactory.getCurrentSession ( ).
				createQuery("FROM Order o");
	}

	public Order get (Long id) {
		logger.debug ( "Getting Order" + id );
		return (Order) sessionFactory.getCurrentSession()
		        .createQuery("FROM Order o WHERE o.id = :id")
		        .setParameter("id", id).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrdersForCustomer ( Long customerId ) {
		return sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Order o JOIN o.customer c WHERE c.customer_id = :customerId")
				.setLong ( "customerId", customerId ).list();
	}
	
	public Order getByInvoice ( String invoiceNumber ) {
		return (Order) sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Order o WHERE o.INVOICE_NUMBER = :invoiceNumber")
				.setString ( "invoiceNumber", invoiceNumber ).uniqueResult();
	}
	public Order getByIp ( String ip ) {
		return (Order) sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Order o JOIN o.ip p WHERE p.ip = :ip")
				.setString ( "ip", ip ).uniqueResult();
	}

}
