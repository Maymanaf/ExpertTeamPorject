package PageObject;

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

	@FindBy(id="menu-item-6232")
	private WebElement TesteurLogicielAutomatisation;

	@FindBy(id="menu-item-6368")
	private WebElement TesteurAutomaticien;

	@FindBy(id="menu-item-6237")
	private WebElement DevFullStack;

	@FindBy(id="menu-item-6240")
	private WebElement DevApp;

	@FindBy(id="menu-item-6336")
	private WebElement Designer;

	@FindBy(id="menu-item-6248")
	private WebElement MarketingDigital;

	@FindBy(id="menu-item-6243")
	private WebElement RespCom;

	
	@FindBy(id="menu-item-6249")
	private WebElement AcquisitionTalent;

	@FindBy(xpath="//li[@id='menu-item-6024']//li")
	private List<WebElement>  ListofLinks;

	@FindBy(xpath="//span[contains(text(), ' Pré inscription')]")
	private WebElement preInscriptionButton;

	@FindBy(xpath="//h1[@class='title']")
	private WebElement title;


	public WebElement getTitle() {
		return title;
	}
	public WebElement getTesteurLogicielAutomatisation() {
		return TesteurLogicielAutomatisation;
	}

	public WebElement getTesteurAutomaticien() {
		return TesteurAutomaticien;
	}

	public WebElement getDevFullStack() {
		return DevFullStack;
	}

	public WebElement getDevApp() {
		return DevApp;
	}

	public WebElement getDesigner() {
		return Designer;
	}

	public WebElement getMarketingDigital() {
		return MarketingDigital;
	}

	public WebElement getRespCom() {
		return RespCom;
	}

	public WebElement getAcquisitionTalent() {
		return AcquisitionTalent;
	}	
	public List<WebElement>  getListofLinks() {
		return ListofLinks;
	}

	public WebElement getCursusPage() {
		return CursusPage;
	}

	public WebElement getPreInscriptionButton() {
		return preInscriptionButton;
	}

}
