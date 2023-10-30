package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consist of generic method to read the data from excel sheet
 */
public class PropertyFileUtility {

	/**
	 * this method will read the data from property file and return the value
	 * @author HP
	 * @throws Throwable 
	 */
	public String readDatafromPropertyFile(String key) throws Throwable
	{
   FileInputStream fis = new FileInputStream("src/test/resources/commmondata.properties");
   Properties poj = new Properties();
   poj.load(fis);
   String value = poj.getProperty(key);
   return value;
   
	}
}

