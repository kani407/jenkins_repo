package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.obsqura.utilities.WaitUtility;

public class RadioButtonDemoPage {
	WebDriver driver;
	public RadioButtonDemoPage(WebDriver driver) {
		this.driver=driver;
	}

	By maleRadioButton=By.xpath("//input[@id='inlineRadio1']");
	By femaleRadioButton=By.xpath("//input[@id='inlineRadio2']");
	By showSelectedValue=By.xpath("//button[text()='Show Selected Value']");
	By ShowMessage=By.xpath("//div[@id='message-one']");
	By patientGenderMale=By.xpath("//input[@id='inlineRadio11']");
	By patientGenderFemale=By.xpath("//input[@id='inlineRadio21']");
	By patientAgeGroup1To18=By.xpath("//input[@id='inlineRadio22']");
	By patientAgeGroup19To44=By.xpath("//input[@id='inlineRadio23']");
	By patientAgeGroup45To60=By.xpath("//input[@id='inlineRadio24']");
	By getResultButton=By.xpath("//button[text()='Get Results']");
	By result=By.xpath("//div[@id='message-two']");
	public void singleRadioBuitton() {
		boolean isMaleRadioButtonSelected;
		String actualMsg,expectedMsg="Radio button 'Male' is checked";
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.findElement(maleRadioButton).click();		
		isMaleRadioButtonSelected=driver.findElement(maleRadioButton).isSelected();
		if(isMaleRadioButtonSelected) {
			WaitUtility.elementToBeClickableByLocator(driver, showSelectedValue);
			driver.findElement(showSelectedValue).click();	
			actualMsg=driver.findElement(ShowMessage).getText();
			Assert.assertEquals(actualMsg, expectedMsg, "Both Messages are not equal");
		}	
	}
	public void groupRadioButton() {
		String actualMsg,ExpectedMsg="Gender : Female\n Age group: 19 to 44";
		boolean isGenderSelected,isAgeSelected;
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.findElement(patientGenderFemale).click();
		driver.findElement(patientAgeGroup19To44).click();
		isGenderSelected=driver.findElement(patientGenderFemale).isSelected();
		isAgeSelected=driver.findElement(patientAgeGroup19To44).isSelected();
		if(isGenderSelected&&isAgeSelected) {
			WaitUtility.elementToBeClickableByLocator(driver, getResultButton);
			driver.findElement(getResultButton).click();
			actualMsg=driver.findElement(result).getText();
			Assert.assertEquals(actualMsg, ExpectedMsg, "Both Messages are not equal");
		}
		Assert.assertTrue(isGenderSelected);
		Assert.assertTrue(isAgeSelected);
	}

}
