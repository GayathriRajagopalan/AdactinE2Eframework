package com.adactin.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.base.TestBase;

public class ConfirmationPage extends TestBase {

	@FindBy(id = "hotel_name")
	WebElement hotelNameValue;

	@FindBy(id = "location")
	WebElement LocationValue;

	@FindBy(id = "first_name")
	WebElement firstNameValue;

	@FindBy(id = "last_name")
	WebElement lastNameValue;

	@FindBy(id = "order_no")
	WebElement orderNoValue;

	@FindBy(id = "my_itinerary")
	WebElement myItinerary;

	public ConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	/*
	 * public CancellationPage myItinerary() { hotelNameValue.getAttribute("value");
	 * LocationValue.getAttribute("value"); firstNameValue.getAttribute("value");
	 * lastNameValue.getAttribute("value"); orderNoValue.getAttribute("value");
	 * myItinerary.click(); return new CancellationPage(); }
	 */
	public String validateHotelName() {
		return hotelNameValue.getAttribute("value");
	}

	public String validateFirstName() {
		return firstNameValue.getAttribute("value");
	}

	public String validateLastName() {
		return lastNameValue.getAttribute("value");
	}

	public String validateOrderNo() {
		return orderNoValue.getAttribute("value");
	}
	public CancellationPage validateMyItinerary() {
		myItinerary.click();
		return new CancellationPage();
	}
}