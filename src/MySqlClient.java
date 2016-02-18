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
		System.out.println("What would you like to do? (Insert, Update, List, Delete)");
		String a = "";
		a = s.nextLine();
		String input = "";
		int input2;
		
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
		else if (a == "List")
		{
			
		}
		else if (a.equals("Delete"))
		{
			System.out.println("Please enter an id to delete.");
			input2 = s.nextInt();
			connector.delete(input2);
		}
		else 
			System.out.println("That's not an option.");
	}	
}
