package com.onsalenext.base.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.onsalenext.base.domain.person.Customer;
import com.onsalenext.base.service.rules.LoginService;
import com.onsalenext.base.util.Crypto;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService_i;
	
	@Autowired
	private View jsonView_i;

	private static final String LOGIN_FIELD = "login";
	private static final String CUSTOMER_FIELD = "customer";
	private static final String ERROR_FIELD = "error";
	
	// if success return true fail return error
	@RequestMapping ( value = "resetPassword/{user}", method = RequestMethod.GET )
	public ModelAndView resetPassword ( @PathVariable ( "user" ) String user) {
		String tempPassword_p = loginService_i.resetPassword(user);
		if ( tempPassword_p == null ) {
			String sMessage = "User can not be found";
			return createErrorResponse(sMessage);
		}
		return new ModelAndView ( jsonView_i, LOGIN_FIELD, "true" );
	}
	
	// if success return true - faile return error
	@SuppressWarnings({ "static-access" })
	@RequestMapping ( value = "/{user}/{password}", method = RequestMethod.GET )
	public ModelAndView login ( @PathVariable ( "user" ) String user, 
			@PathVariable ( "password" ) String password) {
		Customer customer_p = loginService_i.login(user, password);
		if ( customer_p == null ) {
			String sMessage = "User can not be found!";
			return createErrorResponse(sMessage);
		}
		else {
			if ( !password.equals ( new Crypto () .decrypt ( customer_p.getUserInfo() .getPassword() ) ) ){
				String sMessage = "Wrong Password!";
				return createErrorResponse(sMessage);
			}
		}
		return new ModelAndView ( jsonView_i, CUSTOMER_FIELD, customer_p );
	}
	
	public void setJsonView(View view) {
		jsonView_i = view;
	}
	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}
}
