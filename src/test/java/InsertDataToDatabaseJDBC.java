import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataToDatabaseJDBC {

	public static void main(String[] args) throws Throwable {
		Driver driverJDBC = new Driver();
		DriverManager.registerDriver(driverJDBC);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "root", "tiger");
		Statement stat = connection.createStatement();
		String query = "insert into student_info(first_name,last_name,address)values('Rajni','Kanth','TamilNadu')";
		int result = stat.executeUpdate(query); //Here we use executeUpdate();
		if(result==1) { // The executeUpdate() method returns the number of rows affected. So the return type is int.
			System.out.println("The table has been updated");
		}else {
			System.out.println("The table has not been updated");
		}
	}

}
