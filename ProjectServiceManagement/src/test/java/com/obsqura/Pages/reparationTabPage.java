package com.obsqura.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class reparationTabPage {
	public WebDriver driver;
	public reparationTabPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	
	@FindBy(xpath="(//i[@class='fa fa-arrow-circle-right'])[1]")
	private WebElement reparationAndOrders;
	
	@FindBy(xpath="//h1[text()='Order & Reparations']")
	private WebElement orderandrepair;
	
	@FindBy(xpath="//tr[@class='warranty_row even' or @class ='warranty_row odd']")
	 private List<WebElement> rowsNumber;
	  
	 @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation'] ")
	 private WebElement reperationMoreInfoIcon;
	 
	 @FindBy(xpath="//select[@class='form-control input-sm select input-xs' and @aria-controls ='dynamic-table']")
	 private WebElement showNumberOfTables;
	 
	 @FindBy(xpath="//select[@class='form-control input-sm select input-xs' and @aria-controls='dynamic-table-completed']")
	 private WebElement showDropDown;
	 
	 @FindBy(xpath="//a[@href='#CompletedRepairs']")
    private WebElement completeRepair;
	 
	 @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation/export?'] ")
    private WebElement ExcelFileDownloadIcon;
	 
	 @FindBy(xpath="//div[@class='dt-button-collection fixed two-column']//button")
    private List<WebElement> columnButtons;
	 
	 @FindBy(xpath="//th[@aria-controls='dynamic-table']")
    private List<WebElement> tableColumnCount;
	 
	 @FindBy(xpath="(//span[text()='Column visibility'])[1]")
	 private WebElement columnVisibility;
	 
	 @FindBy(xpath="//div[@class='dt-button-background']")
	 private WebElement buttonBackaGround;
	 
	 @FindBy(xpath="//input[@class='form-control input-sm input-xs' and @aria-controls='dynamic-table']  ")
	 private WebElement searchButton;
	 
	 @FindBy(xpath="//tr[@class='invoice_link']")
	 private List<WebElement> rowCount;
	 
	 @FindBy(xpath="//th[@class='sorting' and @aria-controls='dynamic-table']")
	 private List<WebElement> columnNumb;
	 
	public void verifyOrdersAndRepairPage() throws IOException {
		String expectedMsg, actualmsg=ExcelUtility.getString(5, 1,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		PageUtility.clickOnElement(reparationAndOrders);
		expectedMsg=PageUtility.getElementText(orderandrepair);
		Assert.assertEquals(expectedMsg, actualmsg, "page is not navigated");	
	}
	  public void VerifyRowNumberInShowButton() throws IOException, InterruptedException {
		  String expectedNumber = ExcelUtility.getNumeric(8, 1, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  Thread.sleep(1000);
		  PageUtility.clickOnElement(completeRepair);
		  PageUtility.selectDropdownbyValue(showNumberOfTables, expectedNumber);
		  int size = rowsNumber.size();
		  String actualNumber = Integer.toString(size);
		  Assert.assertEquals(expectedNumber, actualNumber,"Both the numbers are not same");  
	   }
	  
	  public void verifyDownloadingReparationExcelSheet() { 
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  PageUtility.clickOnElement(completeRepair);
		  boolean excelFileIconPresent = ExcelFileDownloadIcon.isDisplayed();
		  Assert.assertTrue(excelFileIconPresent,"icon not present");
		  boolean excelFileIconEnabled = ExcelFileDownloadIcon.isEnabled();
		  Assert.assertTrue(excelFileIconEnabled,"is not enabled");
		  PageUtility.clickOnElement(ExcelFileDownloadIcon);	  
	   }
	  
	  public void verifyColumnVisibility() throws IOException, InterruptedException {
		  String textContent = ExcelUtility.getString(8, 2, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  String expectedCount = ExcelUtility.getNumeric(8, 3, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);	
		  WaitUtility.waitForElementClickable(driver, columnVisibility);
		  PageUtility.clickOnElement(columnVisibility);

		  PageUtility.selectElementFromListUsingGetText(columnButtons, textContent);
		  int columnCountAfter = PageUtility.getElementColumnSize(tableColumnCount);
		  String actualCount = Integer.toString(columnCountAfter);
		  Assert.assertEquals(actualCount, expectedCount,"Column count is not as expected");
	   }
	  
	  public void verifyRowCountWithSameName() throws IOException, InterruptedException {
		  String textContent = ExcelUtility.getString(8, 4, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  String expectedCount = ExcelUtility.getNumeric(8, 5, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  WaitUtility.waitForElementClickable(driver, searchButton);
		  PageUtility.clickOnElement(searchButton);
		  PageUtility.enterText(searchButton, textContent);
		  WaitUtility.waitForElementClickable(driver, searchButton);
		  int count = PageUtility.getElementRowSize(rowCount);
		  String actualCount = Integer.toString(count);
		  Assert.assertEquals(actualCount, expectedCount,"row count are not same");
	   }
	  
	  public void verifyTotalCompletedRepairRows() throws IOException, InterruptedException {
		  String value = ExcelUtility.getNumeric(8, 6, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  String expectedCount = ExcelUtility.getNumeric(8, 7, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  WaitUtility.waitForElementClickable(driver, completeRepair);
		  PageUtility.clickOnElement(completeRepair);
		  WaitUtility.waitForElementClickable(driver, completeRepair);
		  PageUtility.selectDropdownbyValue(showDropDown, value);
		  int count = PageUtility.getElementRowSize(rowsNumber);
		  String actualCount = Integer.toString(count);
		  Assert.assertEquals(actualCount, expectedCount,"both numbers are not same");	  
       }
	  
	  public void verifyColumnNumber() throws IOException, InterruptedException {
		  String expectedCount = ExcelUtility.getNumeric(8, 8, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  int count = PageUtility.getElementColumnSize(columnNumb);
		  String actualCount = Integer.toString(count);
		  Assert.assertEquals(actualCount, expectedCount,"both the column count are same");
	  }
	  public void VerifyrowNumberShowButtonForPendingRepairs() throws IOException, InterruptedException {
		  String expectedNumber = ExcelUtility.getNumeric(8, 1, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.clickOnElement(reperationMoreInfoIcon);
		  WaitUtility.waitForElementClickable(driver, reperationMoreInfoIcon);
		  PageUtility.selectDropdownbyValue(showNumberOfTables, expectedNumber);
		  int size = rowsNumber.size();
		  String actualNumber = Integer.toString(size);
		  Assert.assertEquals(expectedNumber, actualNumber,"Both the numbers are not same");  
	   }
}
