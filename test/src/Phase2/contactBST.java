package Phase2;

public class contactBST  {
	BSTNode root, current;
	
	
	public contactBST() {
		root = current = null;
	}
	
	public boolean empty() {
		return root == null;
	}
	
	public boolean full() {
		return false;
	}
	
	public Contact retrieve () {
		return current.data;
	}
	
	public boolean insert(Contact c) {
		BSTNode node = new BSTNode(c);
		root = insertHelper(root,node);
		return true;
	}
	private BSTNode insertHelper(BSTNode root, BSTNode node) {
		
		if (root == null) {
			root = current =node;
			
			return root;
		}
		else {
		int key = root.data.compareTo(node.data.getName());
		if(key > 0) {
			root.left = insertHelper(root.left, node);
		}
		else {
			root.right = insertHelper(root.right, node);
		}
		return root;
	}
		}
	public void display() {
		displayHelper(root);
	}
	private void displayHelper(BSTNode root) {
		if (root != null) {
			displayHelper(root.left);
			System.out.println(root.data.getName());
			displayHelper(root.right);
		}
	}
	public Contact searchKey(String s) {
		return searchKeyHelper(root, s);
	}
	private Contact searchKeyHelper(BSTNode root, String name) {
		if (root == null) {
			return null;
		}
		else if (root.data.getName().equalsIgnoreCase(name)) {
			return root.data;
		}
		else {
			int key = root.data.compareTo(name);
			if (key > 0) {
				return searchKeyHelper(root.left, name);
			}
			else {
				return searchKeyHelper(root.right, name);
			}
		}
	}
	public boolean remove_Key(String name) {
		if (searchKey(name) != null) {
			remove_KeyHelper(root,name);
			return true;
			}
		else 
			return false;
	}
	private BSTNode remove_KeyHelper(BSTNode root, String name) {
		if (root == null)
			return root;
		else {
			int key = root.data.compareTo(name);
			if (key > 0) {
				root.left = remove_KeyHelper(root.left, name);
			}
			else if (key < 0) {
				root.right = remove_KeyHelper(root.right, name);
			}
			else {
				if (root.left == null && root.right == null)
					root = null;
				else if (root.right != null) {
					root.data = successor(root);
					root.right = remove_KeyHelper(root.right, root.data.getName());
				}
				else {
					root.data = predecessor(root);
					root.left = remove_KeyHelper(root.left, root.data.getName());
				}
			}
		}
		return root;
	}
	private Contact successor(BSTNode root) {
		root = root.right;
		while(root.left!=null)
			root = root.left;
		return root.data;
	}
	private Contact predecessor(BSTNode root) {
		root = root.left;
		while(root.right!=null)
			root = root.right;
		return root.data;
	}
	public Contact travPhoneNum(int phoneNum) {
		return travPhoneNumHelper(root,phoneNum);
	}
	private Contact travPhoneNumHelper(BSTNode root, int phoneNum) {
		if (root == null)
			return null;
		Contact result = travPhoneNumHelper(root.left, phoneNum);
		if (result!=null)
			return result;
		if (root.data.getPhoneNum()==phoneNum)
			return root.data;
		return travPhoneNumHelper(root.right, phoneNum);
	}
	public Contact travEmail(String email) {
		return travEmailHelper(root,email);
	}
	private Contact travEmailHelper(BSTNode root, String email) {
		if (root == null)
			return null;
		Contact result = travEmailHelper(root.left, email);
		if (result!=null)
			return result;
		if (root.data.getEmail().equalsIgnoreCase(email))
			return root.data;
		return travEmailHelper(root.right, email);
	}
	public Contact travBirthDay(String BirthDay) {
		return travBirthDayHelper(root,BirthDay);
	}
	private Contact travBirthDayHelper(BSTNode root, String BirthDay) {
		if (root == null)
			return null;
		Contact result = travBirthDayHelper(root.left, BirthDay);
		if (result!=null)
			return result;
		if (root.data.getBirthday().equalsIgnoreCase(BirthDay))
			return root.data;
		return travBirthDayHelper(root.right, BirthDay);
	}
	 public Contact travAddress(String Address) {
			return travAddressHelper(root,Address);
		}
		private Contact travAddressHelper(BSTNode root, String Address) {
			if (root == null)
				return null;
			Contact result = travAddressHelper(root.left, Address);
			if (result!=null)
				return result;
			if (root.data.getAddress().equalsIgnoreCase(Address)) // here u should print 
				return root.data;
			return travAddressHelper(root.right, Address);
		}


}
