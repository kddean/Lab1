
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MySqlClient {

	public static MySqlConnector connector;
	
	public MySqlClient()
	{
		connector = new MySqlConnector();
	}
	
	public static void main(String[] args)
	{
		MySqlClient client = new MySqlClient();
		Scanner s = new Scanner(System.in);
		connector.createTable();
		
		String a = "";
		
		String input = "";
		int input2;
		
		while(!a.equals("Exit"))
		{System.out.println("What would you like to do? (Insert, Update, List, Delete, Exit)");
		a = s.nextLine();
		if (a.equals("Insert"))
		{
			System.out.println("Please enter a message.");
			input = s.nextLine();
			connector.insert(input);
		}
		else if (a.equals("Update"))
		{
			System.out.println("Please enter an id.");
			input2 = s.nextInt();
			System.out.println("Please enter a new message.");
			input = s.nextLine();
			connector.post(input2, input);
		}
		else if (a.equals("List"))
		{
			Map<Integer, String> list = new HashMap<Integer, String>();
			list = connector.getList();
			System.out.println(list);
		}
		else if (a.equals("Delete"))
		{
			System.out.println("Please enter an id to delete.");
			input2 = s.nextInt();
			connector.delete(input2);
		}
		else if (a.equals("Exit"))
		{
			break;
		}
		else 
			System.out.println("That's not an option.");
		}
	}	
}
