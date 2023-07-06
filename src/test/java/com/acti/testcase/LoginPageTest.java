package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test
	public void testLoginFunction() throws InterruptedException {


		lp.enterUserName("admin");
		lp.enterPassWord("manager");
		lp.loginButton();

		String actualuser = ep.getuserLoggedInfo();
		System.out.println(actualuser);
		Assert.assertTrue(actualuser.contains("John Doe"));
		ep.clicklogoutlink();
		Thread.sleep(3000);

	}
	@Test
	public void testForgotPasswordLink() {
	boolean flag = lp.passwordRecoverylink();
	Assert.assertTrue(flag);
	}
	@Test
	public void testPageTitle() {
		String title = lp.getPageTitle();
		Assert.assertTrue(title.contains("Login"));
		
	}
	@Test
	public void testLoginImage() {
		boolean img = lp.testLoginImage();
		Assert.assertTrue(img);
	}
	@Test
	public void testactiLink() {
		boolean flag = lp.testactiTimeLink();
		Assert.assertTrue(flag);
	}

}
