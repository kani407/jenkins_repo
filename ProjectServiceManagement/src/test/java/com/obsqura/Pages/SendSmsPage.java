package com.obsqura.Pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;

public class SendSmsPage {
	public WebDriver driver;
	public SendSmsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//i[@class='fa fa-plus-circle']")
	private WebElement plusCircle;
	
	@FindBy(xpath="//span[@class='fa fa-comment icon']")
	private WebElement sendSmsIcon;
	
	@FindBy(xpath="//select[@id='client_id_sms']")
	private WebElement clientNameDropDown;
	
	@FindBy(xpath="(//textarea[@placeholder='Message'])[2]")
	private WebElement sendSmsMessageField;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[2]")
	private WebElement sendSmsButton;
	
	@FindBy(xpath="(//button[@class='btn btn-secondary'])[1]")
	private WebElement closeButtonSendSms;
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement popupMsg;
	
	@FindBy(xpath="//input[@id='phone_number']")
	private WebElement phoneNum;

	@FindBy(xpath="//li[@class='parsley-required']")
	private WebElement fieldnotbeEmpty;
	
	@FindBy(xpath="//li[@class='parsley-required']")
	private WebElement numberFieldNotBeEmpty;
	
	@FindBy(xpath="(//textarea[@id='fastsms'])[1]")
	private WebElement textArea;
	
	@FindBy(xpath="(//button[@class='pull-right btn btn-default'])[2]")
	private WebElement submitButton;
	
	public void sendsms() throws IOException, InterruptedException {
		String messageContent=ExcelUtility.getString(2, 1,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String actualMessage, expectedMsg=ExcelUtility.getString(2, 2,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		PageUtility.clickOnElement(plusCircle);
		PageUtility.clickOnElement(sendSmsIcon);
		PageUtility.selectDropdownbyIndex(clientNameDropDown, 5);
		PageUtility.enterText(sendSmsMessageField, messageContent);
		PageUtility.isElementDisplayed(sendSmsButton);
		PageUtility.clickOnElement(sendSmsButton);
		Thread.sleep(1000);
		actualMessage=PageUtility.getElementText(popupMsg);
		Thread.sleep(1000);
		PageUtility.isElementDisplayed(closeButtonSendSms);
		PageUtility.clickOnElement(closeButtonSendSms);
		Assert.assertEquals(actualMessage, expectedMsg, "Message not sent");
	}
	public void sendsmsWithoutSubject() throws IOException, InterruptedException {
		PageUtility.ScrollBy(driver);
		String phonenum=ExcelUtility.getNumeric(2, 3,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String actualMessage, expectedMsg=ExcelUtility.getString(2, 4,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		phoneNum.isEnabled();
		PageUtility.enterText(phoneNum, phonenum);
		PageUtility.clickOnElement(submitButton);
		Thread.sleep(1000);
		actualMessage=PageUtility.getElementText(fieldnotbeEmpty);
		Thread.sleep(1000);
		Assert.assertEquals(actualMessage, expectedMsg, "Message not sent");
	}
	public void sendsmsWithoutNumber() throws IOException, InterruptedException {
		PageUtility.ScrollBy(driver);
		String messageContent=ExcelUtility.getString(2, 1,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String actualMessage, expectedMsg=ExcelUtility.getString(2, 4,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		PageUtility.enterText(textArea, messageContent);
		PageUtility.isElementDisplayed(submitButton);
		PageUtility.clickOnElement(submitButton);
		Thread.sleep(1000);
		actualMessage=numberFieldNotBeEmpty.getText();
		Thread.sleep(1000);
		Assert.assertEquals(actualMessage, expectedMsg, "Message not sent");
	}
	}

