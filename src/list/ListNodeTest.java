package list;

public class ListNodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		reverser(root);
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

}

class ListNode{
	int val;
	ListNode next;
	ListNode(int i){val = i;}
}
