package com.obsqura.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.obsqura.SeleniumProject.Base;

public class AlertAccept extends Base {
	@Test
	public void alertClick() {
	driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
	WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	button.click();
	driver.switchTo().alert().accept();
	}
	@Test
	public void alertClickCancel() {
		driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement button=driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		button.click();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().accept();
		String text=driver.switchTo().alert().getText();
	
		}
	@Test
	public void alertEnterValueClick() {
		driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickPrompt=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		clickPrompt.click();
		driver.switchTo().alert().sendKeys("Obsqura");
		driver.switchTo().alert().accept();
		
	}
	@Test
	public void windowPopUps() {
		driver.navigate().to("https://selenium.obsqurazone.com/window-popup.php");
		WebElement FaceBookWindow=driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));
		FaceBookWindow.click();
		String mainwindow=driver.getWindowHandle();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		while(i1.hasNext())
		{
			String childwindow=i1.next();
			if(!mainwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				WebElement loginButton=driver.findElement(By.xpath("(//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft'])[1]"));
				loginButton.click();
				WebElement emailIdField=driver.findElement(By.xpath("//input[@id='email']"));
				emailIdField.sendKeys("akp.kani@gmail.com");
				WebElement passwordField=driver.findElement(By.xpath("//input[@id='pass']"));
				passwordField.sendKeys("klufdifohd");
				WebElement faceBookloginButton=driver.findElement(By.xpath("//button[@id='loginbutton']"));
				faceBookloginButton.click();		
			}
			driver.close();
		}
		driver.switchTo().window(mainwindow);
	}
}
