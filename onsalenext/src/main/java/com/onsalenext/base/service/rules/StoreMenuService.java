package com.onsalenext.base.service.rules;

import java.util.List;

import com.onsalenext.base.web.model.item.BrandBom;
import com.onsalenext.base.web.model.menu.DepartmentBom;
import com.onsalenext.base.web.model.menu.MenuBom;
import com.onsalenext.base.web.model.menu.ProductBom;
import com.onsalenext.base.web.model.menu.SaleItemBom;

public interface StoreMenuService {
	
	public DepartmentBom getDepartment ( Long storeId);
	public ProductBom getProductItems ( Long productId );
	public List<BrandBom> getBrands ( Long storeId );
	public SaleItemBom getPromoSaleMenu ( Long storeId );
	public MenuBom getMenu ( Long storeId );
	
}
