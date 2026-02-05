package com.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;
	
	private String emailId="//input[@id='input-email']";
	private String password="//input[@id='input-password']";
	private String loginButton="//input[@class='btn btn-primary']";
	private String forgottenPassword="//div[@class='form-group']/a[text()='Forgotten Password'][1]";
	
	private String logoutButton="//a[@class='list-group-item'][normalize-space()='Logout']";
	
	public LoginPage(Page page) {
		this.page=page;
	}
	
	public String getLoginPageTitle() {
		return page.title();
	}
	public boolean isForgottonPWlinkExist() {
		return page.isVisible(forgottenPassword);
	}
	public boolean doLogin(String email, String pwd) {
		page.fill(emailId, email);
		page.fill(password, pwd);
		page.click(loginButton);
		
		if(page.isVisible(logoutButton)) {
			System.out.println("User is logged is Successfully....");
			return true;
		}
		return false;
	}
}
