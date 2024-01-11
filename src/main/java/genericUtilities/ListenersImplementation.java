package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String method = result.getMethod().getMethodName();
		System.out.println(method+"----- Test Script Execution Started -----");
		
		//Create a test in Extent Report.This will tell/invoke the report that the test has started.
		test = report.createTest(method);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String method = result.getMethod().getMethodName();
		//System.out.println(method+"----- PASS -----");
		
		test.log(Status.PASS, method+"----- PASS -----");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String method = result.getMethod().getMethodName();
		System.out.println(result.getThrowable());
		//System.out.println(method+"----- FAIL -----");
		
		test.log(Status.FAIL, method+"----- FAIL -----");
		test.log(Status.INFO, result.getThrowable());
		
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		String screenshotName = method+jUtil.getSystemDate();
		
		try {
			String path = wUtil.captureScreenshot(BaseClass.sdriver, screenshotName); //This is from the base class.
			//add scrennshot  to the report.
			test.addScreenCaptureFromPath(path);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String method = result.getMethod().getMethodName();
		
		System.out.println(result.getThrowable());
		//System.out.println(method+"----- SKIP -----");
		
		test.log(Status.FAIL, method+"----- SKIP -----");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) { //onStart() and onFinish() methods work at Suite level.
		// TODO Auto-generated method stub
		System.out.println("----- Suite Execution Started -----");
		
		//Configure Extent Report.
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setReportName("Automation Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base URL", "http://localhost:8888/index.php?action=Login&module=Users");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Rakshith");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("----- Suite Execution Finished -----");
		report.flush();
	}
	
}
