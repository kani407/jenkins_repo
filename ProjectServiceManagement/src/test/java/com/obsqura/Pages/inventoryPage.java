package com.obsqura.Pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.FakerUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class inventoryPage {
	WebDriver driver;
	public inventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	    @FindBy(xpath="//a[@ href='https://qalegend.com/mobile_service/panel/inventory']")
	    private WebElement inventoryProductMoreInfoOption;
	    
	    @FindBy(xpath="//i[@class='icon fa fa-tasks tip']")
	    private WebElement actionsIcon;
	    
	    @FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/inventory/add']")
	    private WebElement addProduct;
	    
	    @FindBy(xpath="//span[@class='select2-results']//li")
	    private List<WebElement> productType;
	    
	    @FindBy(xpath="//input[@id='name']")
	    private WebElement productName;
	    
	    @FindBy(xpath="//i[@class='fa fa-random']")
	    private WebElement productCode;
	    
	    @FindBy(xpath="//select[@id='category']")
	    private WebElement category;
	    
	    @FindBy(xpath="//input[@id='alert_quantity']")
	    private WebElement alertQuantity;
	    
	    @FindBy(xpath="//input[@id='quantity']")
	    private WebElement productQuality;
	    
	    @FindBy(xpath="//select[@id='supplier']")
	    private WebElement productSupplier;
	    
	    @FindBy(xpath="//input[@id='unit']")
	    private WebElement productUnit;
	    
	    @FindBy(xpath="//input[@id='cost']")
	    private WebElement productCost;
	  
	    @FindBy(xpath="//input[@id='price']")
	    private WebElement productPrice;
	       
	    @FindBy(xpath="//select[@id='model']")
	    private WebElement productModel;
	    
	    @FindBy(xpath="//input[@id='product_image']")
	    private WebElement productImage;
	    
	    @FindBy(xpath="//textarea[@id='details']")
	    private WebElement productDetails;
	    
	    @FindBy(xpath="//input[@class='btn btn-primary']")
	    private WebElement submit;
	    
	    @FindBy(xpath="//tr[@class='product_link']")
	    private List<WebElement> rowNumber;
	    
	    @FindBy(xpath="//button[@class='btn btn-default btn-xs btn-primary dropdown-toggle']")
		private WebElement blueActionButton;
	    
	    @FindBy(xpath ="//a[@class='tip btn btn-danger bpo'] ")
	    private WebElement delectButton;
	    
	    @FindBy(xpath ="//a[@class='btn btn-danger']")
	    private WebElement delectConformation;
	    
	    @FindBy(xpath ="//section[@class='content-header']")
	    private WebElement homeHeader;
	      
	    @FindBy(xpath ="//input[@class='form-control input-sm input-xs']")
	    private WebElement searchButton;
	    
	    @FindBy(xpath ="//tr[@class='product_link']")
	    private List<WebElement> rowCount;
	    
	    @FindBy(xpath ="//div[@class='alert alert-success']")
	    private WebElement sucessMsg;
	    
	    @FindBy(xpath ="//a[text()='Next > ']")
	    private WebElement nextButton;
	    
	    @FindBy(xpath ="//div[@id='PRData_info']")
	    private WebElement entryMsg;
	    
	    @FindBy(xpath ="//a[@class='tip btn btn-warning tip']")
	    private WebElement editOption;
	    
	    @FindBy(xpath ="//input[@class='btn btn-primary']")
	    private WebElement editProductButton;
	    
	    @FindBy(xpath ="//div[@class='alert alert-success']")
	    private WebElement editUpdateMsg;
	    
	    @FindBy(xpath ="//select[@class='form-control input-sm select input-xs']")
	    private WebElement showButton;
	    
	    @FindBy(xpath ="//ul[@class='pagination pagination-sm']//li")
	    private List<WebElement> nextPageNum;
	       
	    public void addInventoryProduct() throws IOException { 	
	    	String type = ExcelUtility.getString(6, 1, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	String name = ExcelUtility.getString(6, 2, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	String catg = ExcelUtility.getNumeric(6, 3, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	String path = ExcelUtility.getString(6, 4, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	String img = ExcelUtility.getString(1, 12,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	        String model= ExcelUtility.getNumeric(6, 5, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	        String quality= ExcelUtility.getNumeric(6, 6, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	        String supplier = ExcelUtility.getString(6, 7, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	        String unit= ExcelUtility.getNumeric(6, 8, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	        String cost = ExcelUtility.getNumeric(6, 9, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	        String price= ExcelUtility.getNumeric(6, 10, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	        String actualMsg, expectedMsg = ExcelUtility.getString(6, 11, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	    	PageUtility.clickOnElement(actionsIcon);
	    	WaitUtility.waitForElementClickable(driver, addProduct);
	    	PageUtility.clickOnElement(addProduct);
	    	PageUtility.selectElementFromListUsingGetText(productType, type);
	    	PageUtility.enterText(productName, name);
	    	PageUtility.clickOnElement(productCode);
	    	PageUtility.selectDropdownbyIndex(category, 1);
	    	PageUtility.selectDropdownbyText(productModel, path);
	    	PageUtility.enterText(alertQuantity, unit);
	    	PageUtility.enterText(productQuality,quality);
	    	PageUtility.selectDropdownbyText(productSupplier, supplier);
	    	PageUtility.enterText(productUnit, unit);
	    	PageUtility.enterText(productCost, cost);
	    	PageUtility.enterText(productPrice, price);
	    	PageUtility.enterText(productImage, img);
	    	PageUtility.enterText(productDetails, type);
	    	WaitUtility.waitForElementClickable(driver, submit);
	    	PageUtility.clickOnElement(submit);
	    	actualMsg=sucessMsg.getText();
	    	actualMsg =  PageUtility.getElementText(sucessMsg);
	    	Assert.assertEquals(actualMsg, expectedMsg,ExcelUtility.getString(6,20, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1"));
	       }   
	    
	    public void delectInventoryVerification() throws IOException, InterruptedException {
	    	String attribute = ExcelUtility.getString(6, 12, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	String attributeValue = ExcelUtility.getNumeric(6, 13, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	String actualMsg, expectedMsg = ExcelUtility.getString(6,14, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	    	WaitUtility.waitForElementClickable(driver, inventoryProductMoreInfoOption);
	    	PageUtility.selectElementFromListUsingGetAttribute(rowNumber, attribute, attributeValue);
	    	WaitUtility.waitForElementClickable(driver, delectButton);
	    	PageUtility.clickOnElement(delectButton);
	    	WaitUtility.waitForElementClickable(driver, delectConformation);
	    	PageUtility.clickOnElement(delectConformation);
	    	WaitUtility.waitForElement(driver, homeHeader);
	    	boolean backToHomePage = PageUtility.isElementDisplayed(homeHeader);
	    	Assert.assertTrue(backToHomePage,"doesn't navigate to home page after delecting item");  
	    	actualMsg = PageUtility.getElementText(homeHeader);
	    	Assert.assertEquals(actualMsg, expectedMsg,ExcelUtility.getString(6,21, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1"));
	       }
	    
	    public void navigateToNextPageOnClickingNextOptionVerification() throws IOException, InterruptedException {
	        String actualText,expectedNum = ExcelUtility.getNumeric(6, 15, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	String showButtonNum = ExcelUtility.getNumeric(6, 16, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1"); 
	    	String pageNum = ExcelUtility.getNumeric(6, 17, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	WaitUtility.waitForElement(driver, inventoryProductMoreInfoOption);
	    	PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	    	WaitUtility.waitForElementClickable(driver, showButton);
	    	PageUtility.selectDropdownbyValue(showButton,showButtonNum);
	    	PageUtility.ScrollBy(driver);
	    	boolean isnextButtonDisplayed = nextButton.isDisplayed();
	    	Assert.assertTrue(isnextButtonDisplayed,ExcelUtility.getString(6,22, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1"));
	    	WaitUtility.waitForElement(driver, nextButton);
	    	PageUtility.clickOnElement(nextButton);
	    	WaitUtility.waitForElement(driver, nextButton);
	    	for(WebElement menu:nextPageNum) {
			actualText=menu.getText();
			if(actualText.contentEquals(pageNum)) {
			Assert.assertEquals(actualText, expectedNum);
				break;
			  } 
			}
	    }
	    public void EditInventoryProductVerification() throws IOException {
	    	String attribute = ExcelUtility.getString(6, 18, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	    	String attributeValue = ExcelUtility.getNumeric(6, 19, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
	        String actualMsg,actualAlertMsg,expectedAlertMsg;
	        boolean compareElement;
	    	PageUtility.clickOnElement(inventoryProductMoreInfoOption);
	    	PageUtility.clickOnElement(actionsIcon);
	    	for(WebElement row:rowNumber) {
				actualMsg =row.getAttribute(attribute);
				compareElement = actualMsg.contentEquals(attributeValue);
				if(compareElement) {
			    row.click();
			    break;
				}
			PageUtility.clickOnElement(editOption);
			PageUtility.clickOnElement(editProductButton);
			actualAlertMsg = editUpdateMsg.getText();
			expectedAlertMsg = ExcelUtility.getString(6,23, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
			Assert.assertEquals(actualAlertMsg, expectedAlertMsg,ExcelUtility.getString(6,23, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1"));	
	    }
	    	
	    }
	    
}
