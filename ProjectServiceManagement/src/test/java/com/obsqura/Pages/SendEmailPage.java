package com.obsqura.Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class SendEmailPage {
	public WebDriver driver;
	public SendEmailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//i[@class='fa fa-plus-circle']")
	private WebElement plusCircle;
	
	@FindBy(xpath="//span[@class='fa fa-paper-plane icon']")
	private WebElement sendEmailIcon;
	
	@FindBy(xpath="//select[@name='email_to[]']")
	private WebElement selectNameToSendEmail;
	
	@FindBy(xpath="//input[@id='subject']")
	private WebElement emailSubject;
	
	@FindBy(xpath="//textarea[@id='sms_body']")
	private WebElement emailTextArea;
	
	@FindBy(xpath="(//button[text()='Send'])[2]")
	private WebElement sendEmailButton;
	
	@FindBy(xpath="(//button[text()='Close'])[2]")
	private WebElement closeEmailButton;
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement popupfieldcantempty;
	
	public void clickSendemail() throws IOException, InterruptedException {
		String mailSubject=ExcelUtility.getString(3, 1,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String mailContent=ExcelUtility.getString(3, 2,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		PageUtility.clickOnElement(plusCircle);
		PageUtility.clickOnElement(sendEmailIcon);
		PageUtility.selectDropdownbyIndex(selectNameToSendEmail, 9);
		PageUtility.enterText(emailSubject, mailSubject);
		PageUtility.enterText(emailTextArea, mailContent);
		PageUtility.isElementDisplayed(sendEmailButton);
		PageUtility.clickOnElement(sendEmailButton);
		Thread.sleep(1000);
		PageUtility.isElementDisplayed(closeEmailButton);
		PageUtility.clickOnElement(closeEmailButton);
		
	}
	public void clicksendMailWithoutSubject() throws IOException, InterruptedException {
		String mailContent=ExcelUtility.getString(3, 2,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String actualMsg, expectedMsg=ExcelUtility.getString(3, 3,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		PageUtility.clickOnElement(plusCircle);
		PageUtility.clickOnElement(sendEmailIcon);
		PageUtility.selectDropdownbyIndex(selectNameToSendEmail, 9);
		PageUtility.enterText(emailTextArea, mailContent);
		PageUtility.isElementDisplayed(sendEmailButton);
		PageUtility.clickOnElement(sendEmailButton);
		Thread.sleep(1000);
		actualMsg=PageUtility.getElementText(popupfieldcantempty);
		Thread.sleep(1000);
		PageUtility.isElementDisplayed(closeEmailButton);
		PageUtility.clickOnElement(closeEmailButton);
		Assert.assertEquals(expectedMsg, actualMsg, "Message is not matched");
	}
	public void clicksendMailWithoutmailContent() throws IOException, InterruptedException {
		String mailSubject=ExcelUtility.getString(3, 1,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		String expectedMsg=ExcelUtility.getString(3, 3,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");
		PageUtility.clickOnElement(plusCircle);
		PageUtility.clickOnElement(sendEmailIcon);
		PageUtility.selectDropdownbyIndex(selectNameToSendEmail, 9);
		emailSubject.sendKeys(mailSubject);
		PageUtility.isElementDisplayed(sendEmailButton);
		PageUtility.clickOnElement(sendEmailButton);
		Thread.sleep(1000);
		String actualMsg=PageUtility.getElementText(popupfieldcantempty);
		Thread.sleep(1000);
		PageUtility.isElementDisplayed(closeEmailButton);
		PageUtility.clickOnElement(closeEmailButton);
		Assert.assertEquals(expectedMsg, actualMsg, "Message is not matched");
	}
	
}
