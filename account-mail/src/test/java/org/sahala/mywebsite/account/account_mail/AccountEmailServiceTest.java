package org.sahala.mywebsite.account.account_mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Before; 
import org.junit.Test; 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

import junit.framework.TestCase;

public class AccountEmailServiceTest {

	private GreenMail greenMail;
	
	@Before
	public void startEmailServer() throws Exception
	{
		greenMail=new GreenMail(ServerSetup.SMTP);
		greenMail.setUser("test", "123");
		greenMail.start();
		
		System.out.println(greenMail.getSmtp().getName() +"/"+ greenMail.getSmtp().getPort());
	}
	
	@Test
	public void testSendMail() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
		AccountEmailService accountEmailService = (AccountEmailService)ctx.getBean("accountMailService");
		
		String subject ="Test subject";
		String htmlText = "<h1>head 1</h1>";
		
		try {
			System.out.println(accountEmailService.toString());
			
			accountEmailService.sendMail("test@test.com", subject, htmlText);
			greenMail.waitForIncomingEmail(2000,1);
			
			
			Message[] msgs = greenMail.getReceivedMessages();
			assertEquals(1,msgs.length);
			assertEquals(subject,msgs[0].getSubject());
			assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
		} catch (AccountEmailException e) {
			assertTrue(Boolean.FALSE);
		} catch (InterruptedException e) {
			assertTrue(Boolean.FALSE);
		} catch (MessagingException e) {
			assertTrue(Boolean.FALSE);
		}
	}

	@After
	public void stopEmailServer()
	{
		greenMail.stop();
		System.out.println("greenMail stopped.");
	}
}
