package com.expertteam.ImproveSW;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.CursusPO;

public class CursusTest extends Base{

	private String currentpath = System.getProperty("user.dir");
	private String path = currentpath+ "/datafiles/CursusData.xlsx";
	private static CursusPO PageObjectCursus;

	private static List<String> CursusList = Arrays.asList("Testeur logiciel et automatisation", "Testeur Automaticien","Développeur Full stack JS", "Développeur Applications Mobiles", "UX/UI Designer", "Marketing digital", "Responsable commerciale", "IT Acquisition Talent");

	@BeforeMethod

	public static void setUpChrome()  {

		// Initialize browser
		Base.InitilizeChrome();	

		//Locators Page
		PageObjectCursus = new CursusPO(driver);
		Reporter.log("Driver got initialized",true);

	}

	// Verify the list of elements in "Nos Cursus"

	@Test(priority =0)
	public void ElementofNosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		List<WebElement> ExpertTeamLinks = PageObjectCursus.getListofLinks();
		List<String> ExpertTeamTexts = ExpertTeamLinks.stream().map(WebElement::getText).collect(Collectors.toList());
		Assert.assertEquals(ExpertTeamTexts, CursusList, "Element(s) are not the same");
		Reporter.log("Le titre correspond avec la liste de cursus",true);
	}
	



	// Verify Testeur logiciel et automatisation page
	@Test(priority =1)
	public void SelectTLAofNosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		PageObjectCursus.getTesteurLogicielAutomatisation().click();

		PageObjectCursus.getPreInscriptionButton().click();
		Assert.assertEquals("Demander un devis",PageObjectCursus.getTitle().getText());
		Reporter.log("Le titre correspond avec la page en cours",true);
	}





	@Test(priority =2, dataProvider= "CursusData")
	public void cursusTest(String CursusID,String CursusTitle) throws Exception {
		PageObjectCursus.getCursusPage().click();
		driver.findElement(By.linkText(CursusTitle.trim())).click();
		System.out.println("Le Titre de cursus ==> "+CursusTitle);
		PageObjectCursus.getPreInscriptionButton().click();
		Assert.assertEquals("Demander un devis",PageObjectCursus.getTitle().getText());
		Reporter.log("Le titre correspond avec la page en cours",true);
	}





	@DataProvider(name= "CursusData")

	public Object[][] getData() {

		Object[][] arrObj = GetExcelData.getExcelData(path, "Cursus");
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

