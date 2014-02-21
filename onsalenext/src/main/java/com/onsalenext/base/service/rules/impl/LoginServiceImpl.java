package com.onsalenext.base.service.rules.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.CustomerDao;
import com.onsalenext.base.dao.LoginDao;
import com.onsalenext.base.domain.person.Customer;
import com.onsalenext.base.domain.person.UserInfo;
import com.onsalenext.base.service.EmailService;
import com.onsalenext.base.service.rules.LoginService;
import com.onsalenext.base.util.Crypto;
import com.onsalenext.base.util.RandomStringGenerator;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private EmailService emailService;
	
	@SuppressWarnings({ })
	public Customer login ( String user, String password ) {
		Customer cust_p = loginDao.login ( user );
		if ( cust_p == null )
			return null;
		return cust_p;
	}

	@SuppressWarnings("static-access")
	public String resetPassword ( String user ) {
		Customer customer_p = loginDao.resetPassword ( user );
		if ( customer_p == null )
			return null;
		String _tempPassword = new RandomStringGenerator () .generateRandomPassword ();
		UserInfo userInfo_p = customer_p.getUserInfo ();
		userInfo_p.setPassword ( new Crypto () .encrypt ( _tempPassword ) );
		customer_p.setUserInfo ( userInfo_p );
		customerDao.edit ( customer_p );
		Object [] values = {customer_p.getFirstName(), _tempPassword, "link", "On Sale Next"};
		String message = this.messageForgorPassword( values );
		emailService.SendEmail(new Long (1), "Password Reset", message, "gtnolimit@yahoo.com");
		return _tempPassword;
	}

	// {0} - username
	// {1} - temp password
	// {2} - link to reset password
	// {3} - store name

	private String messageForgorPassword ( Object [] values){
		String message = "";
		String message_p = "Hi {0},\nYou recently asked to reset your password."
		+"\nYour temporary password\n{1}\nPlease use link below to reset your password"
		+"\n{2}\nThank you for choosing {3}";
		message = emailService.formatMessage(message_p, values);
		return message;
	}
}
