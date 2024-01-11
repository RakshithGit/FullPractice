package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement orgLookUpImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id = "search_txt")
	private WebElement orgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement orgSearchBtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	
	//Business Logic.
	/**
	 * This method will create contact with mandatory field.
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create contact using Organization.
	 * @param LASTNAME
	 * @param ORGNAME
	 * @param driver
	 */
	public void createNewContact(String LASTNAME, String ORGNAME, WebDriver driver) {
		lastNameEdt.sendKeys(LASTNAME);
		orgLookUpImg.click();
		switchTowindow(driver, "Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click(); //or driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		// Here, . is shortform for text() in Xpath
		switchTowindow(driver, "Contacts");
		saveBtn.click();
	}
	
	
}
