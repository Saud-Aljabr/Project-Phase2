package Phase2;

public class phoneBook<T> {
	contactBST contactTree = new contactBST();
	eventBST eventTree = new eventBST();
	
	
	public boolean addCon(Contact con) {
		if (contactTree.searchKey(con.getName()) == null && contactTree.travPhoneNum(con.getPhoneNum()) == null) 
			return contactTree.insert(con);
			
		else 
			return false;
	}

	public boolean deleteConName(String name) { // if the user chooses the name for search criteria
		Contact con = contactTree.searchKey(name);
		if (con == null)
			return false;
		else {
		eventTree.deleteConEvent(con);           // deletes any connected events with the contact
		return contactTree.remove_Key(name);
		}
	}
	public boolean deleteConNum(int num) { //  if the user chooses the phoneNum for search criteria
		Contact con = contactTree.travPhoneNum(num); 
		if (con == null)
			return false;
		else {
			eventTree.deleteConEvent(con);               // deletes any connected events with the contact
			return contactTree.remove_Key(con.getName());
		}
	}
	
	public Contact SearchCon(T t, int x) { // t for the data type and x for search criteria
		if (x == 1) 
			return contactTree.searchKey((String) t);
		else if (x == 2)
			return contactTree.travPhoneNum((Integer) t);
		else if (x == 3)
			return contactTree.travEmail((String) t);
		else if (x == 4)
			return contactTree.travAddress((String) t);
		else if (x == 5)
			return contactTree.travBirthDay((String) t);
		else 
			return null;
	}
	
	public boolean scheduleAppointment(String title, String name, String Date,String Time, String location) { // to add an event and making
																										// sure the order is
																										// alphabetically
		Contact con = contactTree.searchKey(name);
		if (con == null || checkConflict(Date,Time)) // checking if contact exist or if there is a conflict
			return false;
		else {
			Event ev = new Event(title, Date,Time, location, con);
			eventTree.insert(ev);
			return true;
			}
	}
	public boolean scheduleEvent(String title, String names, String Date,String Time, String location) {
		LinkedList<Contact> contacts = eventContacts(names);
		if (contacts.empty() || checkConflict(Date,Time))
			return false;
		else {
			Event ev = new Event(title, Date,Time, location, contacts);
			eventTree.insert(ev);
			return true;
		}
	}
	private LinkedList<Contact> eventContacts(String contacts) { // creating a list for the event contacts
		LinkedList<Contact> contactNames = new LinkedList<>();  // تعامل مع حالة العشوائية
		if (contacts == null)
			return null;
		else {
			String names = contacts+",";
			int commaindex =0;
			while (names.length() > 1) {
				for (int i = 0 ; i < names.length() ; i++) {
					if (names.charAt(i) == ',') {
						commaindex = i;
						break;
						}
				}
				Contact con = contactTree.searchKey(names.substring(0, commaindex));
				if (con != null)
					contactNames.insert(con);
				if (names.length() == commaindex+1)
					break;	
				else
					names = names.substring(commaindex+2, names.length()); // +2 is for avoid taking the comma and space
			}
		}
		return contactNames;
	}
	private boolean checkConflict(String Date,String Time) { // to check if there is conflict in Date or Time in events
		return eventTree.travDateTime(Date, Time) != null;   // true for conflict , false for NO conflict
	}
	public void searchEvent(String s, int x) {
		if (x == 1) {							// 1 if search criteria is Title
			eventTree.printEvent(s);
		}
		else
			eventTree.travContactName(s); // if search criteria is contact Name
		
	}
	
	public void printEventAlpha() {
		if (eventTree.empty())
			System.out.println("No Events");
		else
			eventTree.travAlphbetically();
	}
	public void printFirstName(String firstName) {
		contactTree.travFirstName(firstName);
	}
	public boolean checkBirthday(String s) { // checking if birthday is correct
		int day=-1,mon=-1,yr = -1;
		int index =0 ;
		for (int i = 0; i < s.length(); i++) {
			if (day == -1 && s.charAt(i) == '/' ) {
				day = Integer.parseInt(s.substring(index, i));
				index = i;
				}
			else if (mon == -1 &&s.charAt(i) == '/') {
				mon = Integer.parseInt(s.substring(index+1, i));
				index = i;
			}
			else if (yr == -1 && i == s.length()-1) {
				yr = Integer.parseInt(s.substring(index+1, s.length()));
				index = i;
			}
		}
		
		if(day > 31 || day <0 || mon>12 || mon<0 || yr>2023 || yr<1900)
			return false;
		else 
			return true;
	}
	public boolean checkDate(String s){
		int day=-1,mon=-1,yr = -1;
		int index =0 ;
		try {
		for (int i = 0; i < s.length(); i++) {
			if (day == -1 && s.charAt(i) == '/' ) {
				day = Integer.parseInt(s.substring(index, i));
				index = i;
				}
			else if (mon == -1 &&s.charAt(i) == '/') {
				mon = Integer.parseInt(s.substring(index+1, i));
				index = i;
			}
			else if (yr == -1 && i == s.length()-1) {
				yr = Integer.parseInt(s.substring(index+1, s.length()));
				index = i;
			}
		}
		
		if(day > 31 || day <0 || mon>12 || mon<0 || yr>2030 || yr<2023) // غيرها يوم المناقشة
			return false;
		else 
			return true;
		}catch(NumberFormatException e) {
			System.out.println("Enter in this form day/month/year ");
			return false;
			}
	}

	public boolean checkTime(String s) {
		try {
			int hour = Integer.parseInt(s.substring(0, 2));
			int minuate = Integer.parseInt(s.substring(0, 2));

			if (hour < 0 || hour > 23 || minuate < 0 || minuate > 60)
				return false;
			else
				return true;

		} catch (NumberFormatException e) {
			System.out.println("Enter in this format HH:MM");
			return false;
		}
	}
	
}
