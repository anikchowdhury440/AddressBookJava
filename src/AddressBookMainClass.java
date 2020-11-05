import java.util.Scanner;

public class AddressBookMainClass {
	public static void main(String[] args) {
		AddressBook addressbook = new AddressBook();
		Scanner sc = new Scanner(System.in);
		boolean isTerminate = false;
		while(!isTerminate)
		{
			System.out.println("1.Add AddressBook");
			System.out.println("2.Add Person in Address Book");
			System.out.println("3.Display Person in Address Book");
			System.out.println("4.Edit Person in Address Book");
			System.out.println("5.Delete Person in Address Book");
			System.out.println("6.Search Person");
			System.out.println("7.Sort Person");
			System.out.println("8.Exit program");
			System.out.println("Enter Your Choice: ");
			int option = sc.nextInt();
			switch(option)
			{
				case 1:
					addressbook.createAddressBook();
					break;
				case 2:
					addressbook.addPerson();
					break;
				case 3:
					addressbook.displayPerson();
					break;
				case 4:
					addressbook.editPerson();
					break;
				case 5:
					addressbook.deletePerson();
					break;
				case 6:
					addressbook.searchPerson();
					break;
				case 7:
					addressbook.sortPerson();
					break;
				case 8:
					isTerminate = true;
					break;
				default:
					System.out.println("Please enter valid input.");
			}
		}
	}
}
