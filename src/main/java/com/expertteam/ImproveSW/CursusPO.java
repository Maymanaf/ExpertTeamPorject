package com.expertteam.ImproveSW;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CursusPO extends PageObject{

	public CursusPO(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="menu-item-6024")
	private WebElement CursusPage;
	@FindBy(xpath="//li[@id='menu-item-6024']//li")
	private List<WebElement>  ListofLinks;

	public List<WebElement>  getListofLinks() {
		return ListofLinks;
	}

	public WebElement getCursusPage() {
		return CursusPage;
	}

}
