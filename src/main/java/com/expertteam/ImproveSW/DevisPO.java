package com.expertteam.ImproveSW;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DevisPO extends PageObject {

	public DevisPO(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//span[contains(text(), 'Demander un devis')]")
	private WebElement DemandeDevisPage;

	@FindBy(xpath="//input[@value='Particulier']")
	private WebElement ParticulierChecbox;

	@FindBy(xpath="//input[@value='Assujettie à la TVA']")
	private WebElement AssujettieTVA;

	@FindBy(xpath="//select[@name='thme-formation']")
	private WebElement formation;

	@FindBy(xpath="//option[@value='Tests de Logiciels']")
	private WebElement TestsLogiciels;

	@FindBy(xpath="//input[@name='your-autre']")
	private WebElement MyOther;

	@FindBy(xpath="//input[@name='nombre_personnes']")
	private WebElement NBPersonnne;

	@FindBy(xpath="//input[@value='Intra-Entreprise']")
	private WebElement IntraEntrepriseChecbox;

	@FindBy(xpath="//input[@name='your-date']")
	private WebElement YourDate;

	@FindBy(xpath="//input[@name='your-name']")
	private WebElement YourName;

	@FindBy(xpath="//input[@name='your-tel']")
	private WebElement YourTel;

	@FindBy(xpath="//input[@name='your-email']")
	private WebElement YourEmail;

	@FindBy(xpath="//select[@name='your-job']")
	private WebElement YourJob;

	@FindBy(xpath="//select[@value='Travailleur indépendant']")
	private WebElement TravIndep;

	@FindBy(xpath="//input[@name='your-company']")
	private WebElement YourCompany;

	@FindBy(xpath="//input[@value='Urgente']")
	private WebElement PerioriteUrgente;

	@FindBy(xpath="//input[@value='Moyenne']")
	private WebElement PerioriteMoyenne;

	@FindBy(xpath="//input[@value='Normale']")
	private WebElement PerioriteNormale;

	@FindBy(xpath="//input[@value='Email']")
	private WebElement ContactEmail;

	@FindBy(xpath="//input[@value='Tél']")
	private WebElement ContactTel;

	@FindBy(xpath="//input[@value='Contact Direct']")
	private WebElement ContactDirect;

	@FindBy(xpath="//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
	private WebElement RecaptchaFrame;

	@FindBy(xpath="//div[starts-with(@class, 'recaptcha-checkbox-border') and starts-with(@role, 'presentation')]")
	private WebElement RecaptchaBox;

	@FindBy(xpath="//input[@value='Envoyer']")
	private WebElement SendButton;

	@FindBy(xpath="//span[@role='alert']")
	private List<WebElement> ErrorX;


	public WebElement getDemandeDevisPage() {
		return DemandeDevisPage;
	}

	public WebElement getParticulierChecbox() {
		return ParticulierChecbox;
	}

	public WebElement getAssujettieTVA() {
		return AssujettieTVA;
	}

	public WebElement getFormation() {
		return formation;
	}
	public WebElement getTestsLogiciels() {
		return TestsLogiciels;
	}


	public WebElement getMyOther() {
		return MyOther;
	}

	public WebElement getNBPersonnne() {
		return NBPersonnne;
	}

	public WebElement getIntraEntrepriseChecbox() {
		return IntraEntrepriseChecbox;
	}

	public WebElement getYourDate() {
		return YourDate;
	}

	public WebElement getYourName() {
		return YourName;
	}

	public WebElement getYourTel() {
		return YourTel;
	}

	public WebElement getYourEmail() {
		return YourEmail;
	}

	public WebElement getYourJob() {
		return YourJob;
	}

	public Select getSelectJob()
	{
		return new Select(getYourJob());
	}


	public WebElement getTravIndep() {
		return TravIndep;
	}

	public WebElement getYourCompany() {
		return YourCompany;
	}
	public WebElement getPerioriteUrgente() {
		return PerioriteUrgente;
	}

	public WebElement getPerioriteMoyenne() {
		return PerioriteMoyenne;
	}

	public WebElement getPerioriteNormale() {
		return PerioriteNormale;
	}

	public WebElement getContactEmail() {
		return ContactEmail;
	}

	public WebElement getContactTel() {
		return ContactTel;
	}

	public WebElement getContactDirect() {
		return ContactDirect;
	}

	public WebElement getRecaptchaFrame() {
		return RecaptchaFrame;
	}

	public WebElement getRecaptchaBox() {
		return RecaptchaBox;
	}

	public WebElement getSendButton() {
		return SendButton;
	}
	public List<WebElement> getErrorX() {
		return ErrorX;
	}



}
