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
		if (searchKey(c.getName())== null) {
			root = insertHelper(root,node);
			return true;
			}
		else 
			return false;
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

}
