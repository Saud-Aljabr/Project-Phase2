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

	public void displayContact() {
		contactTree.display();
	}
	public void displayEvent() {
		eventTree.display();
	}
	public void searchEvent(String s, int x) {
		if (x == 1) {							// 1 if search criteria is Title
		Event tmp = eventTree.searchKey(s);
		
			if (tmp != null) {
				if (tmp.contact!=null)
					System.out.println(tmp.toStringAppointment());
				else 
					System.out.println(tmp.toStringEvent());
				}
			else 
				System.out.println("Event Not Found !");
		}
		else
			eventTree.travContactName(s);
		
		
		
	}
	
	
	// try
	public void deleteevent(String tit) {
		eventTree.remove_Key(tit);
		
	}
	
}
