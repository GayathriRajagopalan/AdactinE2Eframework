package com.adactin.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.adactin.base.TestBase;

public class TestUtility extends TestBase {
	static Workbook book;
	static Sheet sheet;

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 15;

	//Screenshot Method
	public static void getScreenshot(String MethodName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\gay3v\\eclipse-workspaceNew1\\adactinE2EAutomation\\Screenshots"
				+ MethodName + "_" + ".jpg"));
	}
    
	//Retrieving data from excel
	public static Object[][]getExcelTestData(String sheetName) throws FileNotFoundException {
		//FileInputStream fis1=null;
	   FileInputStream fis1=new FileInputStream("C:\\Users\\gay3v\\eclipse-workspaceNew1\\adactinE2EAutomation\\src\\main\\java\\"+
		                                         "com\\adactin\\testdata\\AdactinTestData.xlsx");
	   try {
		book=WorkbookFactory.create(fis1);
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  sheet=book.getSheet(sheetName);
	  Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	  int LastrowNo=sheet.getLastRowNum();
	  int LastcellNo=sheet.getRow(1).getLastCellNum();
	  for(int i=0;i<LastrowNo;i++) {
		  for(int j=0;j<LastcellNo;j++) {
			  data[i][j]=sheet.getRow(i +1).getCell(j).toString();
			  
		  }
	  }
	   return data;
   }
}
