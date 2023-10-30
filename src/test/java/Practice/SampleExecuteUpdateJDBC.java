package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteUpdateJDBC {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new Driver();
		//step1 Register the driver
		DriverManager.registerDriver(driver);
		//step2 get connection with data base
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
		
		//step3 issue create statement
		Statement state = con.createStatement();
		//step4 execute a query
		String query="insert into empinfo values('rohit',17,'sitapur');";
		 int result = state.executeUpdate(query);
		 if(result==1)
		 {
			 System.out.println("data added successfully");
		 }
		//step5 close the data base
          con.close();
	}

}
