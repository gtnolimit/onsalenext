package com.onsalenext.base.service.impl;

import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onsalenext.base.dao.HomeDao;
import com.onsalenext.base.domain.Store;
import com.onsalenext.base.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private HomeDao homeDao; 
	
	private String SMTP_HOST = null;
	private String SMTP_PORT = null;
	private String SMTP_USER = null;
	private String SMTP_PASS = null;
	private String SMTP_FROM = null;
	
	public void SendEmail(Long storeId, String subject, String bodyText, String toEmail) {
		Properties props = this.setProperties ( storeId );
		Session session = Session.getDefaultInstance(props,  
			     new javax.mail.Authenticator() {  
			     protected PasswordAuthentication getPasswordAuthentication() {  
			     return new PasswordAuthentication(SMTP_USER,SMTP_PASS);  
			     }  
		}); 
		send ( session, subject, bodyText, toEmail, SMTP_FROM );	
	}

	public void SendEmail(Long storeId, String subject, String bodyText, String toEmail, String fromEmail) {
		Properties props = this.setProperties ( storeId );
		Session session = Session.getDefaultInstance(props,  
			     new javax.mail.Authenticator() {  
			     protected PasswordAuthentication getPasswordAuthentication() {  
			     return new PasswordAuthentication(SMTP_USER,SMTP_PASS);  
			     }  
		}); 
		send ( session, subject, bodyText, toEmail, fromEmail );
	}

	private Properties setProperties ( Long id ){
		
		Store store = homeDao.getInfo(id);
		
		SMTP_HOST = store.getSmtpHost ();
		SMTP_PORT = store.getSmtpPort ();
		SMTP_USER = store.getSmtpUser ();
		SMTP_PASS = store.getSmtpPass ();
		SMTP_FROM = store.getInfoEmail ();
				
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST);  
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);  
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.port", SMTP_PORT);
		return props;
	}
	
	private void send (Session session, String subject, String bodyText, String fromEmail, String toEmail){
		try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(fromEmail));//change accordingly  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));  
		     message.setSubject(subject);  
		     message.setText(bodyText);  
		       
		     //send message  
		     Transport.send(message);  
		    
		     //System.out.println("message sent successfully");  
		     
		  } catch (MessagingException e) {
		  	throw new RuntimeException(e);
		  }  
	}
	
	public String formatMessage ( String messagePattern, Object [] values){
		return MessageFormat.format ( messagePattern, values);
	}
}
