package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SocialMediaPO extends PageObject {

	public SocialMediaPO(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(xpath="//div[@id='Action_bar']//a[@title='YouTube']")
	private WebElement youtubeHeader;

	@FindBy(xpath="//div[@id='Action_bar']//a[@title='Instagram']")
	private WebElement instagramHeader;

	@FindBy(xpath="//div[@id='Action_bar']//a[@title='Facebook']")
	private WebElement facebookHeader;

	@FindBy(xpath="//div[@id='Action_bar']//a[@title='LinkedIn']")
	private WebElement linkedInHeader;

	public WebElement getFacebookHeader() {
		return facebookHeader;
	}

	public WebElement getLinkedInHeader() {
		return linkedInHeader;
	}

	public WebElement getYoutubeHeader() {
		return youtubeHeader;
	}

	public WebElement getInstagramHeader() {
		return instagramHeader;
	}

}
