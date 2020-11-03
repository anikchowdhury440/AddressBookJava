import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	
	Map<String, List<Person>> addressBook = new HashMap<String, List<Person>>();
	String[] addressList = new String[20];
	int countAddressbook = 0;
	String addressKey;
	Scanner scanner = new Scanner(System.in);
	
	public void createAddressBook() {	
		System.out.println("Enter the name of address book do you want to create: ");
		addressList[countAddressbook] = scanner.nextLine();
		addressBook.put(addressList[countAddressbook], new LinkedList<Person>());
		countAddressbook++;
		System.out.println("Address Book Created");	
	}
	
	public void getAddressBook() 
	{
		System.out.println("Your Address Book are: ");
		
		for (int addressSelect = 0; addressSelect < countAddressbook; addressSelect++) {
			System.out.println(addressSelect+1 + " " + addressList[addressSelect]);
		}		
	}
	
	public void selectAddressBook()
	{
		int correctChoice=0;
		
		while ( correctChoice==0 ) 
		{
			System.out.println("Please Select Your address book");
			int select = scanner.nextInt();
			try
			{
				addressKey = addressList[select-1];
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Please select correct addressbook ");
				continue;
			}
			scanner.nextLine();
			
			if (addressBook.get(addressKey)!=null)
			{
				correctChoice=1;
			}	
			else
			{
				System.out.println("Please select correct addressbook");
			}
		}
	}
	
	public void addPerson()
	{
		if(countAddressbook == 0)
		{
			System.out.println("There is no Address Book present. Please Create one AddressBook");
			return;
		}
		
		getAddressBook();
		selectAddressBook();
		
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
        
        List<Person> personList = addressBook.get(addressKey);
        personList.add(person);
        addressBook.put(addressKey,personList);
        
        System.out.println("Contact Added");

	}
	
	public void displayPerson() {
		if(countAddressbook == 0)
		{
			System.out.println("There is no Address Book present. Please Create one AddressBook");
			return;
		}
		
		getAddressBook();
		selectAddressBook();
		
		List<Person> personList = addressBook.get(addressKey);
		
		if(personList.size()==0)
		{
			System.out.println("No Contact Found");
		}
		else { 
			Iterator iterator = personList.iterator();
			while(iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
	}
	
	
	public void editPerson() {
		if(countAddressbook == 0)
		{
			System.out.println("There is no Address Book present. Please Create one AddressBook");
			return;
		}
		
		getAddressBook();
		selectAddressBook();
		
		List<Person> personList = addressBook.get(addressKey);
		
		System.out.println("Enter First Name do you want to edit: ");
		String enteredFirstName = scanner.nextLine();
	
		int choice = 0, contactFound = 0;
		
		for (int index = 0; index < personList.size(); index++) 
		{
			String fname = personList.get(index).getfName();
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
							personList.get(index).setfName(fName);
							break;
						case 2:
							System.out.println("Enter Last Name");
							String lName = scanner.nextLine();
							personList.get(index).setlName(lName);
							break;
						case 3:
							System.out.println("Enter Address");
							String address = scanner.nextLine();
							personList.get(index).setAddress(address);
							break;
						case 4:
							System.out.println("Enter City");
							String city = scanner.nextLine();
							personList.get(index).setCity(city);
							break;
						case 5:
							System.out.println("Enter State");
							String state = scanner.nextLine();
							personList.get(index).setState(state);
							break;
						case 6:
							System.out.println("Enter Zip Code");
							String zip=scanner.nextLine();
							personList.get(index).setZip(zip);
							break;
						case 7:
							System.out.println("Enter Phone Number");
							String phone = scanner.nextLine();
							personList.get(index).setPhone(phone);
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
		if(countAddressbook == 0)
		{
			System.out.println("There is no Address Book present. Please Create one AddressBook");
			return;
		}
		
		getAddressBook();
		selectAddressBook();
		
		List<Person> personList = addressBook.get(addressKey);
		System.out.println("Enter First Name do you want to delete: ");
		String enteredFirstName = scanner.nextLine();
		int contactFound = 0;
		
		for (int index = 0; index < personList.size(); index++) 
		{
			String fName = personList.get(index).getfName();
			if(fName.equalsIgnoreCase(enteredFirstName)) 
			{
				contactFound = 1;
				personList.remove(index);
				System.out.println("Contact Deleted");
			}
		}
		
		if (contactFound == 0)
		{
			System.out.println("Contact not found");
		}
	}

}
