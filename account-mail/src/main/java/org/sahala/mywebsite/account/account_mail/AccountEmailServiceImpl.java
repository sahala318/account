package org.sahala.mywebsite.account.account_mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AccountEmailServiceImpl implements AccountEmailService {
	private JavaMailSender javaMailSender;
	
	private String systemEmail;

	@Override
	public void sendMail(String to, String subject, String htmlText)
			throws AccountEmailException {
		 try
		 {
			 MimeMessage msg = javaMailSender.createMimeMessage();
			 MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
			 
			 msgHelper.setFrom(systemEmail);
			 msgHelper.setTo(to);
			 msgHelper.setSubject(subject);
			 msgHelper.setText(htmlText,true);
			 
			 javaMailSender.send(msg);
		 }
		 catch(MessagingException ex)
		 {
			 throw new AccountEmailException("sendMail failed.",ex);
		 }
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public String getSystemEmail() {
		return systemEmail;
	}

	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}
	
	

}
