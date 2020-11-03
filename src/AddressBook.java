import java.util.Scanner;

public class AddressBook {
	
	Person person = new Person();
	Scanner scanner = new Scanner(System.in);
	
	public void addPerson()
	{
		
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

	}
	
	public void displayPerson() {
		System.out.println(person);
	}
	

	public void editPerson() {
		
		System.out.println("Enter First Name do you want to edit: ");
		String enteredFirstName = scanner.nextLine();
		String fname = person.getfName();
		int choice = 0;
		
		if(fname.equalsIgnoreCase(enteredFirstName)) 
		{
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
			        	 person.setfName(fName);
			        	 break;
			        case 2:
			        	System.out.println("Enter Last Name");
			        	String lName = scanner.nextLine();
			        	person.setlName(lName);
			        	break;
			        case 3:
			        	System.out.println("Enter Address");
			        	String address = scanner.nextLine();
			        	person.setAddress(address);
			        	break;
			        case 4:
			        	System.out.println("Enter City");
			        	String city = scanner.nextLine();
			        	person.setCity(city);
			        	break;
			        case 5:
			        	System.out.println("Enter State");
			        	String state = scanner.nextLine();
			        	person.setState(state);
			        	break;
			        case 6:
			        	System.out.println("Enter Zip Code");
			        	String zip=scanner.nextLine();
			        	person.setZip(zip);
			        	break;
			        case 7:
			        	System.out.println("Enter Phone Number");
			        	String phone = scanner.nextLine();
			        	person.setPhone(phone);
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
					 	 
		}
		else
		{
			System.out.println("Contact doesn't exist");
		}
		
	}
	
	public void deletePerson() {
		System.out.println("Enter First Name do you want to delete: ");
		String enteredFirstName = scanner.nextLine();
		String fname = person.getfName();
		if(fname.equalsIgnoreCase(enteredFirstName)) 
		{
			person.setfName(null);
			person.setlName(null);
			person.setAddress(null);
			person.setCity(null);
			person.setEmail(null);
			person.setPhone(null);
			person.setState(null);
			person.setZip(null);
			System.out.println("Contact Deleted");
		}
		else
		{
			System.out.println("Contact doesn't exist");
		}
	}

}
