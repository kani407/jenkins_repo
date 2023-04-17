
package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.obsqura.SeleniumProject.Base;

public class Table extends Base{
	WebDriver driver;

	public Table(WebDriver driver) {
		this.driver = driver;
	}
	By table = By.xpath("//a[@href='table-pagination.php']");
	By tableRow = By.xpath("//table[@id='dtBasicExample']/tbody/tr");
	By tableColumn =By.xpath("//tr[@role='row']//th");

	public void tableList() {
		driver.findElement(table).click();
		List<WebElement> row = driver.findElements(tableRow);
		List<WebElement> column=driver.findElements(tableColumn);
 		int rowCount = row.size();
		int columnCount=column.size();
		for (WebElement option : row) {
			String text = option.getText();
			System.out.println(text);
		}
		

	}

}
