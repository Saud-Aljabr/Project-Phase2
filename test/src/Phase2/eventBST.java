package Phase2;

public class eventBST {
	BSTNode root, current;

	public eventBST() {
		root = current = null;
	}

	public boolean empty() {
		return root == null;
	}

	public boolean full() {
		return false;
	}

	public Event retrieve() {
		return current.dataEvent;
	}

	public boolean insert(Event e) {
		BSTNode node = new BSTNode(e);
		root = insertHelper(root, node);
		return true;
	}

	private BSTNode insertHelper(BSTNode root, BSTNode node) {

		if (root == null) {
			root = current = node;

			return root;
		} else {
			int key = root.dataEvent.compareTo(node.dataEvent.getTitle());
			if (key > 0) {
				root.left = insertHelper(root.left, node);
			} else {
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
			System.out.println(root.dataEvent.getTitle());
			displayHelper(root.right);
		}
	}

	public Event searchKey(String s) {
		return searchKeyHelper(root, s);
	}

	private Event searchKeyHelper(BSTNode root, String title) {
		if (root == null) {
			return null;
		} else if (root.dataEvent.getTitle().equalsIgnoreCase(title)) {
			return root.dataEvent;
		} else {
			int key = root.data.compareTo(title);
			if (key > 0) {
				return searchKeyHelper(root.left, title);
			} else {
				return searchKeyHelper(root.right, title);
			}
		}
	}

	public boolean remove_Key(String title) {
		if (searchKey(title) != null) {
			remove_KeyHelper(root, title);
			return true;
		} else
			return false;
	}

	private BSTNode remove_KeyHelper(BSTNode root, String title) {
		if (root == null)
			return root;
		else {
			int key = root.dataEvent.compareTo(title);
			if (key > 0) {
				root.left = remove_KeyHelper(root.left, title);
			} else if (key < 0) {
				root.right = remove_KeyHelper(root.right, title);
			} else {
				if (root.left == null && root.right == null)
					root = null;
				else if (root.right != null) {
					root.dataEvent = successor(root);
					root.right = remove_KeyHelper(root.right, root.dataEvent.getTitle());
				} else {
					root.dataEvent = predecessor(root);
					root.left = remove_KeyHelper(root.left, root.dataEvent.getTitle());
				}
			}
		}
		return root;
	}

	private Event successor(BSTNode root) {
		root = root.right;
		while (root.left != null)
			root = root.left;
		return root.dataEvent;
	}

	private Event predecessor(BSTNode root) {
		root = root.left;
		while (root.right != null)
			root = root.right;
		return root.dataEvent;
	}
	public Event travDateTime(String Date,String Time) {
		return travDateTimeHelper(root,Date,Time);
	}
	private Event travDateTimeHelper(BSTNode root, String Date,String Time) {
		if (root == null)
			return null;
		Event result = travDateTimeHelper(root.left, Date,Time);
		if (result!=null)
			return result;
		if (root.dataEvent.getDate().equalsIgnoreCase(Date) && root.dataEvent.getTime().equalsIgnoreCase(Time))
			return root.dataEvent;
		return travDateTimeHelper(root.right, Date,Time);
	}
	
	public void deleteConEvent(Contact con) {
		deleteConEventHelper(root,con);
	}
	private void deleteConEventHelper(BSTNode root, Contact con) {
		if (root == null)
			return;
		deleteConEventHelper(root.left, con);
		LinkedList<Contact> contacts = root.dataEvent.contacts;
		if (contacts == null && root.dataEvent.contact == con) { 
			remove_Key(root.dataEvent.getTitle());
			}
		else if(contacts != null) {
			contacts.findFirst();
			while (contacts.last()) {
				if (contacts.retrieve() == con)
					contacts.remove();
				}
			if (contacts.retrieve() == con)
				contacts.remove();
			if (contacts.empty())
				remove_Key(root.dataEvent.getTitle());
		}
		deleteConEventHelper(root.right, con);
	}
}
