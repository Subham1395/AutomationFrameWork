package Practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReaddataFormPropertiesFile {
	public static void main(String[] args) throws Throwable {
		//step1- create and give the path of the properties file
		FileInputStream fis = new FileInputStream("src/test/resources/commondata.properties.txt");
		
		//step2- Create the object for PropertiesClass which is comes form Java.util.package
		Properties poj = new Properties();
		poj.load(fis);
		
		//step3- get the properties from property
		String Browser = poj.getProperty("browser");
		String Url = poj.getProperty("url");
		String Username = poj.getProperty("username");
		String Passwprd = poj.getProperty("password");
		
       //step4- print the statement 
		System.out.println(Browser);
		System.out.println(Url);
		System.out.println(Username);
		System.out.println(Passwprd);
	}
}
