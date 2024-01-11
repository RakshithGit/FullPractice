package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationsPage extends WebDriverUtility {
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewOrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Logic.
	/**
	 * This method will create Organization using mandatory fields.
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME) {
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create Organization by handling industry drop down.
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRY) {
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown, INDUSTRY);
		saveBtn.click();
	}
}
