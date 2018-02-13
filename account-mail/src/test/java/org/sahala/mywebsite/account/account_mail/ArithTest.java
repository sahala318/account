package org.sahala.mywebsite.account.account_mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class ArithTest {

	@Test
	public void testAdd() {

		assertEquals("Arith.add failed", 0.06, Arith.add(0.05, 0.01), 0.00);

		assertFalse("dircect add failed",(0.05 + 0.01)==0.06);
	}

	@Test
	public void testSub() {
		assertEquals("Arith.sub failed.",Arith.sub(1.0d , 0.42d),0.58, 0);
		assertFalse("direct sub failed",(1.0-0.42)==0.58);
	}

	@Test
	public void testMul() {
		assertEquals("Arith.Mul failed.",Arith.mul(4.015, 100),401.5, 0);
		assertFalse("direct Mul failed",(4.015*100)==401.5);
	}

	@Test
	public void testDivDoubleDouble() {
		double d = 5.70d;
		assertEquals("Arith.divDoubleDouble failed ",0.057, Arith.div(d, 100),0);
		
		float a = 5.70f /100;
		
		assertFalse("dircect div failed",a==0.057);
	}

	@Test
	public void testDivDoubleDoubleInt() {
		double d = 5.70d;
		assertEquals("Arith.divDoubleDoubleInt failed ",0.057, Arith.div(d, 100, 4),0);
		
		float a = 5.70f /100;
		
		assertFalse("dircect div failed",a==0.057);
	}

	@Test
	public void testRound() {
		assertEquals("Arith.testRound failed ",0.057, Arith.div(5.70, 100, 4),0);
	}

}
