package com.expertteam.ImproveSW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormationPO extends PageObject{

	public FormationPO(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="menu-item-212")
	private WebElement FormationPage;
	
	@FindBy(xpath="//a[@href='https://www.expertunisie.com/index.php/demander-un-devis/']//span[contains(text(), ' Pré inscription')]")
	private WebElement preInscriptionButton;
	
	@FindBy(xpath="//h1[@class=\"title\"]")
	 private WebElement formationTitle;
	
	public WebElement getFormationTitle() {
		return formationTitle;
	}

	public WebElement getPreInscriptionButton() {
		return preInscriptionButton;
	}

	public WebElement getFormationPage() {
		return FormationPage;
	}
	

}
