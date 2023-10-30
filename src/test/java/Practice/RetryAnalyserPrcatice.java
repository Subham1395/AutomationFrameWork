package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPrcatice {
@Test(retryAnalyzer=genericUtility.RetryAnalyserImplementation.class)
	public void analyserPractice() {
		// TODO Auto-generated method stub
		Assert.fail();
      System.out.println("hi");
	}

}
