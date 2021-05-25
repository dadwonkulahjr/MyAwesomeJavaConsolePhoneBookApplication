import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
	private static List<String> _contactList = new ArrayList<String>();
    private static Scanner s = new Scanner(System.in);
	static int userMenu()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Choose your option");
		System.out.println("to perform operation:");
		System.out.println("1.Add Number");
		System.out.println("2.Delete Number");
		System.out.println("3.Edit Number");
		System.out.println("4.List Numbers");
		System.out.println("6.Quit\n");
		int input = s.nextInt();
		return input;
	}
	static void switchUserInput(int input)
	{
		
		switch(input)
		{
			 case 1:
			 {
				//Will use the dictionary class 
				 //later to store the name of the contact
				 //using key value pairs name - number
				 String numberToList = userMenuToAddOrGoBackToMainMenu("number");
				_contactList.add(numberToList);
				System.out.printf("%s added to contact successfully!\n", numberToList);
				System.out.println("Items in the List size " + _contactList.size());
			    input = userMenu();
			    switchUserInput(input);
				
			 }
			 break;
			 case 2:
			 {
				 if(_contactList.isEmpty())
				 {
					 System.out.println("The contact list is empty.");
					 System.out.println("Select the first option to add contact(s) to the Phonebook.");
					 input = userMenu();
					 switchUserInput(input);
				 }
				 else {
					 getDataIfContactListIsNotEmpty(input);
					
				 }
			 }
			 break;
			 case 3:
			 {
				 
			 }
			 break;
			 case 4:
			 {
				 
			 }
			 break;
			 case 5:
			 {
				 System.out.println("Thank you.... Program is terminating!");
			 }
			 break;
		}
		
	}
	private static void deleteFromContactList(int numberToDelete)
	{
//	    numberToDelete = 0;
		switch(numberToDelete)
		{
			
			case 1:{
			 var result = _contactList.get(numberToDelete-1);
				 if(_contactList.remove(result))
					 {
					 	System.out.println("Number was deleted successfully! " + result);
					 	int input = userMenu();
						switchUserInput(input);
					 }
				 else {
					 System.out.printf("The was an error in deleting the contact"
					 		+ " number %s. Please contact your System Admin", result);
				 }
			 }
			 
			case 2:{
				 var result = _contactList.get(numberToDelete-1);
				 if(_contactList.remove(result))
					 {
					 	System.out.println("Number was deleted successfully! " + result);
					 	int input = userMenu();
						switchUserInput(input);
					 }
				}
			case 3:{
				 var result = _contactList.get(numberToDelete);
				 if(_contactList.remove(result))
					 {
					 	System.out.println("Number was deleted successfully! " + result);
					 	int input = userMenu();
						switchUserInput(input);
					 }
				}
			case 4:{
				 var result = _contactList.get(numberToDelete);
				 if(_contactList.remove(result))
					 {
					 	System.out.println("Number was deleted successfully! " + result);
					 	int input = userMenu();
						switchUserInput(input);
					 }
				}
		}
	}
    static void displayMessage()
	{
		System.out.println("******************************************************");
		System.out.println("Welcome to iamtuse simple Phonebook console application\n"
				+ "build using Java!");
		System.out.println("******************************************************");
	}
    private static String userMenuToAddOrGoBackToMainMenu(String whatToPass)
	{
		System.out.println("Choose your option");
		System.out.println("to perform operation:");
		System.out.format("1.Enter the %s", whatToPass + "\n");
		System.out.println("2.Go back");
		int input = s.nextInt();
		if(input == 1)
		{
			String result = numberEntered();
			return result;
		}
		else
		{
			input = userMenu();
			switchUserInput(input);
		}
		return "";
	}
	private static String numberEntered()
	{
		 System.out.print("Enter the number:");
		 s.nextLine();
		 String number = s.nextLine();
		while(number.isBlank() || number.isEmpty())
		{
			System.out.println("Number cannot be empty.");
			System.out.println("Add a number before proceeding.");
			System.out.println("Enter the number:");
		    number = s.nextLine();
		}
		
       return number;
		
	}
	private static void getDataIfContactListIsNotEmpty(int input)
	{
		 System.out.print("List of all your contact number(s):\n");
		 int i = 0; 
		 for(;i < _contactList.size();i++)
		 {
			 System.out.println(i+1 + " " + _contactList.get(i));
		 }
		 i = 1;
		 System.out.println();
		 System.out.println("Choose your option to perform operation:");
		 System.out.printf(" 1. Choose your option from %s to %s ", i, _contactList.size() + " to delete\n");
		 System.out.println("2. Go Back");
		 input = s.nextInt();
		 
		 if(input == 2)
		 {
			input = userMenu();
			switchUserInput(input);
		 }
		 else
		 {
		     deleteFromContactList(input);
		     switchUserInput(input);
		 }
	 
	}

}
