package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	//Business Logic.
	/**
	 * This method returns Contact Header Text.
	 * @return
	 */
	public String getContactHeader() {
		return contactHeaderText.getText();
	}
	
	
}
