package Practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class WriteTheDataToPropertiesFile {

	public static void main(String[] args) throws Throwable {
	//step1 create the object of Properties file
		Properties poj = new Properties();
		
		//step2 use setter method to write the data
		poj.setProperty("browser", "chrome");
		poj.setProperty("username", "admin");
		poj.setProperty("password", "manager");
		
		//step3 store the data intoProperties file
		FileOutputStream fos = new FileOutputStream("src/test/resources/commondata.properties.txt");
		poj.store(fos, "commondata");
		System.out.println("data store successfull");

	}

}
