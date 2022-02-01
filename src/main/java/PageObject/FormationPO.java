package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormationPO extends PageObject {

	public FormationPO(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="menu-item-212")
	private WebElement FormationPage;
	
	@FindBy(xpath="//a[normalize-space()='Pré inscription']")
	private WebElement preInscriptionButton;
	
	@FindBy(xpath="//h1[@class='title']")
	 private WebElement title;
	
	public WebElement getFormationPage() {
		return FormationPage;
	}

	public WebElement getPreInscriptionButton() {
		return preInscriptionButton;
	}

	public WebElement getTitle() {
		return title;
	}

	

	
	
}
