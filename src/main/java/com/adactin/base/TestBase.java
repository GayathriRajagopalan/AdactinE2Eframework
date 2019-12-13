package com.adactin.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.adactin.utility.TestUtility;
import com.adactin.utility.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public static void initialization() throws IOException{
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\gay3v\\eclipse-workspaceNew1\\adactinE2EAutomation\\src\\main\\java\\com\\adactin\\config\\config.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\auto\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\auto\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else {
			System.setProperty("webdriver.edge.driver", "C:\\auto\\edgedriver.exe");
			driver=new InternetExplorerDriver();
		}
		
		
		  EventFiringWebDriver e_driver=new EventFiringWebDriver(driver);
		  WebEventListener eventListener=new WebEventListener();
		  e_driver.register(eventListener);
		  driver=e_driver;
		 
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		
	}
		

}
