package com.obsqura.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.obsqura.SeleniumProject.Base;
public class HeaderPage extends Base {
	public HeaderPage(WebDriver driver) {
		
			this.driver = driver;
	
	}
	By collapseNavBar = By.xpath("//ul[@class='navbar-nav']//li");

	public void selectMenu(String menuOption) {
		By driverNavigate = By.xpath("//ul[@class='list-group list-group-flush']//li");
		String text;
		List<WebElement> menuList=driver.findElements(driverNavigate);
		for(WebElement menu:menuList) {
			text=menu.getText();
				if(text.contentEquals(menuOption)) {
					menu.click();
						break;
					}
				}
			}
	public void list(String menuOption ) {
		List<WebElement> menuList=driver.findElements(collapseNavBar);

			for(WebElement menu:menuList) {
			String text=menu.getText();
			if(text.equalsIgnoreCase(menuOption)) {
				menu.click();
				break;
			}
			}
		}
}
