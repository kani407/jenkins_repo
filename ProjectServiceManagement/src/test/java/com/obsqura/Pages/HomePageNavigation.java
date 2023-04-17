package com.obsqura.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class HomePageNavigation{
	public WebDriver driver;
	public HomePageNavigation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//a[@ href='https://qalegend.com/mobile_service/panel/inventory']")
    private WebElement inventoryProductMoreInfoOption;
    
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation'] ")
	private WebElement reperationMoreInfoIcon;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers']")
	private WebElement clientMoreInfo;
	
	 @FindBy(xpath="//a[@class='btn blightOrange tip']")
	 private WebElement qualityAlertIcon;
	   
	 @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reports/quantity_alerts']")
	 private WebElement qualityAlertNavigationaIcon;
	 
	 @FindBy(xpath="//tr[@class='odd' or @class='even']")
	 private List<WebElement> rowList;
	
	public void verifyNavigateToInventoryPage() throws IOException {
		 String expectedPage = ExcelUtility.getString(7, 1, System.getProperty("user.dir") +"Constants.Constants.TESTDATAFILE","Sheet1");
		 PageUtility.clickOnElement(inventoryProductMoreInfoOption);
		 String actualPage = driver.getCurrentUrl();
		 Assert.assertEquals(expectedPage, actualPage,ExcelUtility.getString(7, 2, System.getProperty("user.dir") +"Constants.Constants.TESTDATAFILE","Sheet1"));
	    }
	 
	 public void VerifyNavigateToClientPage() throws IOException {
		 String expectedPage = ExcelUtility.getString(7, 3, System.getProperty("user.dir") +"Constants.Constants.TESTDATAFILE","Sheet1");
		 PageUtility.clickOnElement(clientMoreInfo);
		 String actualPage = driver.getCurrentUrl();
		 Assert.assertEquals(expectedPage, actualPage,ExcelUtility.getString(7, 2, System.getProperty("user.dir") +"Constants.Constants.TESTDATAFILE","Sheet1"));
	    }
	 
	 public void verifyNavigateToReparationPage() throws IOException {
		 String expectedPage = ExcelUtility.getString(7, 4, System.getProperty("user.dir") +"Constants.Constants.TESTDATAFILE","Sheet1");
		 PageUtility.clickOnElement(reperationMoreInfoIcon);
		 String actualPage = driver.getCurrentUrl();
		 Assert.assertEquals(expectedPage, actualPage,ExcelUtility.getString(7, 2, System.getProperty("user.dir") +"Constants.Constants.TESTDATAFILE","Sheet1"));
	    }
	 public void VerifyNavigateToQualityAlert() throws IOException, InterruptedException {
		 String actualMsg, expectedMsg = ExcelUtility.getString(7, 5, System.getProperty("user.dir") +"Constants.Constants.TESTDATAFILE","Sheet1"); 
		 WaitUtility.waitForElementClickable(driver, qualityAlertIcon);
		 PageUtility.clickOnElement(qualityAlertIcon);
		 boolean qualityAlertNavigationaIconisEnabled = qualityAlertNavigationaIcon.isEnabled();
		 Assert.assertTrue(qualityAlertNavigationaIconisEnabled);
		 WaitUtility.waitForElementClickable(driver, qualityAlertNavigationaIcon);
		 PageUtility.clickOnElement(qualityAlertNavigationaIcon);
		 WaitUtility.waitForElementClickable(driver, qualityAlertNavigationaIcon);
		 for(WebElement row:rowList) {
		 actualMsg =row.getText();
		 boolean compareElement = actualMsg.contentEquals(expectedMsg);
		 Assert.assertTrue(compareElement,"actual and expected message contents are not same");			
		 Assert.assertEquals(actualMsg, expectedMsg,"content not equals");
		 break;
		 }	 
	    }
      

}
