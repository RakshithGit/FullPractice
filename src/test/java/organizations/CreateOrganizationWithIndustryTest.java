package organizations;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CreateNewOrganizationsPage;
import objectRepository.HomePage;
import objectRepository.OrganizationsPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateOrganizationWithIndustryTest extends BaseClass {
	
	@Test
	public void createOrganizationWithIndustryTest() throws Throwable {
		//PropertyFileUtility pUtil = new PropertyFileUtility();
		/*ExcelFileUtility eUtil = new ExcelFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility(); 
		
		int randomNum = jUtil.getRandomNumber(); */
		
		//WebDriver driver = null;
		
		/* String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password"); */
		 
		 String ORGNAME = eUtil.readDataFromExcel("Organizations", 4, 2)+jUtil.getRandomNumber();
		 String INDUSTRY = eUtil.readDataFromExcel("Organizations", 4, 3);
		 
		 
		 //Open browser.
		 /* if(BROWSER.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}else if (BROWSER.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}else if (BROWSER.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}else {
				System.out.println("Invalid Browser");
			} */
		 
		
		//Maximize window.
		 wUtil.maximizeWindow(driver);
		//driver.manage().window().maximize();
		
		//Wait.
		 wUtil.waitForPageLoad(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Load URL.
		//driver.get(URL);
		
		//Enter valid credentials and login.
		/* LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD); */
		
		/* driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click(); */
		
		//Locate and click on 'Organizations' section.
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		//driver.findElement(By.linkText("Organizations")).click();
		
		//Click on create new organization look up image.
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgLookUpImage();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Enter an organization name.
		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
		/* driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Select industry type from drop down.
		WebElement dropDown = driver.findElement(By.name("industry"));
		Select sel = new Select(dropDown);
		sel.selectByValue(INDUSTRY);
		
		//Save.
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); */
		
		//Verify.
		String orgInfoText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgInfoText);
		
		Assert.assertTrue(orgInfoText.contains(ORGNAME));
		
		//if(orgInfoText.contains(ORGNAME))
		//{
			System.out.println("The organization has been successfully created.");
			System.out.println("Name of the organization is: "+orgInfoText);
		//}else {
		//	System.out.println("Organization not created");
		//}
		
		//Logout of application.
		//hp.logoutOfApp(driver);
		/* WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		driver.findElement(By.linkText("Sign Out")).click(); */
		
		//Quit browser.
		//driver.quit();
	}

}
