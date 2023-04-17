package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.AddReparationPage;
import com.obsqura.Pages.LoginPage;
import com.obsqura.Pages.SendEmailPage;
import com.obsqura.ProjectServiceManagement.Base;
import com.obsqura.dataProviderUtility.DataProviderUtility;


public class AddReparationTest extends Base {
	AddReparationPage reparationpage;
	LoginPage loginpage;
	@Test(dataProvider="searchProvider",dataProviderClass=DataProviderUtility.class)
	public void clickAddReparationTest(String imeiNo,String name,String categoryrepair,String manufacturerName,String modelno,String defectName,String serviceamt) throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		reparationpage=new AddReparationPage(driver);
		reparationpage.clickAddReparation(imeiNo,name,categoryrepair,manufacturerName,modelno,defectName,serviceamt);
	}
}
