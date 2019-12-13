package com.adactin.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.adactin.base.TestBase;
import com.adactin.listeners.MyListener;
import com.adactin.pages.BookHotelPage;
import com.adactin.pages.HomePage;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SelectionPage;

@Listeners(MyListener.class)

public class SelectionPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	SelectionPage selectionpage;
	BookHotelPage bookhotelpage;
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		selectionpage=new SelectionPage(driver);
		homepage=loginpage.validateLogin(prop.getProperty("username"),prop.getProperty("password"));
		selectionpage=homepage.validateSearchBtn();
		
	}
	
	@Test
	public void verifySelectHotelText() {
		boolean flag3=selectionpage.validateSearchHotelText();
		Assert.assertFalse(flag3, "SEARCH HOTEL text is not present");
	}
	
	@Test
	public void verifyHotelSearch() {
		bookhotelpage=selectionpage.validateSearchHotel();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
