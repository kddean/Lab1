import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToDoItem {

	private String message;
	private int id;
	private String date;
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public int getid()
	{
		return id;
	}
	
	public void setid(int id)
	{
		this.id = id;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String toString()
	{
		return "Id:" + id + " Message: " + message + "Date: " + date;
	}
	
	
}