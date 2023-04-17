package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.HomePageNavigation;
import com.obsqura.Pages.LoginPage;
import com.obsqura.Pages.SendEmailPage;
import com.obsqura.ProjectServiceManagement.Base;

public class HomePageNavigationTest extends Base {
	HomePageNavigation homepage;
	LoginPage loginpage;
	@Test
	public void navigateToInventoryPageTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		homepage=new HomePageNavigation(driver);
		homepage.verifyNavigateToInventoryPage();
	}
	@Test
	public void navigateToClientPageTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		homepage=new HomePageNavigation(driver);
		homepage.VerifyNavigateToClientPage();
	}
	@Test
	public void navigateToReparationPageTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		homepage=new HomePageNavigation(driver);
		homepage.verifyNavigateToReparationPage();
	}
	@Test
	public void VerifyQualityAlertTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		homepage=new HomePageNavigation(driver);
		homepage.VerifyNavigateToQualityAlert();
	}
	

}
