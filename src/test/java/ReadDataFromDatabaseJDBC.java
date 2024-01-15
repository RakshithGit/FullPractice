import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromDatabaseJDBC {

	public static void main(String[] args) throws Throwable {
		Driver jdbcDriver = new Driver();
		DriverManager.registerDriver(jdbcDriver); //We need to register the driver.
		
		//Next, we need to get connection. Connection is an interface.
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "root", "tiger");
		
		//Use the createStatement() method in Connection interface.
		Statement stat = connection.createStatement();
		
		//Store the query in the form of String.
		String query = "select * from student_info";
		
		//Use the executeQuery() method present in Statement interface.
		ResultSet result = stat.executeQuery(query);
		
		//next(), getString() are methods of ResultSet Interface.
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		connection.close(); //Close the connection.
	}
}
