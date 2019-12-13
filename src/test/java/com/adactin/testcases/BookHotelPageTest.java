package com.adactin.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.adactin.base.TestBase;
import com.adactin.listeners.MyListener;
import com.adactin.pages.BookHotelPage;
import com.adactin.pages.ConfirmationPage;
import com.adactin.pages.HomePage;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SelectionPage;
import com.adactin.utility.TestUtility;

@Listeners(MyListener.class)

public class BookHotelPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	SelectionPage selectionpage;
	BookHotelPage bookhotelpage;
    ConfirmationPage confirmationpage;
    String sheetName="info";
    
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginpage = new LoginPage(driver);
		loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage(driver);
		homepage.validateSearchBtn();
		selectionpage = new SelectionPage(driver);
		selectionpage.validateSearchHotel();
		bookhotelpage = new BookHotelPage(driver);
	}
	
	@DataProvider
	public Object[][] getAdactinTestData() throws FileNotFoundException {
		Object data[][]=TestUtility.getExcelTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getAdactinTestData")
	public void VerifyHotelBooking(String fname,String Lname,String address, String CCno,String CCType,
			                        String Emonth, String EYear, String Cvv) {
		//confirmationpage=bookhotelpage.validateHotelBooking("tom", "peter","9876 frost place","2345678998765432",
		//		                                     "VISA", "May", "2021", "454");
		bookhotelpage.validateHotelBooking(fname, Lname, address, CCno, CCType, Emonth, EYear,Cvv);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
