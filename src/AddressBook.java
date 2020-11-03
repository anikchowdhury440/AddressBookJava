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

}
