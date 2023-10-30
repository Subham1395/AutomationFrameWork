package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consist of generic method related to java specific generic method
 * @author HP
 */
public class JavaUtility {
	/**
	 * this method will return the number every run and give value 
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran = new Random();
		int rannum = ran.nextInt(1000);
		return rannum;
	}
	/**
	 * this method will use to capture the date in required format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String date = formatter.format(d);
		return date;
	}
	
	 

}
