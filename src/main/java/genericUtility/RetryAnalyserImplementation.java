package genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class will provide  implementation  to the IretryAnalyser interface of TestNg
 * @author subham 
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	public boolean retry(ITestResult  result)
	{
		int count =0;
		int retrycount=3;
		while(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
		
	}

}
