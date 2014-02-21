package com.onsalenext.base.service.rules.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.BrandDao;
import com.onsalenext.base.dao.HomeDao;
import com.onsalenext.base.dao.ItemDao;
import com.onsalenext.base.dao.MenuDao;
import com.onsalenext.base.domain.Store;
import com.onsalenext.base.domain.item.Brand;
import com.onsalenext.base.domain.item.Item;
import com.onsalenext.base.domain.menu.Category;
import com.onsalenext.base.domain.menu.Product;
import com.onsalenext.base.domain.menu.SubCategory;
import com.onsalenext.base.service.converter.ItemConvert;
import com.onsalenext.base.service.converter.PictureConvert;
import com.onsalenext.base.service.rules.StoreMenuService;
import com.onsalenext.base.web.model.item.BrandBom;
import com.onsalenext.base.web.model.item.ItemBom;
import com.onsalenext.base.web.model.menu.CategoryBom;
import com.onsalenext.base.web.model.menu.DepartmentBom;
import com.onsalenext.base.web.model.menu.MenuBom;
import com.onsalenext.base.web.model.menu.ProductBom;
import com.onsalenext.base.web.model.menu.SaleItemBom;
import com.onsalenext.base.web.model.menu.SubCategoryBom;

@Service
public class SotreMenuServiceImpl implements StoreMenuService {

	@Autowired
	private HomeDao homeDao;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private PictureConvert pictureConvert;
	@Autowired
	private ItemConvert itemConvert;
	
	public DepartmentBom getDepartment ( Long storeId ) {
		Store store_p = homeDao.get ( storeId );
		if ( store_p == null )
			return null;
		else {
			Set<Category> categories = store_p.getCategories();
			Set<CategoryBom> categoryBom = new TreeSet <CategoryBom> ();
			for ( Category c : categories){
				Set<SubCategory> subCategories = c.getSubCategories();
				Set<SubCategoryBom> subCategoryBom = new TreeSet <SubCategoryBom> ();
				for ( SubCategory sc : subCategories){					
					Set <Product> products = sc.getProducts();
					Set <ProductBom> productBom = new TreeSet <ProductBom> ();
					for ( Product p : products ){
						productBom.add(new ProductBom (p.getId(), p.getAttribute(), p.isActive(), 
								pictureConvert.convert (p.getPicture()), null));
					}
					subCategoryBom.add(new SubCategoryBom (sc.getId(), sc.getAttribute(), sc.isActive(), productBom));
				}
				Set<Brand> bs = c.getBrands();
				Set<BrandBom> bbs = new TreeSet<BrandBom> ();
				for ( Brand b : bs){
					bbs.add(new BrandBom (b.getId(), b.getAttribute(), b.isActive(), pictureConvert.convert(b.getPicture())));
				}
				categoryBom.add(new CategoryBom (c.getId(), c.getAttribute(), true, subCategoryBom, bbs));
				
			}
			return new DepartmentBom ( store_p.getId(), store_p.getStoreName(), categoryBom);
		}
	}

	public ProductBom getProductItems ( Long productId ){
		Product p = menuDao.getProduct(productId);
		if ( p == null )
			return null;
		else {
			Set <Item> itemSet = p.getItems();
			Set <ItemBom> i_BOM = new TreeSet <ItemBom> ();
			for ( Item i : itemSet ) i_BOM.add ( itemConvert.convert ( i, "SHORT" ) );
			return new ProductBom (p.getId(), p.getAttribute(), i_BOM);
		}
	}
	
	public List<BrandBom> getBrands( Long storeId ) {
		List<Brand> brands= brandDao.getStoreBrand( storeId );
		List<BrandBom> b_BOM = new ArrayList <BrandBom> ();
		for ( Brand b : brands ){
			b_BOM.add(new BrandBom(b.getId(), b.getAttribute(), b.isActive(), pictureConvert.convert(b.getPicture())));
		}
		Collections.sort (b_BOM,
				new Comparator<BrandBom> ()
                { public int compare (BrandBom a, BrandBom d)
                      { return (a.getAttribute().compareTo(d.getAttribute())); }
                });
		return b_BOM;
	}
	
	public SaleItemBom getPromoSaleMenu(Long storeId) {
		return new SaleItemBom ( itemConvert.convert (itemDao.getItemsSale(storeId)) );
	}

	public MenuBom getMenu ( Long storeId ){
		return new MenuBom ( this.getDepartment(storeId), this.getPromoSaleMenu(storeId));
	}
}
