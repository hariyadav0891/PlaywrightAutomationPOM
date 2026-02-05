package com.base;


import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.pages.Homepage;
import com.pages.LoginPage;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	protected Homepage homepage;
	protected LoginPage loginpage; 
	
	@BeforeTest
	public void setUp() throws IOException {
		pf=new PlaywrightFactory();
		prop=pf.init_prop();
		page=pf.initBrowser(prop);
		homepage=new Homepage(page);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
}
