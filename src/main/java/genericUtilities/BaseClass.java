package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/**
 * This is a generic class consisting of all basic configuration annotations of TestNG.
 * @author Rakshith
 *
 */
public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver = null;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true) //or we can also give (groups = "SmokeSuite") to all the annotations.
	public void bsConfig() {
		System.out.println("=========== Dababase Connection Successful ============");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajat\\.cache\\selenium\\geckodriver\\win64\\0.34.0\\geckodriver.exe");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		
		wUtil.maximizeWindow(driver);
		
		wUtil.waitForPageLoad(driver);
		
		driver.get(URL);

		sdriver = driver;
		
		System.out.println(BROWSER+" ======= Browser Launched Successfully ======= ");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws Throwable {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApplication(USERNAME, PASSWORD);
		
		System.out.println("====== Login Successful ======");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("====== Logout Successful ======");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		
		driver.quit();
		
		System.out.println("======= Browser Closed Successfully =======");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("=========== Dababase Connection Closed ============");
	}
	
	
}
