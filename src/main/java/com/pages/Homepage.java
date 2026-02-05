package com.pages;

import com.microsoft.playwright.Page;

public class Homepage {

	private Page page;
	public Homepage(Page page) {
		this.page=page;
	}
	 private String search="//input[@placeholder='Search']";
	 private String searchIcon="//button[@class='btn btn-default btn-lg']";
	 private String searchPageHeader="//div[@id='content']/h1";
	 private String myAccountLink="//span[text()='My Account']";
	 private String loginLink="//a[text()='Login']";
	 
	 
	 
	 public String getHomePageTitle() {
		 String title= page.title();
		 System.out.println("Page Title : "+title);
		 return title;
	 }
	 
	 public String getHomePageURL() {
		 String url= page.url();
		 System.out.println("Url of Page : "+url);
		 return url;
	 }
	 public String doSearch(String productName) {
		 page.fill(search, productName);
		 page.click(searchIcon);
		 page.locator(searchPageHeader).waitFor();
		String header=  page.textContent(searchPageHeader);
		System.out.println("Search Header :"+header);
		return header;
	 }
	 
	 public LoginPage clickOnLoginPage() {
		 page.click(myAccountLink);
		 page.click(loginLink);
		 return new LoginPage(page);
	 }
}
