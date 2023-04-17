package com.obsqura.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.obsqura.utilities.WaitUtility;

public class CheckBoxDemoPage {
	public  WebDriver driver;
	public CheckBoxDemoPage(WebDriver driver) {
		this.driver=driver;
	}
		By clickSingleCheckBox=By.xpath("//input[@id='gridCheck']");
		By successClickMessage=By.xpath("//div[@id='message-one']");
		By mCheckBox1=By.xpath("//input[@id='check-box-one']");
		By mCheckBox2=By.xpath("//input[@id='check-box-two']");
		By mCheckBox3=By.xpath("//input[@id='check-box-three']");
		By mCheckBox4=By.xpath("//input[@id='check-box-four']");
		By selectAllButton=By.xpath("//input[@id='button-two']");
		
		
	public void singleCheckBox() {
		String actualMessage,expectedMessage="Success - Check box is checked";
		boolean isSelectedclickSingleCheckBox;
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(30))
		        .pollingEvery(Duration.ofSeconds(5))
		        .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(clickSingleCheckBox));
		driver.findElement(clickSingleCheckBox).click();
		isSelectedclickSingleCheckBox=driver.findElement(clickSingleCheckBox).isSelected();
		if(isSelectedclickSingleCheckBox) {
			actualMessage=driver.findElement(successClickMessage).getText();
			Assert.assertEquals(actualMessage, expectedMessage);
		}		
	}
	public void multipleCheckBox() {
		boolean box1,box2,box3,box4;
		WebElement button;
		String actualButtonVale,expectedButtonValue="Unselect All";
		//driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		WaitUtility.elementToBeClickableByLocator(driver, selectAllButton);
		driver.findElement(selectAllButton).click();
		SoftAssert softAssert=new SoftAssert();
		box1=driver.findElement(mCheckBox1).isSelected();
		box2=driver.findElement(mCheckBox2).isSelected();
		box3=driver.findElement(mCheckBox3).isSelected();
		box4=driver.findElement(mCheckBox4).isSelected();
		softAssert.assertTrue(box1,"Button is checked");
		softAssert.assertTrue(box2,"Button is checked");
		softAssert.assertTrue(box3,"Button is checked");
		softAssert.assertTrue(box4,"Button is checked");
		softAssert.assertAll();	
		button=driver.findElement(selectAllButton);
		actualButtonVale=button.getAttribute("value");		
		Assert.assertEquals(actualButtonVale, expectedButtonValue, "Select All is showing");
	}
}
