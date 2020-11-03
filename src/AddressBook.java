import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	
	List<Person> personlist = new LinkedList<Person>();
	Scanner scanner = new Scanner(System.in);
	
	public void addPerson()
	{
		Person person = new Person();
		
		System.out.println("Enter First Name");
        String fName = scanner.nextLine();
        System.out.println("Enter Last Name");
        String lName = scanner.nextLine();
        System.out.println("Enter Address");
        String address = scanner.nextLine();
        System.out.println("Enter City Name");
        String city = scanner.nextLine();
        System.out.println("Enter the Zip Code");
        String zip = scanner.nextLine();
        System.out.println("Enter State Name");
        String state = scanner.nextLine();
        System.out.println("Enter Phone Number");
        String phone = scanner.nextLine();
        System.out.println("Enter Email Id");
        String email = scanner.nextLine();
        
        person.setfName(fName);
        person.setlName(lName);
        person.setAddress(address);
        person.setCity(city);
        person.setZip(zip);
        person.setState(state);
        person.setPhone(phone);
        person.setEmail(email);
        
        personlist.add(person);
        
        System.out.println("Contact Added");

	}
	
	public void displayPerson() {
		Iterator iterator = personlist.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	
	public void editPerson() {
		
		System.out.println("Enter First Name do you want to edit: ");
		String enteredFirstName = scanner.nextLine();
	
		int choice = 0, contactFound = 0;
		
		for (int index = 0; index < personlist.size(); index++) 
		{
			String fname = personlist.get(index).getfName();
			if(fname.equalsIgnoreCase(enteredFirstName)) 
			{
				contactFound = 1;
				do {
					choice = 0;
					System.out.println("1: Edit First name \n" +
										"2: Edit Last Name \n" +
										"3: Edit Address \n" +
										"4: Edit City \n" +
										"5: Edit State \n" +
										"6: Edit Zip \n" +
										"7: Edit PhoneNumber \n" +
			                	   		"8. Edit Email");
					System.out.println("Enter Your choice: ");
	 
					int selectedOption = scanner.nextInt();
					scanner.nextLine();
	 
					switch (selectedOption) {
						case 1:
							System.out.println("Enter First Name ");
							String fName = scanner.nextLine();
							personlist.get(index).setfName(fName);
							break;
						case 2:
							System.out.println("Enter Last Name");
							String lName = scanner.nextLine();
							personlist.get(index).setlName(lName);
							break;
						case 3:
							System.out.println("Enter Address");
							String address = scanner.nextLine();
							personlist.get(index).setAddress(address);
							break;
						case 4:
							System.out.println("Enter City");
							String city = scanner.nextLine();
							personlist.get(index).setCity(city);
							break;
						case 5:
							System.out.println("Enter State");
							String state = scanner.nextLine();
							personlist.get(index).setState(state);
							break;
						case 6:
							System.out.println("Enter Zip Code");
							String zip=scanner.nextLine();
							personlist.get(index).setZip(zip);
							break;
						case 7:
							System.out.println("Enter Phone Number");
							String phone = scanner.nextLine();
							personlist.get(index).setPhone(phone);
							break;
						default:
							System.out.println("please select valid option");
							choice = 1;
					}	
				
					if(choice == 0)
					{
						System.out.println("Do You want to edit anything? If yes Press 1");
						choice = scanner.nextInt();
						scanner.nextLine();
					}	
				
				} while(choice == 1);
				
				System.out.println("Contact Updated");
			
			}		 	 
		}
		
		if(contactFound == 0)
		{
			System.out.println("Contact doesn't exist");
		}
		
	}
	
	public void deletePerson() {
		System.out.println("Enter First Name do you want to delete: ");
		String enteredFirstName = scanner.nextLine();
		int contactFound = 0;
		
		for (int index = 0; index < personlist.size(); index++) 
		{
			String fName = personlist.get(index).getfName();
			if(fName.equalsIgnoreCase(enteredFirstName)) 
			{
				contactFound = 1;
				personlist.remove(index);
				System.out.println("Contact Deleted");
			}
		}
		
		if (contactFound == 0)
		{
			System.out.println("Contact not found");
		}
	}

}
