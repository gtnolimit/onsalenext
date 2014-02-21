package com.onsalenext.base.dao;

import java.util.List;

import com.onsalenext.base.domain.menu.Category;
import com.onsalenext.base.domain.menu.Product;

public interface MenuDao {
	
	public Long add ( Category category );
	public Long add ( Product product );
	
	public void edit ( Category category );
	public void edit ( Product product );
	
	public void delete ( Category category );
	public void delete ( Product product );
	
	public void deleteCategory ( Long id );
	public void deleteProduct ( Long id );
	
	public List<Category> getAllCategories ();
	public List<Product> getAllProducts ();

	public Category getCategory ( Long id );
	public Product getProduct ( Long id );
	
	public List<Product> findProductByName(String productName);
	public Product findProductChild(String category, String subCategory, String product);
	public Product getProductByAttribute(String attribute);
	public Category getCategoryByAttribute(String attribute);
	
	public Category findCategoryByName ( String name );
	
	public List<Category> getCategoryByStoreId ( Long storeId );
	public List<Category> getCategoryByStoreName ( String name );
	public List<Category> getMenu ( Long storeId );
	
	public Category getCategoryByProduct ( Long productId );
	
}
