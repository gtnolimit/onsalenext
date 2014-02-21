package com.onsalenext.base.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.HomeDao;
import com.onsalenext.base.domain.Store;

@Repository
@Transactional
public class HomeDaoImpl implements HomeDao{

	protected static Logger logger = Logger.getLogger ( "HomeDao" );

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BaseDao baseDao;
	
	public Long add(Store store) {
		logger.debug ( "Adding new Store" + store.getStoreName ( ) );
		store.setUpd( new Date () );
		store.setCpd( new Date () );
		return baseDao.add ( store );
	}

	public void edit (Store store) {
		logger.debug ( "Editting new Store" + store.getStoreName ( ) );
		store.setUpd( new Date () );
		baseDao.merge(store);	
	}

	public void delete (Store store) {
		logger.debug ( "Deleting Store" + store.getStoreName ( ) );
		store.setActive(false);
		edit(store);
	}

	public void delete (Long id) {
		logger.debug ( "Deleting Store" + id );
		Store store = (Store) get ( id );
		store.setActive( false );
		edit ( store );
	}

	@SuppressWarnings("unchecked")
	public List<Store> getAll() {
		logger.debug ( "Retrieving all Stores" );
		return (List<Store>) baseDao.findAll(Store.class);
	}

	public Store get (Long id) {
		logger.debug ( "Getting Store" + id );
		return (Store) baseDao.findById(Store.class, id);
	}
	
	public Store getInfo ( Long id ){
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "SELECT " +
						"new com.onsalenext.base.domain.admin.Store " +
						"(s.storeName, " +
						"s.ip, " +
						"s.certificate, " +
						"s.smtpUser, " +
						"s.homeState, " +
						"s.smtpPass, " +
						"s.infoEmail, " +
						"s.smtpHost, " +
						"s.smtpPort, " +
						"s.stateTax) " +
						"FROM Store s " +
						"JOIN s.ip " +
						"WHERE s.id = :id")
				.setParameter("id", id);
		return (Store) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List <Store> getAllInfo (){
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "select new com.onsalenext.base.domain.admin.Store "
						+ "(s.storeName, s.storeIp, s.certificate, s.smtpUser, s.homeState, " +
						"s.smtpPass, s.infoEmail, s.smtpHost, s.smtpPort, s.stateTax) " 
						+ " FROM Store s");
		return (List<Store>) query.list();
	}
	
	public Store findByName ( String name ){
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "select s FROM Store s WHERE s.storeName = :name")
				.setParameter("name", name);
		return (Store) query.uniqueResult();
	}
	
	public Store findByNameInfo ( String name ){
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "SELECT " +
						"new com.onsalenext.base.domain.admin.Store " +
						"(s.storeName, " +
						"s.ip, " +
						"s.certificate, " +
						"s.smtpUser, " +
						"s.homeState, " +
						"s.smtpPass, " +
						"s.infoEmail, " +
						"s.smtpHost, " +
						"s.smtpPort, " +
						"s.stateTax) " +
						"FROM Store s " +
						"JOIN s.ip " +
						"WHERE s.storeName = :name")
				.setParameter("name", name);
		return (Store) query.uniqueResult();
	}
	
	public Store findByIp ( String ip ){
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "SELECT " +
						"s " +
						"FROM Store s " +
						"JOIN s.ip p " +
						"WHERE p.ip = :ip")
				.setParameter("ip", ip);
		return (Store) query.uniqueResult();
	}
	
	public Store findByIpInfo ( String ip ){
		Query query = sessionFactory.getCurrentSession ( ).createQuery 
				( "SELECT " +
						"new com.onsalenext.base.domain.admin.Store " +
						"(s.storeName, " +
						"s.ip, " +
						"s.certificate, " +
						"s.smtpUser, " +
						"s.homeState, " +
						"s.smtpPass, " +
						"s.infoEmail, " +
						"s.smtpHost, " +
						"s.smtpPort, " +
						"s.stateTax) " +
						"FROM Store s " +
						"JOIN s.ip p " +
						"WHERE p.ip = :ip")
				.setParameter("ip", ip);
		return (Store) query.uniqueResult();
	}
}
