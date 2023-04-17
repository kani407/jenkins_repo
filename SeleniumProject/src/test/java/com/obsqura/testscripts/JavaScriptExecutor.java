package com.obsqura.testscripts;

import org.testng.annotations.Test;

import com.obsqura.SeleniumProject.Base;
import com.obsqura.pages.JavaScriptExecuterDemo;

public class JavaScriptExecutor extends Base {
	JavaScriptExecuterDemo obj;
	@Test
	public void javaScriptExecters() {
		obj = new JavaScriptExecuterDemo(driver);
		obj.javaScript();

}
}
