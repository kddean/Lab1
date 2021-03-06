import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/world?" + "user=root&password=cake");

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
		
		public Map<Integer, String> getList()
		{
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Connection con = null;
			try{
				Map<Integer, String> messages = new HashMap<Integer, String>();
				
				con = getConnection();
				
				stmt = con.prepareStatement("select * from ToDoList");
				rs = stmt.executeQuery();
				while (rs.next()){
					ToDoItem item = new ToDoItem();
					item.setid(rs.getInt("id"));
					item.setMessage(rs.getString("message"));
					item.setDate(rs.getString("date"));
					messages.put(item.getid(), item.getMessage());
				}return messages;
			} catch (SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}finally{
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException sqlEx) {
					} // ignore

					rs = null;
				}

				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException sqlEx) {
					} // ignore

					stmt = null;
				}
				if(con != null){
					try {
						con.close();
					} catch (SQLException sqlEx) {
					} // ignore

					con = null;
				}

			}
			return null;
			
		}
		
		public boolean get(int askforid)
		{
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Connection con = null;
			
			try{
				con = getConnection();
				
				stmt = con.prepareStatement("select message form ToDoList where id = askforid");
			} catch (SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException sqlEx) {
					} // ignore

					rs = null;
				}

				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException sqlEx) {
					} // ignore

					stmt = null;
				}
				if(con != null){
					try {
						con.close();
					} catch (SQLException sqlEx) {
					} // ignore

					con = null;
				}

			}
			return false;
			
		}
		
		public boolean delete(int givenid)
		{
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Connection con = null;
			
			try{
				con = getConnection();
				
				stmt = con.prepareStatement("delete from ToDoList where id = givenid");
			} catch (SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException sqlEx) {
					} // ignore

					rs = null;
				}

				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException sqlEx) {
					} // ignore

					stmt = null;
				}
				if(con != null){
					try {
						con.close();
					} catch (SQLException sqlEx) {
					} // ignore

					con = null;
				}

			}
			return false;
		}
		public boolean post(int givenid, String m)
		{
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Connection con = null;
			
			try{
				con = getConnection();
				
				stmt = con.prepareStatement("update ToDoList set message = m where id = givenid");
				stmt.executeUpdate();
			} catch (SQLException ex){
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException sqlEx) {
					} // ignore

					rs = null;
				}

				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException sqlEx) {
					} // ignore

					stmt = null;
				}
				if(con != null){
					try {
						con.close();
					} catch (SQLException sqlEx) {
					} // ignore

					con = null;
				}

			}
			return false;
		}
		public void createTable()
		{
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Connection con = null;
			try{
				
			con = getConnection();
			stmt = con.prepareStatement("create table ToDoList(id int not null primary key, message varchar(65), date DateTime)");
			stmt.executeUpdate();
		}catch (SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
			if(con != null){
				try {
					con.close();
				} catch (SQLException sqlEx) {
				} // ignore

				con = null;
			}

		}
	}
		public void insert(String m)
		{
			PreparedStatement stmt = null;
			ResultSet rs = null;
			Connection con = null;
			java.util.Date date = new java.util.Date();
			
			try{
				con = getConnection();
				stmt = con.prepareStatement("insert into ToDoList (message, date) values(?,?)");
				stmt.setString(1, m);
				stmt.setTimestamp(2, new Timestamp(date.getTime()));
				stmt.executeUpdate();
			}catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			} finally {
				// it is a good idea to release
				// resources in a finally{} block
				// in reverse-order of their creation
				// if they are no-longer needed

				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException sqlEx) {
					} // ignore

					rs = null;
				}

				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException sqlEx) {
					} // ignore

					stmt = null;
				}
				if(con != null){
					try {
						con.close();
					} catch (SQLException sqlEx) {
					} // ignore

					con = null;
				}

			}
		}
		
}
		