package sortTree;

public class BinarySortTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7,3,10,12,5,1,9};
		Node root = new Node(arr[0]);
		for(int i = 1; i < arr.length; i++) {
			root.add(new Node(arr[i]));
		}
		root.midOrder(root);
	}

}


class Node{
	int value;
	Node left;
	Node right;
	public Node(int value) {
		super();
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	public void add(Node n) {
		if(n == null) {
			return;
		}
		if(n.value < this.value) {
			if(this.left == null) {
				this.left = n;
				return;
			}else {
				this.left.add(n);
			}
		}else {
			if(this.right == null) {
				this.right = n;
				return;
			}else {
				this.right.add(n);
			}
		}
	}
	
	public void delete(int n) {
		
	}
	
	public Node findParent(int val) {
		if(val == this.value) {
			return this;
		}else {
			Node curr = this;
			
		}
	}
	
	public void midOrder(Node n) {
		if(n != null) {
			if(n.left != null) {
				midOrder(n.left);
			}
			System.out.println(n.value);
			if(n.right != null) {
				midOrder(n.right);
			}
		}
	}
}