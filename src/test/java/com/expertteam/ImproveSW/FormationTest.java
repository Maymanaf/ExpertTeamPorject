package com.expertteam.ImproveSW;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.FormationPO;



public class FormationTest extends Base{
	String currentpath = System.getProperty("user.dir");
	private static FormationPO PageObjectFormation;

	@BeforeMethod

	public static void setUpChrome()  {

		// Initialize browser
		Base.InitilizeChrome();	

		//Locators Page
		PageObjectFormation = new FormationPO(driver);
		Reporter.log("Driver got initialized",true);
		PageObjectFormation.getFormationPage().click();
	}


	@Test(dataProvider = "FormationData")
	public static void formationLink(String domaine, String domaineTitle, String formationDomaine, String formationTitle) {


		System.out.println("Theme de formation ==> "+domaineTitle);
		driver.get(baseUrl+domaine);

		driver.findElement(By.partialLinkText(formationDomaine.trim())).click();

		PageObjectFormation.getPreInscriptionButton().click();

		Assert.assertEquals("Demander un devis",PageObjectFormation.getTitle().getText());
		Reporter.log("Le titre correspond avec la page en cours",true);

	}

	@DataProvider(name= "FormationData")

	public Object[][] getData() {

		String path=currentpath+ "/datafiles/FormationData.xls";
		Object[][] arrObj = GetExcelData.getExcelData(path, "Formation");
		return arrObj;
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