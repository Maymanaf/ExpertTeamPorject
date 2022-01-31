package com.expertteam.ImproveSW;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CursusTest extends Base{


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
		System.out.println(ExpertTeamTexts);
		System.out.println(CursusList);
		Assert.assertEquals(ExpertTeamTexts, CursusList, "Element(s) are not the same");
	}
// Verify Testeur logiciel et automatisation page
	@Test(priority =1)
	public void SelectTLAofNosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		PageObjectCursus.getTesteurLogicielAutomatisation().click();
		
//     List<WebElement> ExpertTeamLinks = PageObjectCursus.getListofLinks();
//		for (WebElement NosCursusLinks : ExpertTeamLinks) {
//			if (NosCursusLinks.getText().equals("Testeur logiciel et automatisation")) {
//				NosCursusLinks.click();
//			}
//		}

		PageObjectCursus.getPreInscriptionButton().click();
	}
	@Test(priority =2)
	public void SelectTAofNosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		PageObjectCursus.getTesteurAutomaticien().click();
		PageObjectCursus.getPreInscriptionButton().click();
	}
	@Test(priority =3)
	public void SelectDFSofNosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		PageObjectCursus.getDevFullStack().click();
		PageObjectCursus.getPreInscriptionButton().click();
	}
	@Test(priority =4)
	public void SelectDAMofNosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		PageObjectCursus.getDevApp().click();
		PageObjectCursus.getPreInscriptionButton().click();
	}
	@Test(priority =5)
	public void SelectUIUXDofNosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		PageObjectCursus.getDesigner().click();
		PageObjectCursus.getPreInscriptionButton().click();
	}
	
	@Test(priority =6)
	public void SelectMDofNosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		PageObjectCursus.getMarketingDigital().click();
		PageObjectCursus.getPreInscriptionButton().click();
	}
	@Test(priority =7)
	public void SelectRCosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		PageObjectCursus.getMarketingDigital().click();
		PageObjectCursus.getPreInscriptionButton().click();
	}
	@Test(priority =8)
	public void SelectITATosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		PageObjectCursus.getAcquisitionTalent().click();
		PageObjectCursus.getPreInscriptionButton().click();
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

