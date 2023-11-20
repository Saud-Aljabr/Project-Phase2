package Phase2;

	public class BSTNode  {
		public int key;
		public Contact data;
		public BSTNode left, right;
		
		public BSTNode(Contact val) {
			data = val;
			left = right = null;
		}
		
		public BSTNode(Contact val, BSTNode l, BSTNode r) {
			data = val;
			left = l;
			right = r;
		}
	}


