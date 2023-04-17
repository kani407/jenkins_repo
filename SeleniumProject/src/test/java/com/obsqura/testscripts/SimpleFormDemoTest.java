package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.SeleniumProject.Base;
import com.obsqura.pages.SimpleFormDemoPage;

public class SimpleFormDemoTest extends Base {
	SimpleFormDemoPage obj;
	@Test
	public void enterMessageAndVerifySingleInputField() throws IOException {
		obj=new SimpleFormDemoPage(driver);
		obj.verifyEnterMessageField();
	}
	@Test
	public void enterMessageAndVerifyTwoInputField() throws IOException {
		obj=new SimpleFormDemoPage(driver);
		obj.twoInputFieldVerification();
	}
	
	
}
