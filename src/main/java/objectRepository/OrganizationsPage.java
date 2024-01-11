package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgLookUpImage;
	
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewOrgLookUpImg() {
		return createOrgLookUpImage;
	}
	
	//Business Logic.
	/**
	 * This method will click on create organization look up image.
	 */
	public void clickOnCreateNewOrgLookUpImage() {
		createOrgLookUpImage.click();
	}
	
}
