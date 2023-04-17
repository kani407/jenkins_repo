package com.obsqura.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.FakerUtility;
import com.obsqura.utilities.PageUtility;

public class PlusCirclePage {
	public WebDriver driver;
	public PlusCirclePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	
	
	@FindBy(xpath="//li[@class='dropdown hidden-sm']")
	private WebElement quantityAlerts;
	
	@FindBy(xpath="//i[@class='fa fa-plus-circle']")
	private WebElement plusCircle;
	
	@FindBy(xpath="//span[@class='fa fa-user-plus icon']")
	private WebElement addClient;
	
	@FindBy(xpath="//a[@class='add_reparation']")
	private WebElement addReparation;
	
	@FindBy(xpath="//span[@class='fa fa-comment icon']")
	private WebElement sendSms;
	
	@FindBy(xpath="//span[@class='fa fa-paper-plane icon']")
	private WebElement sendEmail;
	
	@FindBy(xpath="//input[@id='name1']")
	private WebElement clientName;
	
	@FindBy(xpath="//input[@id='company1']")
	private WebElement companyName;
	
	@FindBy(xpath="//input[@id='autocomplete']")
	private WebElement geoLocation;
	
	@FindBy(xpath="//input[@id='route']")
	private WebElement address;
	
	@FindBy(xpath="//input[@id='locality']")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='postal_code']")
	private WebElement postalCode;
	
	@FindBy(xpath="//input[@id='telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='email1']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='vat1']")
	private WebElement vat;
	
	@FindBy(xpath="//input[@id='cf1']")
	private WebElement ssn;
	
	@FindBy(xpath="//input[@id='image']")
	private WebElement selectFileBrowseButton;
	
	@FindBy(xpath="//textarea[@id='comment1']")
	private WebElement commentArea;
	
	@FindBy(xpath="//button[text()=' Go Back']")
	private WebElement goBackButton;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement addClientSubmitButton;
	
	@FindBy(xpath="//div[@class='toast-tittle']")
	private WebElement toastMsg;
	
	@FindBy(xpath="/html/body/div[11]/div/div[2]/span")
	private WebElement LocationPopupAlert;
	
	@FindBy(xpath="//button[@class='dismissButton']")
	private WebElement okButtonForLocationPopup;
	
	public void clickPlusCircle() throws IOException {
		PageUtility.clickOnElement(plusCircle);
		PageUtility.clickOnElement(addClient);

		String clientname=ExcelUtility.getString(1, 1,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String companyname =ExcelUtility.getString(1, 2,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String location=ExcelUtility.getString(1, 3,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String addrs=ExcelUtility.getString(1, 4,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String cityname=ExcelUtility.getString(1, 5,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String postnum=ExcelUtility.getNumeric(1, 6,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String phonenum=ExcelUtility.getNumeric(1, 7,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String mailid=ExcelUtility.getString(1, 8,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String valueTax=ExcelUtility.getNumeric(1, 9,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String ssnumber=ExcelUtility.getNumeric(1, 10,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String comment=ExcelUtility.getString(1, 11,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String img=ExcelUtility.getString(1, 12,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String mapPopUp=ExcelUtility.getString(1, 13,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
				
		PageUtility.enterText(clientName, clientname);
		PageUtility.enterText(companyName, companyname);
		PageUtility.enterText(geoLocation, location);
		PageUtility.clickOnElement(okButtonForLocationPopup);
		PageUtility.enterText(address, addrs);
		PageUtility.enterText(city, cityname);
		PageUtility.enterText(postalCode, postnum);
		PageUtility.enterText(telephone, phonenum);
		PageUtility.enterText(email, mailid);
		PageUtility.enterText(vat, valueTax);
		PageUtility.enterText(ssn, ssnumber);
		PageUtility.enterText(selectFileBrowseButton, img);
		PageUtility.enterText(commentArea, comment);
		PageUtility.clickOnElement(addClientSubmitButton);
		}	
	public void verifyGeoLocationPopUp() throws IOException {
		String clientneme=FakerUtility.clientName();
		String companyname=ExcelUtility.getString(1, 2,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String actualMsg, expectedMsg=ExcelUtility.getString(1, 13,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String location=ExcelUtility.getString(1, 3,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		PageUtility.clickOnElement(plusCircle);
		PageUtility.clickOnElement(addClient);
		PageUtility.enterText(clientName, clientneme);
		PageUtility.enterText(companyName, companyname);
		PageUtility.enterText(geoLocation, location);
		actualMsg=PageUtility.getElementText(LocationPopupAlert);
		PageUtility.clickOnElement(okButtonForLocationPopup);
		Assert.assertEquals(expectedMsg, actualMsg, "Geo_location is not required");	
	}
	
}