package com.adactin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.adactin.base.TestBase;

public class BookHotelPage extends TestBase{
	
	@FindBy(id="first_name")
	WebElement FirstNameInputbox;
	
	@FindBy(id="last_name")
	WebElement LastNameInputbox;
	
	@FindBy(id="address")
	WebElement AddressInputbox;
	
	@FindBy(id="cc_num")
	WebElement creditCard;
	
	@FindBy(id="cc_type")
	WebElement creditCardType;
	
	@FindBy(id="cc_exp_month")
	WebElement expiryMonth;
	
	@FindBy(id="cc_exp_year")
	WebElement expiryYear;
	
	@FindBy(id="cc_cvv")
	WebElement CVV;
	
	@FindBy(xpath="//input[@id='book_now']")
	WebElement bookNowBtn;
	
	public BookHotelPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public ConfirmationPage validateHotelBooking(String Fname,String Lname,String Address,String CCNo, 
			String CCType,String EMonth, String EYear, String cvv) {
		FirstNameInputbox.sendKeys(Fname);
		LastNameInputbox.sendKeys(Lname);
		AddressInputbox.sendKeys(Address);
		creditCard.sendKeys(CCNo);
		Select type=new Select(creditCardType);
		type.selectByVisibleText(CCType);
		Select month=new Select(expiryMonth);
		month.selectByVisibleText(EMonth);
		Select year=new Select(expiryYear);
		year.selectByVisibleText(EYear);
		CVV.sendKeys(cvv);
		 bookNowBtn.click();
		 return new ConfirmationPage(driver);
	}

/*public ConfirmationPage ConfirmationPage() {
		FirstNameInputbox.sendKeys("Rhea");
		LastNameInputbox.sendKeys("Peter");
		AddressInputbox.sendKeys("9090 Fremont Blvd");
		creditCard.sendKeys("1234567899876543");
		Select type=new Select(creditCardType);
		type.selectByVisibleText("American Express");
		Select month=new Select(expiryMonth);
		month.selectByValue("9");
		Select year=new Select(expiryYear);
		year.selectByValue("2022");
		CVV.sendKeys("323");
		 bookNowBtn.click();
		 return new ConfirmationPage();
	}
*/
}
