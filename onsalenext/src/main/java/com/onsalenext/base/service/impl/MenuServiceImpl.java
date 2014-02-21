package com.onsalenext.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.MenuDao;
import com.onsalenext.base.service.MenuService;
import com.onsalenext.base.service.converter.BrandConvert;
import com.onsalenext.base.service.converter.CategoryConvert;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.service.converter.PictureConvert;
import com.onsalenext.base.service.converter.ProductConvert;
import com.onsalenext.base.service.converter.SubCategoryConvert;
import com.onsalenext.base.web.model.menu.CategoryBom;
import com.onsalenext.base.web.model.menu.ProductBom;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private ItemConvert itemConvert;
	@Autowired
	private PictureConvert pictureConvert;
	@Autowired
	private BrandConvert brandConvert;
	@Autowired
	private CategoryConvert categoryConvert;
	@Autowired
	private SubCategoryConvert subCategoryConvert;
	@Autowired
	private ProductConvert productConvert;
	
	public List <CategoryBom> getAllCategories ( ){
		return categoryConvert.convert ( menuDao.getAllCategories ( ) );
	}
	
	public List <ProductBom> getAllProducts ( ){
		return productConvert.convert (menuDao.getAllProducts ( ) );
	}
	
	public CategoryBom getCategory ( Long id ){
		return categoryConvert.convert (menuDao.getCategory ( id )); 
	}
	
	public ProductBom getProduct ( Long id ){
		return productConvert.convert (menuDao.getProduct ( id ));
	}
	
	public Long add(CategoryBom category) {
		return menuDao.add( categoryConvert.convert (category, "ADD" ));
	}
	
	public void edit ( CategoryBom category ) {
		menuDao.edit ( categoryConvert.convert (category, "EDIT" ));
	}
	
	public void delete ( CategoryBom category ) {
		menuDao.delete ( categoryConvert.convert (category, "DELETE" ));
	}
	
	public void deleteCategory(Long id) {
		menuDao.deleteCategory ( id );
	}
	
	public Long add(ProductBom product) {
		return menuDao.add(productConvert.convert (product, "ADD"));
	}
	
	public void edit(ProductBom product) {
		menuDao.edit(productConvert.convert (product, "EDIT" ));
	}
	
	public void delete(ProductBom product) {
		menuDao.delete(productConvert.convert (product, "DELETE" ));
	}
	
	public void deleteProduct(Long id) {
		menuDao.deleteProduct(id);
	}
	
	public List<ProductBom> findProductByName(String productName){
		return productConvert.convert (menuDao.findProductByName(productName));
	}
	
	public ProductBom findProductChild(String category, String subCategory, String product){
		return productConvert.convert (menuDao.findProductChild(category, subCategory, product));
	}
	
	public ProductBom getProductByAttribute(String attribute){
		return productConvert.convert (menuDao.getProductByAttribute(attribute));
	}
	
	public CategoryBom findCategoryByName ( String name ){
		return categoryConvert.convert (menuDao.findCategoryByName(name));
	}
	
	public List<CategoryBom> getCategoryByStoreId ( Long storeId ){
		return categoryConvert.convert (menuDao.getCategoryByStoreId(storeId));
	}
	
	public List<CategoryBom> getCategoryByStoreName ( String name ){
		return categoryConvert.convert ( menuDao.getCategoryByStoreName(name));
	}
	
	public List<CategoryBom> getMenu ( Long storeId ){
		return categoryConvert.convert ( menuDao.getMenu(storeId) );
	}
}
