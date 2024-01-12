package contacts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationsPage;
import objectRepository.HomePage;
import objectRepository.OrganizationsPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass{
	
	@Test(groups = "SmokeSuite") //For group execution, the jvm looks only for annotations that contain groups keyword.
	//Therefore, even if we have another @Test annotation, only the @Test that has group keyword is executed.
	public void createContactWithOrganizationTest() throws Throwable {  
		/*Random ran = new Random();
		int randomNumber = ran.nextInt(1000);*/
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajat\\.cache\\selenium\\geckodriver\\win64\\0.34.0\\geckodriver.exe");
		wUtil.waitForPageLoad(driver);
		
		/*PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility(); 
		
		WebDriver driver = null;
		
		//Read file in java-readable format.
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/*FileInputStream fsp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fsp);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password"); */
		
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 3);
		String INDUSTRY = eUtil.readDataFromExcel("Organizations", 4, 3);
		/*FileInputStream fse = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fse);
		String ORGNAME = wb.getSheet("Contacts").getRow(4).getCell(2).getStringCellValue()+randomNumber;
		String LASTNAME = wb.getSheet("Contacts").getRow(4).getCell(3).getStringCellValue();*/
		
		//Launch new firefox browser.
		/*if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		
		
		//Maximize the window.
		wUtil.maximizeWindow(driver);
		//driver.manage().window().maximize();
		
		//Wait
		wUtil.waitForPageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Go to the website.
		driver.get(URL);
		
		//Enter valid credentials and login to the application.
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		/*WebElement usernameTxtField = driver.findElement(By.name("user_name"));
		WebElement pwdTxtField = driver.findElement(By.name("user_password"));
		usernameTxtField.sendKeys(USERNAME);
		pwdTxtField.sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		//Find the Organizations section in the homepage and click on it.
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		//driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("Clicked on Organizations link.");
		
		//Click on create new Organizations look up image.
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgLookUpImage();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Reporter.log("Clicked on create new organization look-up image.");
		
		//Enter organization name.
		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
		//WebElement organizationNameTextField = driver.findElement(By.name("accountname"));
		//organizationNameTextField.sendKeys(ORGNAME);
		
		//Select Industry type.
		
		//WebElement industry = driver.findElement(By.name("industry"));
		//wUtil.handleDropDown(industry, INDUSTRY);
		/*Select sel = new Select(industry);
		sel.selectByValue(INDUSTRY);*/
		
		//Save the created organization.
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("Organization created.");
		
		//Verify.
		String orgName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(orgName.contains(ORGNAME));
		//if (orgName.contains(ORGNAME)) {
			System.out.println("The organization has been successfully created");
			System.out.println("The organization name is "+ORGNAME);
		//}else {
		//	System.out.println("The organization has not been successfully created");
		//}
			
		//Assert.fail(); 
			
		//Click on Contacts link.
		hp.clickOnContactLink();
		//driver.findElement(By.linkText("Contacts")).click();
		Reporter.log("Clicked on Contacts link.");
		
		//Click on create new contact lookup image.
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		/*WebElement contactLookUpImage = driver.findElement(By.xpath("//img[@title='Create Contact...']"));
		contactLookUpImage.click();*/
		
		Reporter.log("Clicked on create new contact look-up image.");
		
		//Enter all mandatory fields.
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, ORGNAME, driver);
		/*WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys(LASTNAME);
		
		//Click on organization look up image and switch the control to the new organizations window.
		String mainWinID = driver.getWindowHandle();
		WebElement orgLookUpImg = driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img"));
		orgLookUpImg.click();
		Set<String> allWinID = driver.getWindowHandles();
		for (String singleWin : allWinID) {
			if (!singleWin.contains(mainWinID)) {
				wUtil.switchTowindow(driver, singleWin);
				//driver.switchTo().window(singleWin);
				System.out.println("Switching driver to new window is successful");
				Thread.sleep(2000);
				break;
			}
		}
		
		//Search for the organization name in the search box.
		WebElement searchField = driver.findElement(By.id("search_txt"));
		searchField.sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		
		//Select the orgname required.
		driver.findElement(By.xpath("//a[contains(text(), 'Nokia')]")).click();
		
		//Switch back to main window.
		wUtil.switchTowindow(driver, mainWinID);
		//driver.switchTo().window(mainWinID);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
		Reporter.log("Contact created.");
		
		//Verify.
		String contactName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(contactName.contains(LASTNAME));
		
		//if (contactName.contains(LASTNAME)) {
			System.out.println("The contact has been successfully created");
			System.out.println("The contact name is "+contactName);
		//} else {
		//	System.out.println("The contact has not been successfully created");
		//}
		
		//Sign out.
		//hp.logoutOfApp(driver);
		//WebElement signOutImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//wUtil.mouseHoverAction(driver, signOutImg);
		/*Actions act = new Actions(driver);
		act.moveToElement(signOutImg).perform();*/
		//driver.findElement(By.linkText("Sign Out")).click();
		
		//Close the browser.
		//driver.quit();
	}

}
