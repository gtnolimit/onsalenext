package com.onsalenext.base.service;

public interface EmailService {

	public void SendEmail (Long storeId, String subject, String bodyText, String toEmail );
	public void SendEmail ( Long storeId, String subject, String bodyText, String toEmail, String fromEmail);
	public String formatMessage ( String messagePattern, Object [] values);
}
