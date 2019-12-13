package com.adactin.testcases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.adactin.base.TestBase;
import com.adactin.pages.BookHotelPage;
import com.adactin.pages.ConfirmationPage;
import com.adactin.pages.HomePage;
import com.adactin.pages.LoginPage;
import com.adactin.pages.SelectionPage;

public class ConfirmationDBTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	SelectionPage selectionpage;
	BookHotelPage bookhotelpage;
	ConfirmationPage confirmationpage;
	String message;
	
	@BeforeTest
	public void setUp() throws IOException {
		initialization();
		loginpage = new LoginPage(driver);
		loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage(driver);
		homepage.validateSearchBtn();
		selectionpage = new SelectionPage(driver);
		selectionpage.validateSearchHotel();
		bookhotelpage = new BookHotelPage(driver);
		bookhotelpage.validateHotelBooking("Sri", "Ram", "2349 Frost place", "1234567887654321", "VISA", "October", "2021","345");
		confirmationpage=new ConfirmationPage(driver);
	}
	
	@Test(priority=1)
	public void verifyDBInfo() throws ClassNotFoundException, SQLException{
		
		HashMap<String,String>mybooking=new HashMap<String,String>();
		mybooking.put("hotelname", confirmationpage.validateHotelName());
		mybooking.put("firstname", confirmationpage.validateFirstName());
		mybooking.put("lastname", confirmationpage.validateLastName());
		mybooking.put("Orderno", confirmationpage.validateOrderNo());
		confirmationpage.validateMyItinerary();
		String Hotelname=mybooking.get("hotelname");
		String Fname=mybooking.get("firstname");
		String Lname=mybooking.get("lastname");
		String OrderNumber=mybooking.get("Orderno");
		System.out.println(Hotelname+" "+Fname+" "+Lname+" "+OrderNumber);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ bookingConformation", "root", "Tami123#");
		String squery1="insert into MyBooking(hotelname,firstname,lastname,OrderNo)"+" values(?,?,?,?)";
		PreparedStatement statement=conn.prepareStatement(squery1);
		statement.setString(1, Hotelname);
		statement.setString(2, Fname);
		statement.setString(3, Lname);
		statement.setString(4, OrderNumber);
		statement.execute();
		statement.close();
		conn.close();
		String cancelOrderNo="//input[contains(@value,'Cancel"+" "+OrderNumber+"')]";
		driver.findElement(By.xpath(cancelOrderNo)).click();
		driver.switchTo().alert().accept();
		 message=driver.findElement(By.id("search_result_error")).getText();
		System.out.println(message);
		driver.findElement(By.id("logout")).click();
	
	}
	@Test(dependsOnMethods= {"verifyDBInfo"})
	public void verifyCancellationText() {
		Assert.assertEquals(message, " booking has been cancelled");
		
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
