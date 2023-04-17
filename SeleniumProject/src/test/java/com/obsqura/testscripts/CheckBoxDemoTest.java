package com.obsqura.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.obsqura.SeleniumProject.Base;
import com.obsqura.pages.CheckBoxDemoPage;
import com.obsqura.pages.HeaderPage;

public class CheckBoxDemoTest extends Base {
	CheckBoxDemoPage obj;
	HeaderPage headerPage=new HeaderPage(driver);
@Test
	public void VerifysingleCheckBoxDemo() {
		
		headerPage.list("TABLE");
		obj=new CheckBoxDemoPage(driver);
		obj.singleCheckBox();
}
@Test
	public void VerifymultipleCheckBoxDemo() {
		headerPage=new HeaderPage(driver);
		headerPage.selectMenu("Checkbox Demo");
		obj=new CheckBoxDemoPage(driver);
		obj.multipleCheckBox();
}

}
