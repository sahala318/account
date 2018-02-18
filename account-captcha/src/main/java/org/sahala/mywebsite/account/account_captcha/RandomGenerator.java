package org.sahala.mywebsite.account.account_captcha;

import java.util.Random;

public class RandomGenerator {

	private static String ranges = "1234567890abcd";
	
	public static synchronized String getRandomString()
	{
		Random random = new Random();
		StringBuffer result = new StringBuffer();
		for(int i=0;i < 8 ;i ++)
		{
			result.append(ranges.charAt(random.nextInt(ranges.length())));
		}
		return result.toString();
	}
}
