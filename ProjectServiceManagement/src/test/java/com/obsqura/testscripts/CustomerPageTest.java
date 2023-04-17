package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.CustomerPage;
import com.obsqura.Pages.LoginPage;
import com.obsqura.Pages.reparationTabPage;
import com.obsqura.ProjectServiceManagement.Base;

public class CustomerPageTest extends Base{
	CustomerPage customerpage;
	LoginPage loginpage;
	@Test
	public void verifyClientDetailsTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		customerpage = new CustomerPage(driver);
		customerpage.verifyClientDetails();	
	}
	@Test
	public void clientDetailWithoutClientNameTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		customerpage = new CustomerPage(driver);
		customerpage.verifyClientDetailsWithoutClientName();	
	}
	@Test
	public void clientPageShowButtonTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		customerpage = new CustomerPage(driver);
		customerpage.VerifyClientPageShowButton();	
	}
	@Test
	public void clientPageClickNextOptionTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		customerpage = new CustomerPage(driver);
		customerpage.verifyClickingNextOption();	
	}


}
