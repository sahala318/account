package org.sahala.mywebsite.account.account_captcha;

import java.util.List;

public interface AccountCaptchaService {
	String generateCaptchaKey() throws AccountCaptchaException;
	byte[] generateCaptchaImage(String key) throws AccountCaptchaException;
	boolean validateCaptcha(String key,String captchaValue) throws AccountCaptchaException;
	List<String> getPreDefinedTexts();
	void setPreDefinedTexts(List<String> list);
}
