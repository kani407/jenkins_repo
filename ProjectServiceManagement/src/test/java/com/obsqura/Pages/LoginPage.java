package com.obsqura.Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.FakerUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class LoginPage  {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//input[@id='identity']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passWord;
	
	@FindBy(xpath="//ins[@class='iCheck-helper']")
	private WebElement rememberMeCheckBox;
	
	@FindBy(xpath="//input[@class='btn btn-primary btn-block btn-flat']")
	private WebElement loginButton;
	
	@FindBy(xpath="//p[text()='Logged In Successfully']")
	private WebElement alertMessage;
	
	@FindBy(xpath="(//span[@class='hidden-xs'])[1]")
	private WebElement joejacobLogout;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-flat']")
	private WebElement signoutButton;
	
	@FindBy(xpath="//p[text()='Logged Out Successfully']")
	private WebElement logoutsuccess;
	
	@FindBy(xpath="//p[@class='login-box-msg']")
	private WebElement startSignin;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service//panel/login/forgot_password']")
	 private WebElement forgotPassword;
	 
	 @FindBy(xpath="//input[@id = 'identity']")
	 private WebElement resetEmail;
	 
	 @FindBy(xpath="//input[@class='btn btn-primary btn-block btn-flat']")
	 private WebElement resetEmailSubmitButton;
	  
	 @FindBy(xpath="//div[@id ='infoMessage']")
	 private WebElement infoMsg;
	 
	 @FindBy(xpath="//a[text()=' ← Back to login!']")
	 private WebElement backToLoginOption;
	 
	 @FindBy(xpath="//div[@id ='infoMessage']")
	 private WebElement signoutMsg;
	
	public void accountLogin() throws IOException {
		String username=ExcelUtility.getString(0, 1,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String password=ExcelUtility.getString(0, 2,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String actualMessage, expectedMsg=ExcelUtility.getString(0, 3,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		PageUtility.enterText(userName, username);
		PageUtility.enterText(passWord, password);	
		boolean isSelectedrememberMeCheckBox;
		PageUtility.clickOnElement(rememberMeCheckBox);
		PageUtility.isElementDisplayed(loginButton);
		PageUtility.clickOnElement(loginButton);
		actualMessage=PageUtility.getElementText(alertMessage);
		Assert.assertEquals(actualMessage, expectedMsg, "Not logged in");
	}
	public void loginWithWrongPassword() throws IOException {
		String username=ExcelUtility.getString(0, 1,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String wrongPassword=ExcelUtility.getString(0, 4,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String expectedMsg=ExcelUtility.getString(0, 6,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String actualMessage;
		PageUtility.enterText(userName, username);
		PageUtility.enterText(passWord, wrongPassword);
		boolean isSelectedrememberMeCheckBox;
		PageUtility.clickOnElement(rememberMeCheckBox);
		PageUtility.isElementDisplayed(loginButton);
		PageUtility.clickOnElement(loginButton);
		actualMessage=PageUtility.getElementText(startSignin);
		Assert.assertEquals(actualMessage, expectedMsg, "Not logged in");
	}
	public void loginWithWrongUserName() throws IOException {
		String username=ExcelUtility.getString(0, 3,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String password=ExcelUtility.getString(0, 2,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String expectedMsg=ExcelUtility.getString(0, 6,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String actualMessage;
		PageUtility.enterText(userName, username);
		PageUtility.enterText(passWord, password);
		boolean isSelectedrememberMeCheckBox;
		PageUtility.clickOnElement(rememberMeCheckBox);
		PageUtility.isElementDisplayed(loginButton);
		PageUtility.clickOnElement(loginButton);
		actualMessage=PageUtility.getElementText(startSignin);
		Assert.assertEquals(actualMessage, expectedMsg, "Not logged in");
	}
	
	public void logOut() throws IOException {
		String expectedMessage=ExcelUtility.getString(0, 5,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		PageUtility.clickOnElement(joejacobLogout);
		PageUtility.isElementDisplayed(signoutButton);
		PageUtility.clickOnElement(signoutButton);
		String actualMessage=PageUtility.getElementText(logoutsuccess);
		Assert.assertEquals(actualMessage, expectedMessage, "Message is not matched");		
	}
	 public void verifyForgotPassword() throws IOException {
		  String actualMsg,expectedMsg=ExcelUtility.getString(0, 7, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  String email = ExcelUtility.getString(0, 8, System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		  boolean isforgotPasswordOptionAvailable = PageUtility.isElementDisplayed(forgotPassword);
		  Assert.assertTrue(isforgotPasswordOptionAvailable,"forgot password option is not available");
		  PageUtility.clickOnElement(forgotPassword);
		  PageUtility.enterText(resetEmail,email);
		  PageUtility.clickOnElement(resetEmailSubmitButton);
		  actualMsg = PageUtility.getElementText(infoMsg);
		  Assert.assertEquals(actualMsg, expectedMsg);
	      }

}
