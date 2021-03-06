
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
	
	Map<String, List<Person>> addressBook = new HashMap<String, List<Person>>();
	Map<String, List<Person>> personByCity = new HashMap<String, List<Person>>();
	Map<String, List<Person>> personByState = new HashMap<String, List<Person>>();
	String[] addressList = new String[20];
	int countAddressbook = 0;
	String addressKey;
	Scanner scanner = new Scanner(System.in);
	
	public void writeAddressBookInFile() throws IOException {
		try {
			Path path = Paths.get("addressbook.txt");
			FileOutputStream fileOutputStream = new FileOutputStream(path.toFile());
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(addressBook);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readAddressBookInFile() throws IOException {
		try {
			Path path = Paths.get("addressbook.txt");
			FileInputStream fileInputStream = new FileInputStream(path.toFile());
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			addressBook = (Map<String, List<Person>>) objectInputStream.readObject();
			countAddressbook = 0;
			for(int i = 0; i < addressBook.size(); i++) {
				countAddressbook++;
			}
			int i = 0;
			for(Map.Entry k : addressBook.entrySet()) {
				addressList[i] = (String) k.getKey();
				i++;
			}
			objectInputStream.close();
			fileInputStream.close();
		}
		catch (EOFException e) {}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createAddressBook() throws IOException {
		readAddressBookInFile();
		System.out.println("Enter the name of address book do you want to create: ");
		addressList[countAddressbook] = scanner.nextLine();
		addressBook.put(addressList[countAddressbook], new LinkedList<Person>());
		countAddressbook++;
		writeAddressBookInFile();
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
	
	public void addPerson() throws IOException
	{
		readAddressBookInFile();
		
		if(countAddressbook == 0) {
			System.out.println("There is no Address Book present. Please Create one AddressBook");
			return;
		}
		
		getAddressBook();
		selectAddressBook();
		
		Person person = new Person();
		
		String fName;
		while(true) {
			System.out.println("Enter First Name");
	        fName = scanner.nextLine().toUpperCase();
	        if(checkDuplicate(fName)) {
	        	System.out.println("Person already exist! Please Enter different name");
	        }
	        else {
	        	break;
	        }
		}
		
        System.out.println("Enter Last Name");
        String lName = scanner.nextLine().toUpperCase();
        System.out.println("Enter Address");
        String address = scanner.nextLine().toUpperCase();
        System.out.println("Enter City Name");
        String city = scanner.nextLine().toUpperCase();
        System.out.println("Enter the Zip Code");
        String zip = scanner.nextLine();
        System.out.println("Enter State Name");
        String state = scanner.nextLine().toUpperCase();
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
        
		maintainDictionaryCity();
		maintainDictionaryState();
		
		writeAddressBookInFile();
		
        System.out.println("Contact Added");

	}
	
	public void displayPerson() throws IOException {
		readAddressBookInFile();
		
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
	
	
	public void editPerson() throws IOException {
		readAddressBookInFile();
		
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
					System.out.println("1: Edit Address \n" +
										"2: Edit City \n" +
										"3: Edit State \n" +
										"4: Edit Zip \n" +
										"5: Edit PhoneNumber \n" +
			                	   		"6. Edit Email");
					System.out.println("Enter Your choice: ");
	 
					int selectedOption = scanner.nextInt();
					scanner.nextLine();
	 
					switch (selectedOption) {
						case 1:
							System.out.println("Enter Address");
							String address = scanner.nextLine().toUpperCase();
							personList.get(index).setAddress(address);
							break;
						case 2:
							System.out.println("Enter City");
							String city = scanner.nextLine().toUpperCase();
							personList.get(index).setCity(city);
							break;
						case 3:
							System.out.println("Enter State");
							String state = scanner.nextLine().toUpperCase();
							personList.get(index).setState(state);
							break;
						case 4:
							System.out.println("Enter Zip Code");
							String zip=scanner.nextLine();
							personList.get(index).setZip(zip);
							break;
						case 5:
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
		
		if(contactFound == 0) {
			System.out.println("Contact doesn't exist");
		}
		else {
			maintainDictionaryCity();
			maintainDictionaryState();
		}
		
		writeAddressBookInFile();
		
	}
	
	public void deletePerson() throws IOException {
		readAddressBookInFile();
		if(countAddressbook == 0) {
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
		
		if (contactFound == 0) {
			System.out.println("Contact not found");
		}
		else {
			maintainDictionaryCity();
			maintainDictionaryState();
		}
		
		writeAddressBookInFile();
		
	}
	
	public boolean checkDuplicate(String fName) {
		List<Person> personList = addressBook.get(addressKey);
		return personList.stream().anyMatch(person -> fName.equals(person.getfName()));
	}
	
	public void searchPerson() throws IOException {
		readAddressBookInFile();
		
		if(countAddressbook == 0) {
			System.out.println("There is no Address Book present. Please Create one AddressBook");
			return;
		}
		boolean isTerminate = false;
		while(!isTerminate) {
			System.out.println("1.Search By City");
			System.out.println("2.Search By State");
			System.out.println("3.Back");
			System.out.println("Enter Your Choice");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
				case 1:
					searchByCity();
					break;
				case 2:
					searchByState();
					break;
				case 3:
					isTerminate = true;
					break;
				default:
					System.out.println("Please Enter Correct Option...");
			}
		}
	}
	
	public void searchByCity() {
		maintainDictionaryCity();
		System.out.println("Enter City");
		String findCity = scanner.nextLine().toUpperCase();
		try {
			List<Person> personCity = personByCity.get(findCity);
			long countByCity = personCity.stream().filter(person -> person.getCity().equalsIgnoreCase(findCity)).count();
			System.out.println(countByCity + " Contact Found. \n");
			personCity.forEach(person -> {
				System.out.println(person);
			});
		} 
		catch (NullPointerException e) {
			System.out.println("No Contact Found");
		}
	}
	
	public void searchByState() {
		maintainDictionaryState();
		System.out.println("Enter State");
		String findState = scanner.nextLine().toUpperCase();
		try {
			List<Person> personState = personByState.get(findState);
			long countByState = personState.stream().filter(person -> person.getState().equalsIgnoreCase(findState)).count();
			System.out.println(countByState + " Contact Found. \n");
			personState.forEach(person -> {
				System.out.println(person);
			});
		} 
		catch (NullPointerException e) {
			System.out.println("No Contact Found");
		}
	}
	
	public void maintainDictionaryCity() {
		personByCity.clear();
		for(int address = 0; address < countAddressbook; address++) {
			addressKey = addressList[address];
			List<Person> personList = addressBook.get(addressKey);
			personList.forEach(person -> {
				String city = person.getCity();
				try {
					List<Person> personCity = personByCity.get(city);
					personCity.add(person);
					personByCity.put(city,personCity);
				} 
				catch (NullPointerException e) {
					personByCity.put(city,new LinkedList<Person>());
					List<Person> personCity = personByCity.get(city);
			        personCity.add(person);
			        personByCity.put(city,personCity);
				}
			});
		}
	}
	
	public void maintainDictionaryState() {
		personByState.clear();
		for(int address = 0; address < countAddressbook; address++) {
			addressKey = addressList[address];
			List<Person> personList = addressBook.get(addressKey);
			personList.forEach(person -> {
				String state = person.getState();
				try {
					List<Person> personState = personByState.get(state);
					personState.add(person);
					personByState.put(state,personState);
				} 
				catch (NullPointerException e) {
					personByState.put(state,new LinkedList<Person>());
					List<Person> personState = personByState.get(state);
			        personState.add(person);
			        personByState.put(state,personState);
				}
			});
		}
	}
	
	public void sortPerson() throws IOException {
		readAddressBookInFile();
		
		if(countAddressbook == 0) {
			System.out.println("There is no Address Book present. Please Create one AddressBook");
			return;
		}
		boolean isTerminate = false;
		while(!isTerminate) {
			System.out.println("1.Sort By Name");
			System.out.println("2.Sort By City");
			System.out.println("3.Sort By State");
			System.out.println("4.Sort By Zip");
			System.out.println("5.Back");
			System.out.println("Enter Your Choice");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
				case 1:
					sortByName();
					break;
				case 2:
					sortByCity();
					break;
				case 3:
					sortByState();
					break;
				case 4:
					sortByZip();
					break;
				case 5:
					isTerminate = true;
					break;
				default:
					System.out.println("Please Enter Correct Option...");
			}
		}
	}
	
	public void sortByName() throws IOException {
		
		getAddressBook();
		selectAddressBook();
		
		List<Person> personList = addressBook.get(addressKey);
		personList = personList.stream()
					.sorted((person1, person2) -> person1.getfName().compareTo(person2.getfName()))
					.collect(Collectors.toList());
		addressBook.put(addressKey, personList);
		
		System.out.println(addressKey + " AddressBook Sorted By Name Successfully. \n");
		
		writeAddressBookInFile();
	}
	
	public void sortByCity() throws IOException {
		readAddressBookInFile();
		
		getAddressBook();
		selectAddressBook();
		
		List<Person> personList = addressBook.get(addressKey);
		
		personList = personList.stream()
					.sorted((person1, person2) -> person1.getCity().compareTo(person2.getCity()))
					.collect(Collectors.toList());
		addressBook.put(addressKey, personList);
		
		writeAddressBookInFile();
		System.out.println(addressKey + " AddressBook Sorted By City Successfully. \n");
	}
	
	public void sortByState() throws IOException {
		
		getAddressBook();
		selectAddressBook();
		
		List<Person> personList = addressBook.get(addressKey);
		
		personList = personList.stream()
					.sorted((person1, person2) -> person1.getState().compareTo(person2.getState()))
					.collect(Collectors.toList());
		addressBook.put(addressKey, personList);
		
		writeAddressBookInFile();
		
		System.out.println(addressKey + " AddressBook Sorted By State Successfully. \n");
	}
	
	public void sortByZip() throws IOException {
		readAddressBookInFile();
		getAddressBook();
		selectAddressBook();
		
		List<Person> personList = addressBook.get(addressKey);
		
		personList = personList.stream()
					.sorted((person1, person2) -> person1.getZip().compareTo(person2.getZip()))
					.collect(Collectors.toList());
		addressBook.put(addressKey, personList);
		
		writeAddressBookInFile();
		
		System.out.println(addressKey + " AddressBook Sorted By Zip Successfully. \n");
	}
	
}
