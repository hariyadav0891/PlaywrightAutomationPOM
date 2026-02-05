package com.tests;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.constants.AppConstants;

public class HomePageTest extends BaseTest{
	
	
	@Test
	public void homePageTitleTest() {
		String title=homepage.getHomePageTitle();
		AssertJUnit.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
	}
	@Test
	public void homePageURLTest() {
		String url=homepage.getHomePageURL();
		AssertJUnit.assertEquals(url, prop.getProperty("url").trim());
	}
	
	@DataProvider
	public Object[][] getProductData(){
		return new Object[][] {
			{"MacBook"},
			{"iMac"},
			{"Samsung"}
		};
	}
	@Test(dataProvider = "getProductData")
	public void searchTest(String produvtName) {
		String searchHeader=homepage.doSearch(produvtName);
		Assert.assertEquals(searchHeader, "Search - "+produvtName);
	}
	
	
	
}
