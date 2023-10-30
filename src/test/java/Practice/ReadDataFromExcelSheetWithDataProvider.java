package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetWithDataProvider {
	
	@Test(dataProvider= "getdata")
	public void readDataFromWithDataProvider(String Name, int Price, int qnty)
	{
		System.out.println("product name"+Name+  "product price"+Price+  "Quantiy"+qnty);
	}
	
	@DataProvider
	public Object[][] getdata()
	
	{
		Object[][] obj= new Object[3][3];
		obj[0][0]="Samsung";
		obj[0][1]= 50000;
		obj[0][2]= 10;
		
		obj[1][0]= "Nokia";
		obj[1][1]= 70000;
		obj[1][2]= 20;
		
		obj[2][0]= "Apple";
		obj[2][1]= 90000;
		obj[2][2]= 30;
		
		return obj;
	}

}
