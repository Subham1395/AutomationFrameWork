package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * this class provides implementation to ITestListners of testNG
 */
public class ListenerImplementationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScripteName = result.getMethod().getMethodName();
		System.out.println(testScripteName+"===test scripte executon starts=====");
		
		//create a test script - recognise each @Test
		 test = report.createTest(testScripteName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScripteName = result.getMethod().getMethodName();
		System.out.println(testScripteName+"===passeed=====");
		
		//log the success
		test.log(Status.PASS, testScripteName+"=====passed=====");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot
		//exception the failure 
		
		String testScripteName = result.getMethod().getMethodName();
		System.out.println(testScripteName+"===failed=====");
		//Exception for failure
		System.out.println(result.getThrowable());
		
		//log for failure
		test.log(Status.FAIL, testScripteName+"====failed=====");
		test.log(Status.INFO, result.getThrowable());
		
		//screenshot
		String ScreenShotName = testScripteName + new JavaUtility().getSystemDate();
		WebDriverUility w = new WebDriverUility();
		try {
			String path = w.captureScreenShot(BaseClass.sdriver, ScreenShotName);      // giving the path name for using getabolutepath() to getting the location of file
		test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScripteName = result.getMethod().getMethodName();
		System.out.println(testScripteName+"===skipped=====");
		test.log(Status.SKIP, testScripteName+"======skipped======");
		test.log(Status.INFO,result.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("===suite executon starts=====");
		
		//basic report configuration //report -17-10-2023-8-04-23.html
		ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtentReporter\\Report-"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("execution report");
		html.config().setReportName("vtiger ecution");
		
		 report = new ExtentReports();
		 report.attachReporter(html);
		 report.setSystemInfo("browser version", "chrome");
		 report.setSystemInfo("base platform", "window");
		 report.setSystemInfo("base enviorement", "testing");
		 report.setSystemInfo("reporter name", "subham");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("===suite executon finish=====");
		
		//report generation
		report.flush();
		
	}
	

}
