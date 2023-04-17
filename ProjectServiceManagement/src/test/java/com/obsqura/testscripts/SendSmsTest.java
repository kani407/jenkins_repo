package com.obsqura.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.obsqura.Pages.LoginPage;
import com.obsqura.Pages.PlusCirclePage;
import com.obsqura.Pages.SendSmsPage;
import com.obsqura.ProjectServiceManagement.Base;

public class SendSmsTest extends Base {
	PlusCirclePage obj;
	LoginPage loginpage;
	SendSmsPage sendmsg;
	@Test
	public void clickSendSms() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		sendmsg=new SendSmsPage(driver);
		sendmsg.sendsms();
	}
	@Test
	public void clickSendSmsWithoutSubjectTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		sendmsg=new SendSmsPage(driver);
		sendmsg.sendsmsWithoutSubject();
	}
	@Test
	public void clickSendSmsWithoutNumberTest() throws IOException, InterruptedException {	
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		sendmsg=new SendSmsPage(driver);
		sendmsg.sendsmsWithoutNumber();
	}
	

}
