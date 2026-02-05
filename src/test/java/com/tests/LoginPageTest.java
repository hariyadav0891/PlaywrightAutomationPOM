package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.constants.AppConstants;

public class LoginPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void loginPageNavigationTest() {
		loginpage=homepage.clickOnLoginPage();
		String loginTitle=loginpage.getLoginPageTitle();
		System.out.println("Page actualt Title :"+loginTitle);
		Assert.assertEquals(loginTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	@Test(priority = 2)
	public void forgottenPWlinkExist() {
		Assert.assertTrue(loginpage.isForgottonPWlinkExist());
	}
	//@Test(priority = 3)
	
	public void appLogin() {
		Assert.assertTrue(loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}

}
