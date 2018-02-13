package org.sahala.mywebsite.account.account_mail;

public interface AccountEmailService {
	void sendMail(String to,String subject,String htmlText) throws AccountEmailException;
}
