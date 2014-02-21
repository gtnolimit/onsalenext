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

import com.onsalenext.base.service.CustomerService;
import com.onsalenext.base.web.model.person.CustomerBom;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService_i;
	
	@Autowired
	private View jsonView_i;

	private static final String CUSTOMER_FIELD = "customer";
	private static final String CUSTOMERS_FIELD = "customers";
	private static final String ERROR_FIELD = "error";
	
	@RequestMapping(value = { "/update/{customerId}" }, method = { RequestMethod.PUT })
	public ModelAndView updateCustomer(@RequestBody CustomerBom customer_p, @PathVariable("customerId") String customerId_p,
								   HttpServletResponse httpResponse_p) {
		try {
			customerService_i.edit(customer_p);
		} catch (Exception e) {
			String sMessage = "Error updateCustomer. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CUSTOMER_FIELD, null);
	}

	@RequestMapping(value = { "/add/" }, method = { RequestMethod.POST })
	public ModelAndView createCustomer(@RequestBody CustomerBom customer_p,
			HttpServletResponse httpResponse_p, WebRequest request_p) {

		Long createCustomerId;
		try {
			createCustomerId = (long) customerService_i.add ( customer_p );
			customer_p.setId( createCustomerId );
		} catch (Exception e) {
			String sMessage = "Error createOrder. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}
		httpResponse_p.setStatus(HttpStatus.CREATED.value());
		httpResponse_p.setHeader("order", request_p.getContextPath() + "/customer/" + createCustomerId);
		return new ModelAndView(jsonView_i, CUSTOMER_FIELD, customer_p );
	}

	@RequestMapping(value = "/customers/", method = RequestMethod.GET)
	public ModelAndView getCustomers() {
		return new ModelAndView(jsonView_i, CUSTOMERS_FIELD, customerService_i.getAll());
	}

	@RequestMapping ( value = "/get/{customerId}", method = RequestMethod.GET )
	public ModelAndView getCustomer ( @PathVariable ( "customerId" ) Long customerId ) {
		return new ModelAndView ( jsonView_i, CUSTOMER_FIELD, customerService_i.get ( customerId ) );
	}

	@RequestMapping(value = "/delete/{customerId}", method = RequestMethod.DELETE)
	public ModelAndView removeCustomer(@PathVariable("customerId") String customerId_p,
								   HttpServletResponse httpResponse_p) {

		try {
			Long id = Long.parseLong(customerId_p);
			customerService_i.delete ( id );
		} catch (Exception e) {
			String sMessage = "Error removeStore. [%1$s]";
			return createErrorResponse(String.format(sMessage, e.toString()));
		}

		httpResponse_p.setStatus(HttpStatus.OK.value());
		return new ModelAndView(jsonView_i, CUSTOMER_FIELD, null);
	}	
	public void setJsonView(View view) {
		jsonView_i = view;
	}
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}

}
