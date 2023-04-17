package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.LoginPage;
import com.obsqura.Pages.SendEmailPage;
import com.obsqura.ProjectServiceManagement.Base;

public class SendEmailTest extends Base {
	SendEmailPage sendEmail;
	LoginPage loginpage;
	@Test
	public void clickSendEmailTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		sendEmail=new SendEmailPage(driver);
		sendEmail.clickSendemail();
	}
	@Test
	public void clickSendEmailWithoutSubjectFieldTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		sendEmail=new SendEmailPage(driver);
		sendEmail.clicksendMailWithoutSubject();
	}
	@Test
	public void clickSendEmailWithoutmailContentTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		sendEmail=new SendEmailPage(driver);
		sendEmail.clicksendMailWithoutmailContent();
	}
}
