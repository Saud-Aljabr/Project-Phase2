package Phase2;

public class Event {
	private String title,date,time,location;
	public Contact contact;
	public	LinkedList<Contact> contacts = new LinkedList<>();
	private String contactsNames;
	public Event(String title, String date, String time,String location, Contact contact) { // for appointment
		super();
		this.title = title;
		this.date = date;
		this.time = time;
		this.location = location;
		this.contact = contact;
	}
	public Event(String title, String date,String time, String location, LinkedList<Contact> contacts) { // for event
		super();
		this.title = title;
		this.date = date;
		this.time = time;
		this.location = location;
		this.contacts = contacts;
	}
	
	public int compareTo(String title) { //  this method for comparing alphabetically, negative means this.title comes before e.title
		return title.compareToIgnoreCase(title);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String time) {
		this.date = time;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public boolean searchContact(String name) {
		contacts.findFirst();
		while(!contacts.last()) {
			if (contacts.retrieve().getName().equalsIgnoreCase(name))
				return true;
		}
		if (contacts.retrieve().getName().equalsIgnoreCase(name))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "Event [title: " + title + ", date: " + date + "time: "+time+", location: " + location + ", contact: " + contact.getName()
				+ "]";
	}

}
