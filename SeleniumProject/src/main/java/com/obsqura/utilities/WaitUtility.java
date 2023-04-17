package com.obsqura.utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 20;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;
	public static void waitForElement(WebDriver driver, WebElement target) {					//visibilityOfElement
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)); 
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	public static void waitForElementClickable(WebDriver driver, WebElement target) {			//elementToBeClickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public static void waitForElement(WebDriver driver, By target) {							//visibilityOfElementLocated
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
			wait.until(ExpectedConditions.visibilityOfElementLocated(target));
	}
	public static void elementToBeClickableByLocator(WebDriver driver, By target) {		//ElementToBeClickableByLocator
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
			wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public static void waitForElementIsPresent(WebDriver driver, By locator) {					//presenceOfElementLocated
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static void waitForAlertIsPresent(WebDriver driver, By locator) {					//alertIsPresent
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
			wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void waitForElementToBeSelected(WebDriver driver, By locator) {				//elementToBeSelected
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
			wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	public static void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver, By locator) {	//frameToBeAvailableAndSwitchToIt
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	public static void waitForInvisibilityOfElementLocated(WebDriver driver, By locator) {		//invisibilityOfElementLocated
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public static void waitForpresenceOfElementLocated(WebDriver driver, By locator) {			//presenceOfElementLocated
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static void waitForpresenceOfAllElementsLocatedBy(WebDriver driver, By locator) {	//presenceOfAllElementsLocatedBy
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	public static void waitForTextToBePresentInElementLocated(WebDriver driver, By locator) {	//textToBePresentInElementLocated
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, null));
	}
	public static void waitForattributeToBe(WebDriver driver, By locator) {						//attributeToBe
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));	 
			wait.until(ExpectedConditions.attributeToBe(locator, null, null));
	}
	public static void waitForElementToBeClickableByLocator(WebDriver driver, By showMessage) {
		// TODO Auto-generated method stub
		
	}	
}
