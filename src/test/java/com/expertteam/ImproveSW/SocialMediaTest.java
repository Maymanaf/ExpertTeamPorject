package com.expertteam.ImproveSW;

import java.util.Iterator;
import java.util.Set;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.SocialMediaPO;


public class SocialMediaTest extends Base{

	private static SocialMediaPO PageObjectSocialMedia ;

	@BeforeMethod
	public static void setUpChrome()  {

		// Initialize browser
		Base.InitilizeChrome();	

		//Locators Page
		PageObjectSocialMedia = new SocialMediaPO(driver);
		Reporter.log("Driver got initialized",true);

	}

	@Test
	public void FacebookHeaderTest() {
		PageObjectSocialMedia.getFacebookHeader().click();
		Reporter.log("Facebook Page is opened",true);
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				boolean titleMatch = driver.getTitle().contains("Expert Team Tunisie");
				if ( titleMatch == true) ;
				Reporter.log("Expert Team Tunisie facebook page is opened",true );
				driver.close();
				Reporter.log("Facebook Page is closed",true);
				driver.switchTo().window(mainWindowHandle);

			}
		}
	}
	@Test
	public void InstagramHeaderTest() {
		PageObjectSocialMedia.getInstagramHeader().click();
		Reporter.log("Instagram Page is opened",true);
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
				boolean titleMatch = driver.getTitle().contains("Expert Team Tunisie");
				if ( titleMatch == true) ;
				Reporter.log("Expert Team Tunisie Instagram page is opened",true );
				driver.close();
				Reporter.log("Instagram Page is closed",true);
				driver.switchTo().window(mainWindowHandle);

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
