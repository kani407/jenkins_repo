package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class FormSubmitPage  {
		public  WebDriver driver;
		public FormSubmitPage(WebDriver driver) {
			this.driver=driver;
		}
		String actualMessage,expectedMessage="Form has been submitted successfully!";
		By firstName=By.xpath("//input[@id='validationCustom01']");
		By lastName=By.xpath("//input[@id='validationCustom02']");
		By userName=By.xpath("//input[@id='validationCustomUsername']");
		By cityName=By.xpath("//input[@id='validationCustom03']");
		By stateName=By.xpath("//input[@id='validationCustom04']");
		By zipCode=By.xpath("//input[@id='validationCustom05']");
		By agreeTermsAndConditions=By.xpath("//input[@id='invalidCheck']");
		By submitFormButon=By.xpath("//button[@class='btn btn-primary']");
		By ShowMsg=By.xpath("//div[@id='message-one']");
		
	public void FirstPersonDetails(String firstName1,String lastName1,String userName1,String cityName1,String  stateName1,String zipCode1) {
		driver.navigate().to("https://selenium.obsqurazone.com/form-submit.php");
		driver.findElement(firstName).sendKeys(firstName1);
		driver.findElement(lastName).sendKeys(lastName1);
		driver.findElement(userName).sendKeys(userName1);
		driver.findElement(cityName).sendKeys(cityName1);
		driver.findElement(stateName).sendKeys(stateName1);
		driver.findElement(zipCode).sendKeys(zipCode1);
		driver.findElement(agreeTermsAndConditions).click();
		driver.findElement(submitFormButon).click();
		driver.findElement(ShowMsg).getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Message Not Equals");
	}
	public void SecondPersonDetails(String firstName2,String lastName2,String userName2,String cityName2,String  stateName2,String zipCode2) {
		driver.navigate().to("https://selenium.obsqurazone.com/form-submit.php");
		driver.findElement(firstName).sendKeys(firstName2);
		driver.findElement(lastName).sendKeys(lastName2);
		driver.findElement(userName).sendKeys(userName2);
		driver.findElement(cityName).sendKeys(cityName2);
		driver.findElement(stateName).sendKeys(stateName2);
		driver.findElement(zipCode).sendKeys(zipCode2);
		driver.findElement(agreeTermsAndConditions).click();
		driver.findElement(submitFormButon).click();
		driver.findElement(ShowMsg).getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Message Not Equals");
	}
	public void ThirdPersonDetails(String firstName3,String lastName3,String userName3,String cityName3,String  stateName3,String zipCode3) {
		driver.navigate().to("https://selenium.obsqurazone.com/form-submit.php");
		driver.findElement(firstName).sendKeys(firstName3);
		driver.findElement(lastName).sendKeys(lastName3);
		driver.findElement(userName).sendKeys(userName3);
		driver.findElement(cityName).sendKeys(cityName3);
		driver.findElement(stateName).sendKeys(stateName3);
		driver.findElement(zipCode).sendKeys(zipCode3);
		driver.findElement(agreeTermsAndConditions).click();
		driver.findElement(submitFormButon).click();
		driver.findElement(ShowMsg).getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Message Not Equals");
	}
	public void FourthPersonDetails(String firstName4,String lastName4,String userName4,String cityName4,String  stateName4,String zipCode4) {
		driver.navigate().to("https://selenium.obsqurazone.com/form-submit.php");
		driver.findElement(firstName).sendKeys(firstName4);
		driver.findElement(lastName).sendKeys(lastName4);
		driver.findElement(userName).sendKeys(userName4);
		driver.findElement(cityName).sendKeys(cityName4);
		driver.findElement(stateName).sendKeys(stateName4);
		driver.findElement(zipCode).sendKeys(zipCode4);
		driver.findElement(agreeTermsAndConditions).click();
		driver.findElement(submitFormButon).click();
		driver.findElement(ShowMsg).getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Message Not Equals");
	}
	public void FifthPersonDetails(String firstName5,String lastName5,String userName5,String cityName5,String  stateName5,String zipCode5) {
		driver.navigate().to("https://selenium.obsqurazone.com/form-submit.php");
		driver.findElement(firstName).sendKeys(firstName5);
		driver.findElement(lastName).sendKeys(lastName5);
		driver.findElement(userName).sendKeys(userName5);
		driver.findElement(cityName).sendKeys(cityName5);
		driver.findElement(stateName).sendKeys(stateName5);
		driver.findElement(zipCode).sendKeys(zipCode5);
		driver.findElement(agreeTermsAndConditions).click();
		driver.findElement(submitFormButon).click();
		driver.findElement(ShowMsg).getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Message Not Equals");
	}
	
	}
