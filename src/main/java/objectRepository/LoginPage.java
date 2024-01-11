package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name = "user_name")
	private WebElement usernameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Logic.
	/**
	 * This method will login to the application.
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApplication(String USERNAME, String PASSWORD) {
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

	
}
