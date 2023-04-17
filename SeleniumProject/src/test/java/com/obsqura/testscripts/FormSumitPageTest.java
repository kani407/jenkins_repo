package com.obsqura.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.SeleniumProject.Base;
import com.obsqura.pages.FormSubmitPage;

public class FormSumitPageTest extends Base {
	FormSubmitPage formSubmitPageobj;
	@Test(dataProvider="SearchProvider")
	public void verifyFirstPersonDetails(String firstName1,String lastName1,String userName1,String cityName1,String  stateName1,String zipCode1) {
		formSubmitPageobj=new FormSubmitPage(driver);
		formSubmitPageobj.FirstPersonDetails( firstName1, lastName1, userName1, cityName1,  stateName1, zipCode1);
	}
	@Test(dataProvider="SearchProvider")
	public void verifySecondPersonDetails(String firstName2,String lastName2,String userName2,String cityName2,String  stateName2,String zipCode2) {
		formSubmitPageobj=new FormSubmitPage(driver);
		formSubmitPageobj.SecondPersonDetails(firstName2, lastName2, userName2, cityName2,  stateName2, zipCode2);
	}
	@Test(dataProvider="SearchProvider")
	public void verifyThirdPersonDetails(String firstName3,String lastName3,String userName3,String cityName3,String  stateName3,String zipCode3) {
		formSubmitPageobj=new FormSubmitPage(driver);
		formSubmitPageobj.ThirdPersonDetails( firstName3, lastName3, userName3, cityName3,  stateName3, zipCode3);
	}
	@Test(dataProvider="SearchProvider")
	public void verifyFourthPersonDetails(String firstName4,String lastName4,String userName4,String cityName4,String  stateName4,String zipCode4) {
		formSubmitPageobj=new FormSubmitPage(driver);
		formSubmitPageobj.FourthPersonDetails( firstName4, lastName4, userName4, cityName4,  stateName4, zipCode4);
	}
	@Test(dataProvider="SearchProvider")
	public void verifyFifthPersonDetails(String firstName5,String lastName5,String userName5,String cityName5,String  stateName5,String zipCode5) {
		formSubmitPageobj=new FormSubmitPage(driver);
		formSubmitPageobj.FifthPersonDetails( firstName5, lastName5, userName5, cityName5,  stateName5, zipCode5);
	}
	@DataProvider(name="SearchProvider")
	public Object[][] getDataFromDataprovider(){
	return new Object[][] 
		{
		{"Kanimozhi","Ammasi","@kani","Salem","Tamilnadu","636011"},
		{"Sumayya Jaleel","Jaleel","@sumayyajaleel","Kollam","Kerala","691005"},
		{"Sumayya NNishad","Nishad","@SumayyaNisahd","Kottayam","Kerala","686020"},
		{"Akhila","Asoka","@kichu","Kayamkulam","Kerala","690501"},
		{"Vyshnavy","Prakash","@Vyshu","PTA","Kerala","689672"}
	    };
}
	
}