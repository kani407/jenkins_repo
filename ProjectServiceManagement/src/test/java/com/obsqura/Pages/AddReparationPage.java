package com.obsqura.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class AddReparationPage {
	public WebDriver driver;
	public AddReparationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//i[@class='fa fa-plus-circle']")
	private WebElement plusCircle;
	
	@FindBy(xpath="//span[@class='fa fa-list-alt icon']")
	private WebElement addReparationIcon;
	
	@FindBy(xpath="//input[@id='imei']")
	private WebElement imeiNumber;
	
	@FindBy(xpath="(//span[@class='select2-selection__arrow'])[4]")
	private List<WebElement> clientNameDropdown;
	
	@FindBy(xpath="//input[@id='category']")
	private WebElement category;
	
	@FindBy(xpath="//span[@id='select2-potax2-container']")
	private WebElement taxRateDropDown;
	
	@FindBy(xpath="//span[@id='select2-assigned_to-container']")
	private WebElement assignedToDropdown;
	
	@FindBy(xpath="//input[@id='reparation_manufacturer']")
	private WebElement manufacturer;
	
	@FindBy(xpath="//input[@id='reparation_model']")
	private WebElement reparationModel;
	
	@FindBy(xpath="//input[@id='add_item']")
	private WebElement addItem;
	
	@FindBy(xpath="//input[@id='defect']")
	private WebElement defect;
	
	@FindBy(xpath="//span[@id='select2-error_code-container']")
	private WebElement errorCodeDropdown;
	
	@FindBy(xpath="//input[@id='service_charges']")
	private WebElement serviceChargesDropDown;
	
	@FindBy(xpath="//input[@id='expected_close_date']")
	private WebElement extendedCloseDate;
	
	@FindBy(xpath="(//td[@class='day active'])[1]")
	private WebElement extendedCloseDateActiveDay;
	
	@FindBy(xpath="//input[@id='date_of_purchase']")
	private WebElement purchaseDatedropdown;
	
	@FindBy(xpath="//td[@class='day']")
	private WebElement purchaseDateFromCalender;
	
	@FindBy(xpath="//span[@id='select2-has_warranty-container']")
	private WebElement hasWarrantyDropdown;
	
	@FindBy(xpath="//span[@id='select2-warranty-container']")
	private WebElement warrantyDropdown;
	
	@FindBy(xpath="//input[@id='warranty_card_number']")
	private WebElement warrantyCardNumber;
	
	@FindBy(xpath="//input[@id='repair_type']")
	private WebElement repairType;
	
	@FindBy(xpath="//input[@id='client_date']")
	private WebElement clientReceiveDate;
	
	@FindBy(xpath="//textarea[@id='accessories']")
	private WebElement accessories;
	
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement comment;
	
	@FindBy(xpath="//textarea[@id='diagnostics']")
	private WebElement diagnostics;
	
	@FindBy(xpath="//button[@data-dismiss='modal']")
	private WebElement goBackButton;
	
	@FindBy(xpath="//span[@id='select2-status_edit-container']")
	private WebElement progresStatusDropdown;
	
	@FindBy(xpath="//textarea[@class='bootbox-input bootbox-input-textarea form-control']")
	private WebElement descriptionForStatusChange;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement statusCancelButton;
	
	@FindBy(xpath="//button[text()='OK']")
	private WebElement statusConfirmButton;
	
	@FindBy(xpath="(//button[@type='button'])[37]")
	private WebElement closeXforStatusChange;
	
	@FindBy(xpath="//input[@id='code']")
	private WebElement reparationCode;
	
	@FindBy(xpath="//button[@id='upload_modal_btn']")
	private WebElement uploadImageButton;
	
	@FindBy(xpath="//input[@id='repair_sms']")
	private WebElement sendAutomaticTxtcheckBox;
	
	@FindBy(xpath="//input[@id='repair_email']")
	private WebElement sendAutomaticMailCheckBox;
	
	@FindBy(xpath="//button[@id='sign_repair']")
	private WebElement signRepairButton;
	
	@FindBy(xpath="//canvas[@class='jSignature']")
	private WebElement ssignatureMouseOver;
	
	@FindBy(xpath="//button[@id='submit_sign']")
	private WebElement saveSignatureButton;
	
	@FindBy(xpath="//button[@id='reset_sign']")
	private WebElement resetSignButtton;
	
	@FindBy(xpath="(//button[@class='close'])[3]")
	private WebElement closeSignPopUp;
	
	@FindBy(xpath="//button[@class='prerepair_show btn btn-primary']")
	private WebElement preRepairCheckList;
	
	@FindBy(xpath="//label[text()='Power Button']")
	private WebElement powerButtonChecklist;
	
	@FindBy(xpath="//label[text()='Volume button']")
	private WebElement volumeButtoncheckList;
	
	@FindBy(xpath="//label[text()='LCD']")
	private WebElement lcdCheckList;
	
	@FindBy(xpath="//label[text()='Home Button']")
	private WebElement homeButtonCheckList;
	
	@FindBy(xpath="//label[text()='Cellular Signal']")
	private WebElement cellularSignalCheckList;
	
	@FindBy(xpath="//label[text()='Front Camera']")
	private WebElement frontCamera;
	
	@FindBy(xpath="//label[@for='checktoggle_57696669']")
	private WebElement wifiCheckList;
	
	@FindBy(xpath="//label[@for='checktoggle_476c617373']")
	private WebElement glassCheckList;
	
	@FindBy(xpath="//label[@for='checktoggle_4368617267696e6720506f7274']")
	private WebElement chargingPortCheckList;
	
	@FindBy(xpath="//label[@for='checktoggle_4261636b20476c617373']")
	private WebElement backGlassCheckList;
	
	@FindBy(xpath="//input[@name='cust_pin_code']")
	private WebElement pinCodePreRepair;
	
	@FindBy(xpath="//div[@class='patt-dots']")
	private WebElement PatternPreChekList;
	
	@FindBy(xpath="//button[@id='repair_submit']")
	private WebElement repairSubmitButton;
	
	public void clickAddReparation(String imeiNo,String name,String categoryrepair,String manufacturerName,String modelno,String defectName,String serviceamt) throws IOException, InterruptedException{
		String actualPage,expectedPage=ExcelUtility.getString(4, 7,System.getProperty("user.dir")+"Constants.Constants.TESTDATAFILE","Sheet1");		
		PageUtility.clickOnElement(plusCircle);
		WaitUtility.waitForElementClickable(driver, addReparationIcon);
		PageUtility.clickOnElement(addReparationIcon);
		PageUtility.enterText(imeiNumber, imeiNo);
		PageUtility.enterText(category, categoryrepair);
		PageUtility.selectDropdownbyText(clientNameDropdown, name);
		PageUtility.enterText(reparationModel, modelno);
		PageUtility.enterText(defect, defectName);
		PageUtility.enterText(serviceChargesDropDown, serviceamt);
		PageUtility.isElementDisplayed(repairSubmitButton);
		WaitUtility.waitForElementClickable(driver, repairSubmitButton);
		PageUtility.clickOnElement(repairSubmitButton);
		actualPage=driver.getCurrentUrl();
		Assert.assertEquals(expectedPage, actualPage, "Page is not navigated");	
	}
}
