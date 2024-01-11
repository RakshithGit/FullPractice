package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutBtn;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactBtn;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}

	public WebElement getContactBtn() {
		return contactBtn;
	}
	
	//Business Logic.
	/**
	 * This method will click on the organization link.
	 */
	public void clickOnOrganizationLink() {
		orgLink.click();
	}
	
	/**
	 * This method will perform mouse hover action on the web element and will click on sign out option.
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver) {
		mouseHoverAction(driver, administratorImg);
		signOutBtn.click();
	}
	
	/**
	 * This method will click on contact link.
	 */
	public void clickOnContactLink() {
		contactBtn.click();
	}
	
	
}
