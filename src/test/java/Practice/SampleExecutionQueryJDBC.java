package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecutionQueryJDBC {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new Driver();
		//step1 Register the driver
		DriverManager.registerDriver(driver);
		
		//step2 get connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
		
		//step3 issue create statement
		Statement state = con.createStatement();
		
		//step4 execute a story
		ResultSet result = state.executeQuery("select*from empinfo;");
		while(result.next())
		{
			String value = result.getString(1);
			System.out.println(value);
		}
		//step5 close the database
		con.close();
		

	}

}
