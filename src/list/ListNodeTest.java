package list;

public class ListNodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		john();
	}
	
	public static void printList(ListNode n) {
		while(n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	public static ListNode reverser(ListNode n) {
		ListNode pre = null;
		ListNode temp = n.next;
		while(temp != null) {
			n.next = pre;
			pre = n;
			n = temp;	
			temp = n.next;
		}
		n.next = pre;
		return n;
	}
	
	public static void john() {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = root;
		int k = 0;
		while(root != null) {
			k = (k + 1) % 5;
			if(k == 0) {
				if(root.next != root) {
					ListNode n = root.next;
					System.out.println(n.val);
					root.next = n.next;
				}else {
					System.out.println(root.val);
					root = null;
				}
			}else {
				root = root.next;
			}
			
		}
	}

}

class ListNode{
	int val;
	ListNode next;
	ListNode(int i){val = i;}
}
