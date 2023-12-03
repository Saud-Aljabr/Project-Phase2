package Phase2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		phoneBook phonebook = new phoneBook();
		Scanner s = new Scanner(System.in);
		int x = 0;
		int num =0;
		do {
			try {
			System.out.println("Welcome to the Linked Tree Phonebook!");
			System.out.println("please choose an option:\n");
			System.out.println("1.Add a contact	  	  		5.Print event details");
			System.out.println("2.Delete a contact			6.Print contacts by first name");
			System.out.println("3.Search for a contact			7.Print all events alphabitacally");
			System.out.println("4.Schedule an event			8.Exit");
			x = s.nextInt();
			switch (x) {
			case 1:
				s.nextLine();
				System.out.println("Enter the contact's name:");
				String name = s.nextLine();
				System.out.println("Enter the contact's phone number:");
				num = s.nextInt();
				s.nextLine();
				System.out.println("Enter the contact's email address:");
				String email = s.nextLine();	
				System.out.println("Enter the contact's address:");
				String address = s.nextLine();			
				System.out.println("Enter the contact's birthday in this form day/month/year :");
				String birthday = s.nextLine();		
				while (!phonebook.checkBirthday(birthday)) {
					System.out.println("The date is not valid, Enter again in this form: day/month/year ");
					birthday = s.nextLine();
				}
				System.out.println("Enter any notes for the contact: ");
				String notes = s.nextLine();
			
				if (phonebook.addCon(new Contact(name,num,email,address,birthday,notes)))
					System.out.println("Contact added successfully\n");
				else 
					System.out.println("You already added this contact\n");
				break;
			case 2:
				System.out.println("Enter search criteria:\n1.Contact name\n2.Conatct phone number");
				num = s.nextInt();
				while (num<1 || num>2) {
					System.out.println("Enter only 1 OR 2 ");
					num = s.nextInt();
				}
				if (num == 1) {
					s.nextLine();
					System.out.println("Enter the contact's name:");
					if(phonebook.deleteConName(s.nextLine()))
						System.out.println("Deleted successfully");
					else
						System.out.println("Contact does not exist");
					}
				else if (num == 2) {
					System.out.println("Enter the contact's phone number:");
					if(phonebook.deleteConNum(s.nextInt()))
						System.out.println("Deleted successfully");
					else
						System.out.println("Contact does not exist");
					}
				break;
				
			case 3:
				System.out.println("Enter search criteria:\n1.Name\n2.Phone number\n3.Email\n4.Adress\n5.Birthday");
				Contact tmp = new Contact();
				num = s.nextInt();
				s.nextLine();
				while (num<1 || num>5) {
					System.out.println("Enter a valid number");
					num = s.nextInt();
				}
				if (num == 1) {
					System.out.println("Enter the contact's name:");
					tmp = phonebook.SearchCon(s.nextLine(), num);
				}
				else if (num == 2) {
					System.out.println("Enter the contact's phone number:");
					tmp = phonebook.SearchCon(s.nextInt(), num);
				}
				else if (num == 3) {
					System.out.println("Enter the contact's Email:");
					tmp = phonebook.SearchCon(s.nextLine(), num);
				}
				else if (num == 4) {
					System.out.println("Enter the contact's Address:");
					tmp = phonebook.SearchCon(s.nextLine(), num);
				}
				else if (num == 5) {
					System.out.println("Enter the contact's Birthday:");
					tmp = phonebook.SearchCon(s.nextLine(), num);
				}
				if (tmp == null) {
					System.out.println("Contact does not exist!");
					break;
					}
				else 
					System.out.println(tmp.toString());
				break;
			case 4:
				System.out.println("Enter Type:\n1.Event\n2.Appointment");
				num = s.nextInt();
				while (num<1 || num>2) {
					System.out.println("Enter only 1 OR 2 ");
					num = s.nextInt();
				}
				s.nextLine();
				System.out.println("Enter Event title: ");
				String title = s.nextLine();
				System.out.println("Enter contact name:");
				String contactName= s.nextLine();
				System.out.println("Enter event date day/month/year : ");
				String date= s.nextLine();
				while(!phonebook.checkDate(date)) {
					System.out.println("Date is Not valid !");
					date = s.nextLine();
				}
				System.out.println("Enter event time HH:MM  : ");
				String time= s.nextLine();
				while(!phonebook.checkTime(time)) {
					System.out.println("Time is Not valid !");
					time = s.nextLine();
				}
				System.out.println("Enter event location: ");
				String location= s.nextLine();
				if (num == 1) {
					if(phonebook.scheduleEvent(title, contactName, date, time, location))
						System.out.println("Event Added succesfully");
					else
						System.out.println("contact doesnt exist OR There is conflict in Date and time");
				}
				else  {
					if(phonebook.scheduleAppointment(title, contactName, date, time, location))
						System.out.println("Event Added succesfully");
					else
						System.out.println("There is conflict in Date and time OR contact doesnt exist");
				}
				break;
			case 5:
				System.out.println("Enter search criteria:\n1.Conatct name\n2.Event title");
				num = s.nextInt();
				while(num>2 || num<1) {
					System.out.println("Enter a valid number");
				}
				s.nextLine();
				if (num == 1) {
					System.out.println("Enter contact name: ");
					phonebook.searchEvent(s.nextLine(), 2);
					}
				else {
					System.out.println("Enter event title: ");
					phonebook.searchEvent(s.nextLine(), 1);
				}
				break;
			case 6: // check if Name does not exist
				System.out.println("Enter First name: ");
				phonebook.printFirstName(s.next());
				break;
			case 7:
				phonebook.printEventAlpha();
				break;
			}
			}catch(InputMismatchException e) {
				System.out.println("Wrong input");
				s.next();
			}
			catch(Exception e) {
				System.out.println("Somthing went wrong");
				s.next();
			}
		}while(x!=8);
		System.out.println("Good Bye !");
	}

}
