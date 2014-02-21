package com.onsalenext.base.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.onsalenext.base.service.CustomerService;
import com.onsalenext.base.service.HomeService;
import com.onsalenext.base.service.ItemService;
import com.onsalenext.base.service.MenuService;
import com.onsalenext.base.service.test.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private CustomerService customerService_i;
	@Autowired
	private MenuService menuService_i;
	@Autowired
	private HomeService homeService_i;
	@Autowired
	private ItemService itemService_i;
	@Autowired
	private TestService testService_i;

	@Autowired
	private View jsonView_i;

	private static final String ERROR_FIELD = "error";
	private static final String STORE_FIELD = "store";
	private static final String ITEMS_FIELD = "items";
	
	@RequestMapping(value = "/store/", method = RequestMethod.GET)
	public ModelAndView createStore() {
		testService_i.setBrands();
		testService_i.setColor ();
		testService_i.setRating();
		testService_i.setSize();
		testService_i.setTag();
		testService_i.setTax();
		testService_i.setItem();
		testService_i.setCustomer();
		testService_i.setStore();
		testService_i.createCart();
		testService_i.createOrder();
		return new ModelAndView(jsonView_i, STORE_FIELD, null);
	}

	@RequestMapping ( value = "/saleItems/{storeId}", method = RequestMethod.GET )
	public ModelAndView getItemsSale ( @PathVariable ( "storeId" ) Long storeId ) {
			return new ModelAndView ( jsonView_i, ITEMS_FIELD, itemService_i.getPromoItemsSale(storeId) );
	}
	
	public void setJsonView(View view) {
		jsonView_i = view;
	}
	@SuppressWarnings("unused")
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}
}
