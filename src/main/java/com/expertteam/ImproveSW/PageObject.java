package com.expertteam.ImproveSW;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.log.Log;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	Logger log ;
    WebDriver driver;

	
	public PageObject (WebDriver driver ) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

		log = Logger.getLogger(Log.class.getName());

		log.setLevel(Level.INFO);
	}




}
