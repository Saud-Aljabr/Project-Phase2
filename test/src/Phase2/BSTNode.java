package Phase2;

	public class BSTNode   {
		public int key;
		public Contact data;
		public Event dataEvent;
		public BSTNode left, right;
		
		public BSTNode(Event dataEvent) {
			left = right = null;
			this.dataEvent = dataEvent;
		}
		public BSTNode(Contact val) {
			data = val;
			left = right = null;
		}
		
		public BSTNode(Contact val, BSTNode l, BSTNode r) {
			data = val;
			left = l;
			right = r;
		}
		public BSTNode(Event dataEvent, BSTNode left, BSTNode right) {
			super();
			this.dataEvent = dataEvent;
			this.left = left;
			this.right = right;
		}
	}


