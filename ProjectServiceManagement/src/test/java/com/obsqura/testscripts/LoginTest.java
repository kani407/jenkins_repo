package com.obsqura.testscripts;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.obsqura.Pages.LoginPage;
import com.obsqura.ProjectServiceManagement.Base;
public class LoginTest extends Base {
	LoginPage obj;
	@Test
	public void login() throws IOException {
		obj = new LoginPage(driver);
		obj.accountLogin();
	}
	@Test
	public void CheckloginwithWrongPassWord() throws IOException {
		obj = new LoginPage(driver);
		obj.loginWithWrongPassword();
	}
	@Test
	public void CheckloginwithWrongUserName() throws IOException {
		obj = new LoginPage(driver);
		obj.loginWithWrongUserName();
	}
	@Test
	public void Checklogout() throws IOException {
		obj = new LoginPage(driver);
		obj.accountLogin();
		obj = new LoginPage(driver);
		obj.logOut();
	}
	@Test
	public void forgotPasswordTest() throws IOException {
		obj = new LoginPage(driver);
		obj.verifyForgotPassword();
	}
	
}