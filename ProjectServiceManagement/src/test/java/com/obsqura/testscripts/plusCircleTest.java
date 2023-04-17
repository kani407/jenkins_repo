package com.obsqura.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.obsqura.Pages.LoginPage;
import com.obsqura.Pages.PlusCirclePage;
import com.obsqura.ProjectServiceManagement.Base;

public class plusCircleTest extends Base {
	PlusCirclePage pluscircle;
	LoginPage loginpage;
	@Test
	public void clickPlusCircleTest() throws IOException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		pluscircle = new PlusCirclePage(driver);
		pluscircle.clickPlusCircle();
		
	}
	@Test
	public void verifyGeoLocationPopUpTest() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		pluscircle = new PlusCirclePage(driver);
		pluscircle.verifyGeoLocationPopUp();
	}

}
