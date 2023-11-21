package Phase2;

public class phoneBook<T> {
	contactBST treeList = new contactBST();
	LinkedList<Event> eventList = new LinkedList<>();
	
	public boolean addCon(Contact con) {
		if (treeList.searchKey(con.getName()) == null && treeList.travPhoneNum(con.getPhoneNum()) == null) 
			return treeList.insert(con);
			
		else 
			return false;
	}
	// ******* delete event is left *************
	public boolean deleteConName(String name) { // if the user chooses the name for search criteria
			return treeList.remove_Key(name);
	}
	public boolean deleteConNum(int num) { //  if the user chooses the phoneNum for search criteria
		Contact con = new Contact();
		con = treeList.travPhoneNum(num);
		if (con == null)
			return false;
		else {
			return treeList.remove_Key(con.getName());
		}
	}
	// ^^^^^^ delete event is left ^^^^^^^^^^^^^
	public Contact SearchCon(T t, int x) { // t for the data type and x for search criteria
		if (x == 1) 
			return treeList.searchKey((String) t);
		else if (x == 2)
			return treeList.travPhoneNum((Integer) t);
		else if (x == 3)
			return treeList.travEmail((String) t);
		else if (x == 4)
			return treeList.travAddress((String) t);
		else if (x == 5)
			return treeList.travBirthDay((String) t);
		else 
			return null;
	}
}
