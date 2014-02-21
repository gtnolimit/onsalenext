package com.onsalenext.base.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.LoginDao;
import com.onsalenext.base.domain.person.Customer;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

	protected static Logger logger = Logger.getLogger ( "LoginDao" );

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private BaseDao baseDao;
	
	public Customer login ( String user, String password ) {
		logger.debug ( "Getting Login for " + user );
		return (Customer) sessionFactory.getCurrentSession()
		        .createQuery("FROM Customer c, UserInfo u WHERE " 
		        		+ "c.id = u.id"
		        		+ " and u.email = :user" 
		        		+ " and u.password = :password")
		        .setParameter("user", user).setParameter("password", password).uniqueResult();
	}

	public Customer login ( String user ) {
		logger.debug ( "Getting Login for " + user );
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "select c FROM Customer c, UserInfo u WHERE c.id = u.id and u.email = :email")
				.setParameter("email", user);
		return (Customer) query.uniqueResult();
	}

	public Customer resetPassword ( String user ) {
		logger.debug ( "Getting Login for " + user );
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "select c FROM Customer c, UserInfo u WHERE c.id = u.id and u.email = :email")
				.setParameter("email", user);
		return (Customer) query.uniqueResult();
		
	}

}
