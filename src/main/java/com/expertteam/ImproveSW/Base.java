package com.expertteam.ImproveSW;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public  static String baseUrl="https://www.expertunisie.com/";
	public  static WebDriver driver;

	public static void InitilizeChrome()  {

		// Initialize browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Maximize browser
		driver.manage().window().maximize(); 
		//Open Website
		driver.get(baseUrl);


	}


}
