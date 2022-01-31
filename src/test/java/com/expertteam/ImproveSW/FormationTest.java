package com.expertteam.ImproveSW;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormationTest extends Base{

	private static FormationPO PageObjectFormation;

	@BeforeMethod

	public static void setUpChrome()  {

		// Initialize browser
		Base.InitilizeChrome();	

		//Locators Page
		PageObjectFormation = new FormationPO(driver);
		Reporter.log("Driver got initialized",true);

	}


	@Test(dataProvider = "FormationData")
	public static void formationLink(String Domaine, String DomaineTitle, String FormationLink, String FormationTitle) {
		PageObjectFormation.getFormationPage().click();
		System.out.println(Domaine + DomaineTitle + FormationLink + FormationTitle);
	}

	@DataProvider(name= "FormationData")
	public String[][] getData() throws IOException{


		String path=".\\datafiles\\FormationData.xls";

		int rowNum = Utility.getRowCount(path, "Formation");
		int colNum = Utility.getCellCount(path, "Formation", 1);

		String formationTitle[][]= new String [rowNum][colNum];
		for(int i=1; i<rowNum;i++) {
			for(int j=1; j<colNum;j++) {
				formationTitle[i-1][j]=Utility.getCellData(path, "Formation",i ,j);
			}
		}

		return formationTitle;

	}
	@AfterMethod

	public  static void tearDown(ITestResult result) {

		if (ITestResult.FAILURE== result.getStatus())
		{
			Utility.captureScreenshot(driver, result.getName()+"_"+result.getEndMillis());
		}
		driver.close();
		Reporter.log("Browser closed",true);
	}

}