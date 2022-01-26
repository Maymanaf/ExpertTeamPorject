package com.expertteam.ImproveSW;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DevisTest extends Base{
	
	private static DevisPO PageObjectDevis;

	@BeforeMethod

	public static void setUpChrome()  {

		// Initialize browser
		Base.InitilizeChrome();	
	
		//Locators Page
		PageObjectDevis = new DevisPO(driver);
		Reporter.log("Driver got initialized",true);

	}




	@Test(priority =0)

	public void DemandeDevisTest() {
		PageObjectDevis.getDemandeDevisPage().click();
		Reporter.log("Quote Page is opened",true);
		PageObjectDevis.getParticulierChecbox().click();
		Reporter.log("Particular is selected",true);
		PageObjectDevis.getAssujettieTVA().click();
		Reporter.log("Subject to TVA is selected",true);
		PageObjectDevis.getFormation().click();
		PageObjectDevis.getTestsLogiciels().click();
		Reporter.log("Curriculum is selected",true);
		PageObjectDevis.getNBPersonnne().sendKeys("8");
		Reporter.log("The number of participants is entered",true);
		PageObjectDevis.getIntraEntrepriseChecbox().click();
		Reporter.log("Intra-Company is selected",true);
		PageObjectDevis.getYourDate().sendKeys("20/04/2022");
		Reporter.log("Desired Date is setted",true);
		PageObjectDevis.getYourName().sendKeys("Mabn Abn");
		Reporter.log("The Full Name is setted",true);
		PageObjectDevis.getYourTel().sendKeys("+21628888000");
		Reporter.log("The Phone number is setted",true);
		PageObjectDevis.getYourEmail().sendKeys("abn@abn.com");
		Reporter.log("The Email address is setted",true);
		PageObjectDevis.getSelectJob().selectByVisibleText("Travailleur indépendant");
		Reporter.log("The job is selected",true);
		PageObjectDevis.getYourCompany().sendKeys("ImproveSW");
		Reporter.log("The Company title is selected",true);
		//PageObjectDevis.getPerioriteMoyenne().click();
		//Reporter.log("The periority is selected",true);
		PageObjectDevis.getContactEmail().click();
		Reporter.log("The contact mail is selected",true);
		PageObjectDevis.getContactTel().click();
		Reporter.log("The contact phone is selected",true);
		PageObjectDevis.getContactDirect().click();
		Reporter.log("The direct contact is selected",true);
		//WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofSeconds(10));
		//waitFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(PageObjectDevis.getRecaptchaFrame()));
		WebDriverWait waitClick = new WebDriverWait(driver, Duration.ofSeconds(20));
		//waitClick .until(ExpectedConditions.elementToBeClickable(PageObjectDevis.getRecaptchaBox())).click();
		//Reporter.log("The captcha checkbox is clicked",true);
		waitClick .until(ExpectedConditions.elementToBeClickable(PageObjectDevis.getSendButton())).click();
		Reporter.log("Send button is clicked",true);

		Assert.assertEquals(1,PageObjectDevis.getErrorX().size(),"Element(s) is not selected");
	}

	@Test(priority =1)

	public void DemandeDevisTestError() {
		PageObjectDevis.getDemandeDevisPage().click();
		Reporter.log("Quote Page is opened",true);
		PageObjectDevis.getSendButton().click();
		Assert.assertEquals(11,PageObjectDevis.getErrorX().size(),"Element(s) is not selected");
	}

	@AfterMethod

	public  static void tearDown(ITestResult result) {

		if (ITestResult.FAILURE== result.getStatus())
		{
			Utility.captureScreenshot(driver, result.getName()+result.getEndMillis());
		}
		driver.close();
		Reporter.log("Browser closed",true);
	}

}

