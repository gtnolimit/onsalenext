package com.onsalenext.base.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onsalenext.base.dao.BaseDao;
import com.onsalenext.base.dao.MenuDao;
import com.onsalenext.base.domain.menu.Category;
import com.onsalenext.base.domain.menu.Product;

@Transactional
@Repository
public class MenuDaoImpl implements MenuDao{

	protected static Logger logger = Logger.getLogger ( "MenuDao" );
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private BaseDao baseDao;
	

	public Long add(Category category) {
		category.setUpd( new Date () );
		category.setCpd( new Date () );
		return baseDao.add ( category );
	}

	public Long add(Product product) {
		product.setCpd( new Date () );
		product.setUpd( new Date () );
		return baseDao.add ( product );
	}

	public void edit(Category category) {
		category.setUpd( new Date () );
		baseDao.merge(category);
	}

	public void edit(Product product) {
		product.setUpd( new Date () );
		baseDao.merge(product);		
	}

	public void delete(Category category) {
		category.setActive(false);
		edit(category);
	}

	public void delete(Product product) {
		product.setActive(false);
		edit(product);		
	}

	public void deleteCategory(Long id) {
		Category obj = (Category) getCategory ( id );
		obj.setActive( false );
		edit ( obj );
	}

	public void deleteProduct(Long id) {
		Product obj = (Product) getProduct ( id );
		obj.setActive( false );
		edit ( obj );
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		return (List<Category>) baseDao.findAll(Category.class);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		return (List<Product>) baseDao.findAll(Product.class);
	}

	public Category getCategory(Long id) {
		return (Category) baseDao.findById(Category.class, id);
	}

	public Product getProduct(Long id) {
		return (Product) baseDao.findById(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findProductByName(String productName) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
		        Product.class);
		criteria.add(Restrictions.ilike("attribute", productName + "%"));
		return criteria.list();
	}
	
	public Product getProductByAttribute(String attribute) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "FROM Product p where p.attribute = :attribute");
		q.setParameter("attribute", attribute);
		return (Product) q.uniqueResult();
	}

	public Category getCategoryByAttribute(String attribute) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "FROM Category c where c.attribute = :attribute");
		q.setParameter("attribute", attribute);
		return (Category) q.uniqueResult();
	}

	public Product findProductChild(String category, String subCategory,
	        String product) {
		Query q = sessionFactory.getCurrentSession().createQuery(
		        "select prd FROM Category cat "
		                + "join cat.subCategory subCat "
		                + "join subCat.product prd "
		                + "where cat.attribute = :catName "
		                + "and subCat.attribute = :subCatName "
		                + "and prd.attribute = :prdName");
				q.setParameter("catName", category)
		        .setParameter("subCatName", subCategory)
		        .setParameter("prdName", product);
		return (Product) q.uniqueResult();
	}
	
	public Category findCategoryByName ( String name ){
		return (Category) baseDao.findByProperty(Category.class, "attribure", name);
	}
	
	// TODO does not work
	@SuppressWarnings("unchecked")
	public List<Category> getCategoryByStoreId ( Long storeId ){
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT new com.onsalenext.base.domain.menu.Category "
				+ " (c.id, c.attribute ) "
				+ "FROM Store s JOIN s.categories c "
				+ "WHERE s.id = :storeId");
		q.setParameter("storeId", storeId);
		return (List<Category>) q.list();
	}
	// TODO does not work
	@SuppressWarnings("unchecked")
	public List<Category> getCategoryByStoreName ( String name ){
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT new com.onsalenext.base.domain.menu.Category "
				+ " (c.id, c.attribute ) "
				+ "FROM Store s JOIN s.categories c "
				+ "WHERE c.id=s.id AND s.storeName = :name " +
				" ORDER BY c.attribute");
		q.setParameter("name", name);
		return (List<Category>) q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> getMenu ( Long storeId ){
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT DISTINCT (c)" +
				" FROM Store s" +
				" JOIN s.categories c" +
				" WHERE s.id = :storeId" +
			" ORDER BY c.attribute");
		q.setParameter("storeId", storeId);
		return (List<Category>) q.list();
	}

	public Category getCategoryByProduct(Long productId) {
		Query q = sessionFactory.getCurrentSession().createQuery(
				"SELECT c" +
				" FROM categories c" +
				" JOIN c.subCategory sc" +
				" JOIN sc.product p" +
				" WHERE p.id = :productId" +
			" ORDER BY c.attribute");
		q.setParameter("productId", productId);
		return ( Category ) q.uniqueResult();
	}
}
