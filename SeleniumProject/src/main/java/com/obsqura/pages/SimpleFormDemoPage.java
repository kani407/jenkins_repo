package com.obsqura.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.obsqura.SeleniumProject.Base;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.WaitUtility;

import org.testng.Assert;

public class SimpleFormDemoPage{
	public WebDriver driver;
	public SimpleFormDemoPage(WebDriver driver) {
		this.driver=driver;
	}

	By singleInputField=By.xpath("//input[@id='single-input-field']");
	By showMessageButton=By.xpath("//button[@id='button-one']");
	By yourMessage=By.xpath("//div[@id='message-one']");
	By enterValueA=By.xpath("//input[@id='value-a']");
	By enterValueB=By.xpath("//input[@id='value-b']");
	By getTotalButton=By.xpath("//button[@id='button-two']");
	By totalResult=By.xpath("//div[@id='message-two']");
	
	
	public void verifyEnterMessageField() throws IOException {
		String yourEnteredActualMessage;
	/*	Faker faker = new Faker();
		String firstName=faker.name().firstName();*/
		String inputMsg=ExcelUtility.getString(0, 0,System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\testData.xlsx","Sheet1");
		String expectedMessage =ExcelUtility.getString(0,1,System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\testData.xlsx","Sheet1")+inputMsg;
		driver.findElement(singleInputField).sendKeys(inputMsg);
		WaitUtility.elementToBeClickableByLocator(driver, showMessageButton);
		driver.findElement(showMessageButton).click();
		yourEnteredActualMessage=driver.findElement(yourMessage).getText();
		Assert.assertEquals(yourEnteredActualMessage, expectedMessage);
	}
	public void twoInputFieldVerification() throws IOException {
		String actualResult,expectedResult,s,t,getTotal;
		int valueA,valueB,total;
		 s=(ExcelUtility.getNumeric(1, 0,System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\testData.xlsx","Sheet1"));
		 t=(ExcelUtility.getNumeric(1, 1,System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\testData.xlsx","Sheet1"));
		valueA=Integer.parseInt(s);
		valueB=Integer.parseInt(t);
		total=valueA+valueB;
		getTotal=Integer.toString(total);
		expectedResult=ExcelUtility.getString(0,2,System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\testData.xlsx","Sheet1")+getTotal;
		driver.findElement(enterValueA).sendKeys(s);
		driver.findElement(enterValueB).sendKeys(t);
		WaitUtility.elementToBeClickableByLocator(driver, getTotalButton);
		driver.findElement(getTotalButton).click();
		actualResult=driver.findElement(totalResult).getText();
		Assert.assertEquals(actualResult, expectedResult);
	}

}
