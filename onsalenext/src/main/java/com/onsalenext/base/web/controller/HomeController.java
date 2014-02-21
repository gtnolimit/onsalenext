package com.onsalenext.base.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.onsalenext.base.service.ItemService;
import com.onsalenext.base.service.rules.StoreMenuService;

@Controller
@RequestMapping("/store")
public class HomeController {

	@Autowired
	private StoreMenuService storeMenu_i;
	@Autowired
	private ItemService itemService_i;
	
	@Autowired
	private View jsonView_i;
	
	private static final String STORE_FIELD = "store";
	private static final String SALES_FIELD = "sales";
	private static final String SALES_ABOVE_250_FIELD = "salesAbove250";
	private static final String SALES_250_100_FIELD = "sales250_100";
	private static final String SALES_100_50_FIELD = "sales100_50";
	private static final String SALES_50_20_FIELD = "sales50_20";
	private static final String SALES_20_10_FIELD = "sales20_10";
	private static final String SALES_10_5_FIELD = "sales10_5";
	private static final String SALES_BELOW_5_FIELD = "salesBelow5";
	private static final String DEPARTMENT_FIELD = "department";
	private static final String PRODUCT_FIELD = "product";
	private static final String BRANDS_FIELD = "brands";
	private static final String MENU_FIELD = "menu";
	
	@RequestMapping ( value = "/store/{storeId}", method = RequestMethod.GET )
	public ModelAndView getStore ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, STORE_FIELD, storeMenu_i.getDepartment(storeId) );
	}
	
	@RequestMapping ( value = "/department/{storeId}", method = RequestMethod.GET )
	public ModelAndView getDepartmets ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, DEPARTMENT_FIELD, storeMenu_i.getDepartment(storeId) );
	}
	
	@RequestMapping ( value = "/sales/{storeId}", method = RequestMethod.GET )
	public ModelAndView getSales ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, SALES_FIELD, storeMenu_i.getPromoSaleMenu ( storeId ) );
	}
	
	@RequestMapping ( value = "/salesOver250/{storeId}", method = RequestMethod.GET )
	public ModelAndView getSalesOver250 ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, SALES_ABOVE_250_FIELD, itemService_i.getItemsOver250(storeId) );
	}
	
	@RequestMapping ( value = "/sales250_100/{storeId}", method = RequestMethod.GET )
	public ModelAndView getSales250_100 ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, SALES_250_100_FIELD, itemService_i.getItems250_100(storeId) );
	}
	
	@RequestMapping ( value = "/sales100_50/{storeId}", method = RequestMethod.GET )
	public ModelAndView getSales100_50 ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, SALES_100_50_FIELD, itemService_i.getItems100_50(storeId) );
	}
	
	@RequestMapping ( value = "/sales50_20/{storeId}", method = RequestMethod.GET )
	public ModelAndView getSales50_20 ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, SALES_50_20_FIELD, itemService_i.getItems50_20(storeId) );
	}

	@RequestMapping ( value = "/sales20_10/{storeId}", method = RequestMethod.GET )
	public ModelAndView getSales20_10 ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, SALES_20_10_FIELD, itemService_i.getItems20_10(storeId) );
	}
	
	@RequestMapping ( value = "/sales10_5/{storeId}", method = RequestMethod.GET )
	public ModelAndView getSales10_5 ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, SALES_10_5_FIELD, itemService_i.getItems10_5(storeId) );
	}
	
	@RequestMapping ( value = "/salesBelow5/{storeId}", method = RequestMethod.GET )
	public ModelAndView getSalesBelow5 ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, SALES_BELOW_5_FIELD, itemService_i.getItemsBelow5(storeId) );
	}
	
	@RequestMapping ( value = "/salesEmail/{storeId}", method = RequestMethod.GET )
	public ModelAndView getSalesEmail ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, SALES_BELOW_5_FIELD, itemService_i.getItemsSaleEmail(storeId));
	}

	@RequestMapping ( value = "/saleClerance/{storeId}", method = RequestMethod.GET )
	public ModelAndView getSalesClerancel ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, SALES_BELOW_5_FIELD, itemService_i.getItemsClerance(storeId));
	}

	@RequestMapping ( value = "/product/{productId}", method = RequestMethod.GET )
	public ModelAndView getProductItems ( @PathVariable ( "productId" ) Long productId ) {
		return new ModelAndView ( jsonView_i, PRODUCT_FIELD, storeMenu_i.getProductItems(productId) );
	}
	
	@RequestMapping ( value = "/brands/{storeId}", method = RequestMethod.GET )
	public ModelAndView getBrands ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, BRANDS_FIELD, storeMenu_i.getBrands(storeId) );
	}

	@RequestMapping ( value = "/menu/{storeId}", method = RequestMethod.GET )
	public ModelAndView getMenu ( @PathVariable ( "storeId" ) Long storeId ) {
		return new ModelAndView ( jsonView_i, MENU_FIELD, storeMenu_i.getMenu(storeId) );
	}
	
	public void setJsonView(View view) {
		jsonView_i = view;
	}
}
