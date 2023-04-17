package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.LoginPage;
import com.obsqura.Pages.reparationTabPage;
import com.obsqura.ProjectServiceManagement.Base;

public class reparationTabTest extends Base{
	reparationTabPage reparationtab;
	LoginPage loginpage;
	@Test(priority=5)
	public void OrdersAndRepairPageTest() throws IOException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		reparationtab = new reparationTabPage(driver);
		reparationtab.verifyOrdersAndRepairPage();
		
	}
	@Test(priority=4)
	public void rowNUmInShowButtonTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		reparationtab = new reparationTabPage(driver);
		reparationtab.VerifyRowNumberInShowButton();
		
	}
	@Test(priority=3)
	public void downloadReparationExcelSheetTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		reparationtab = new reparationTabPage(driver);
		reparationtab.verifyDownloadingReparationExcelSheet();	
	}
	@Test(priority=2)
	public void coloumnVisibilityTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		reparationtab = new reparationTabPage(driver);
		reparationtab.verifyColumnVisibility();	
	}
	@Test(priority=1)
	public void rowCountWithSameNameTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		reparationtab = new reparationTabPage(driver);
		reparationtab.verifyRowCountWithSameName();	
	}
	@Test(priority=8)
	public void completedRepairTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		reparationtab = new reparationTabPage(driver);
		reparationtab.verifyTotalCompletedRepairRows();	
	}	
	@Test(priority=7)
	public void coloumnNumberTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		reparationtab = new reparationTabPage(driver);
		reparationtab.verifyColumnNumber();	
	}
	@Test(priority=6)
	public void rowNumberVerificarionForPendingRepairs() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		reparationtab = new reparationTabPage(driver);
		reparationtab.VerifyrowNumberShowButtonForPendingRepairs();	
	}	

}
