package com.obsqura.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.Pages.LoginPage;
import com.obsqura.Pages.SendEmailPage;
import com.obsqura.Pages.inventoryPage;
import com.obsqura.ProjectServiceManagement.Base;

public class InventoryTest extends Base {
	inventoryPage inventory;
	LoginPage loginpage;
	@Test
	public void addInventoryProductTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		inventory=new inventoryPage(driver);
		inventory.addInventoryProduct();
	}
	@Test
	public void deleteInventoryProductTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		inventory=new inventoryPage(driver);
		inventory.delectInventoryVerification();
	}
	@Test
	public void navigateTonextPageTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		inventory=new inventoryPage(driver);
		inventory.navigateToNextPageOnClickingNextOptionVerification();
	}
	@Test
	public void editInventoryProductTest() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		loginpage.accountLogin();
		inventory=new inventoryPage(driver);
		inventory.EditInventoryProductVerification();
	}
	
}
