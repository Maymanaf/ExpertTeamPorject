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
	
	
	
	@Test
	public void ElementofNosCursusTest() throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
	    List<WebElement> ExpertTeamLinks = PageObjectCursus.getListofLinks();
		List<String> ExpertTeamTexts = ExpertTeamLinks.stream().map(WebElement::getText).collect(Collectors.toList());
		//System.out.println(ExpertTeamTexts);
		//System.out.println(CursusList);
		Assert.assertEquals(ExpertTeamTexts, CursusList, "Element(s) are not the same");
	}

	@Test
	public void SelectElementofNosCursusTest() throws Exception {
	    List<WebElement> ExpertTeamLinks = PageObjectCursus.getListofLinks();
		Actions action = new Actions(driver);
		action.moveToElement(PageObjectCursus.getCursusPage()).build().perform();;
		Thread.sleep(3000);
		
		for (WebElement NosCursusLinks : ExpertTeamLinks) {

			if (NosCursusLinks.getText().equals("Testeur logiciel et automatisation")) {

				NosCursusLinks.click();

			}
			
		}

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

