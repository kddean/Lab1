import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlConnector {


public MySqlConnector() {
			try {
				// The newInstance() call is a work around for some
				// broken Java implementations

				Class.forName("com.mysql.jdbc.Driver").newInstance();
				System.out.println("JDBC driver registered");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
}

		private Connection getConnection() {
			try {
				Connection conn = DriverManager
						.getConnection("jdbc:mysql://localhost/world?" + "user=root&password=cake");

				System.out.println("Got Mysql database connection");
				return conn;
			} catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
			return null;
		}
}
		