package com.onsalenext.base.service;

import java.util.List;

import com.onsalenext.base.web.model.menu.CategoryBom;
import com.onsalenext.base.web.model.menu.ProductBom;

public interface MenuService {

	public List <CategoryBom> getAllCategories ( );
	public List <ProductBom> getAllProducts ( );
	
	public CategoryBom getCategory ( Long id );
	public ProductBom getProduct ( Long id );
	
	public Long add ( CategoryBom category );
	public void edit ( CategoryBom category );
	public void delete ( CategoryBom category );
	public void deleteCategory ( Long id );
	
	public Long add ( ProductBom product );
	public void edit ( ProductBom product );
	public void delete ( ProductBom product );
	public void deleteProduct ( Long id );
	
	
	public List<ProductBom> findProductByName(String productName);
	public ProductBom findProductChild(String category, String subCategory, String product);
	public ProductBom getProductByAttribute(String attribute);
	
	public CategoryBom findCategoryByName ( String name );
	
	public List<CategoryBom> getCategoryByStoreId ( Long storeId );
	public List<CategoryBom> getCategoryByStoreName ( String name );
	public List<CategoryBom> getMenu ( Long storeId );
}
