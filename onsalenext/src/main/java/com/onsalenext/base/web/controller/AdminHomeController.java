package com.onsalenext.base.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.onsalenext.base.service.HomeService;
import com.onsalenext.base.web.model.StoreBom;

@Controller
@RequestMapping("/admin/store")
public class AdminHomeController {


	@Autowired
	private HomeService homeService_i;
	
	@Autowired
	private View jsonView_i;

	private static final String STORE_FIELD = "store";
	private static final String STORES_FIELD = "stores";
	private static final String ERROR_FIELD = "error";
	
	@RequestMapping(value = { "/update/{storeId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateStore(@RequestBody StoreBom store_p, @PathVariable("storeId") String storeId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			homeService_i.edit(store_p);
		} catch (Exception e) {
			String sMessage = "Error updateStore. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, STORE_FIELD, store_p);
	}
	
	@RequestMapping(value = { "/add/" }, method = { RequestMethod.POST })
	public ModelAndView createOrder(@RequestBody StoreBom store_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Long createStoreId;
		try {
			createStoreId = (long) homeService_i.add ( store_p );
			store_p.setId( createStoreId );
		} catch (Exception e) {
			String sMessage = "Error createOrder. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("order", request_p.getContextPath() + "/store/" + createStoreId);
		return new ModelAndView(jsonView_i, STORE_FIELD, store_p );
	}
	
	@RequestMapping(value = "/stores/", method = RequestMethod.GET)
	public ModelAndView getStores() {
		return new ModelAndView(jsonView_i, STORES_FIELD, homeService_i.getAll());
	}
	
	@RequestMapping(value = "/delete/{storeId}", method = RequestMethod.DELETE)
	public ModelAndView removeStore(@PathVariable("storeId") Long orderId,
								   HttpServletResponse httpResponse_p) {
		homeService_i.delete ( orderId );
		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, STORE_FIELD, null);
	}
	
	public void setJsonView(View view) {
		jsonView_i = view;
	}
	
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}
}
