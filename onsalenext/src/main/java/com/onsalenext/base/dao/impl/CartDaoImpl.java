package com.onsalenext.base.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.CartDao;
import com.onsalenext.base.domain.order.Cart;

@Transactional
@Repository
public class CartDaoImpl implements CartDao {

	protected static Logger logger = Logger.getLogger ( "CartDao" );

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private BaseDao baseDao;
	
	public Long add(Cart cart) {
		return (Long) sessionFactory.getCurrentSession().save( cart );
	}

	public void edit(Cart cart) {
		sessionFactory.getCurrentSession().merge(cart);	
	}

	public void delete(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
	}

	public void delete(Long id) {
		 Cart cart = (Cart) get ( id );
		 this.delete(cart);
	}

	@SuppressWarnings("unchecked")
	public List <Cart> getAll() {
		return (List<Cart>) baseDao.findAll(Cart.class);
	}

	public Cart get (Long id) {
		logger.debug ( "Getting Cart" + id );
		return (Cart) sessionFactory.getCurrentSession()
		        .createQuery("FROM Cart c WHERE c.id = :id")
		        .setParameter("id", id).uniqueResult();
	}
	public Cart findByCustomerId ( Long customerId ) {
		return (Cart) sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Cart c WHERE c.customer = :customerId")
				.setLong ( "customerId", customerId ).uniqueResult();
	}
	public Cart findBySession ( String session ) {
		return (Cart) sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Cart c WHERE c.sessionNumber = :session")
				.setString ( "session", session ).uniqueResult();
	}
	public Cart findByIp ( String ip ) {
		return (Cart) sessionFactory.getCurrentSession ( ).
				createQuery ( "FROM Cart c WHERE c.ip = :ip")
				.setString ( "ip", ip ).uniqueResult();
	}
}
