package com.obsqura.testscripts;

import org.testng.annotations.Test;

import com.obsqura.SeleniumProject.Base;
import com.obsqura.pages.RadioButtonDemoPage;

public class RadioButtonDemoTest extends Base {
	RadioButtonDemoPage obj;
@Test
	
	public void verifySingleRadioBuittonDemo() {
		obj=new RadioButtonDemoPage(driver);
		obj.singleRadioBuitton();
}
@Test
	public void verifyGroupRadioButton() {
		obj=new RadioButtonDemoPage(driver);
		obj.groupRadioButton();
}

}
