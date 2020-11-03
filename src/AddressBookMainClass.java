import java.util.Scanner;

public class AddressBookMainClass {
	public static void main(String[] args) {
		AddressBook addressbook = new AddressBook();
		Scanner sc = new Scanner(System.in);
		boolean isTerminate = false;
		while(!isTerminate)
		{
			System.out.println("1.Add Person to Address Book");
			System.out.println("2.Display Person to Address Book");
			System.out.println("3.Exit program");
			System.out.println("Enter Your Choice: ");
			int option = sc.nextInt();
			switch(option)
			{
				case 1:
					addressbook.addPerson();
					break;
				case 2:
					addressbook.displayPerson();
					break;
				case 3:
					isTerminate = true;
					break;
				default:
					System.out.println("Please enter valid input.");
			}
		}
	}
}
