package com.obsqura.dataProviderUtility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name="searchProvider")
	public Object[][] getDataFromDataprovider(){
		return new Object[][]
		{
			{"Test123","Anu","Mobile_Panel","vivo_193","1517","Screen_break","5"}
		};
	}

}
