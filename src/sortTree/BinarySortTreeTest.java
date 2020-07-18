package sortTree;

import java.util.Stack;

public class BinarySortTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7};
		Node root = new Node(arr[0]);
		for(int i = 1; i < arr.length; i++) {
			root = root.rotetaAdd(new Node(arr[i]), root);
			System.out.println(root);
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
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + value;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
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
	
	
	public Node findParent(int val) {
		Node pre = null;
		Node curr = this;
		while(curr != null) {
			if(curr.value == val) {
				return pre;
			}
			if(curr.value > val) {
				pre = curr;
				curr = curr.getLeft();
			}
			if(curr.value < val) {
				pre = curr;
				curr = curr.getRight();
			}
		}
		return null;
	}
	
	
	public Node findParentByNode(Node n, Node root) {
		Node pre = null;
		Node curr = root;
		while(curr != null) {
			if(curr.value == n.value) {
				return pre;
			}
			else if(curr.value > n.value) {
				pre = curr;
				curr = curr.getLeft();
			}
			else if(curr.value < n.value) {
				pre = curr;
				curr = curr.getRight();
			}
		}
		return null;
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
	
	public Node deleteNode(int val) {
		if(this.value == val) {
			return this;
		}else {
			Node pre = this.findParent(val);
			if(pre == null) {
				return null;
			}else {
				Node chi = null;
				if(pre.left.value == val) {
					chi = pre.left;
					if(chi.left == null && chi.right == null) {
						pre.left = null;
					}else if(chi.left != null && chi.right == null) {
						pre.left = chi.left;
					}else if(chi.right != null && chi.left == null) {
						pre.left = chi.right;
					}else {
						Node n1 = chi.left;
						Node pre1 = chi;
						while(n1.right != null) {
							pre1 = n1;
							n1 = n1.right;
						}
						int tt = n1.value;
						n1.value = chi.value;
						chi.value = tt;
						deleteNode(val);
					}
				}
				if(pre.right.value == val){
					chi = pre.right;
				}
			}
			return  pre;
		}
		
	}
	
	
	public int height(Node n) {
		if(n == null) {
			return 0;
		}
		int l = height(n.left);
		int r = height(n.right);
		return Math.max(l, r) + 1;
	}
	
	private Node leftRotate(Node n) {
		Node pre = this.findParent(n.value);
		Node temp = n;
		if(pre == null) {
			Node t1 = n.right;
			n.right = t1.left;
			n.left = temp;
			return t1;
		}else {
			if(pre.left == n) {
				pre.left = n.right;
				temp.right = pre.left.left;
				pre.left.left = temp;
				return pre.left;
			}else {
				pre.right = n.right;
				temp.right = pre.right.left;
				pre.right.left = temp;
				return pre.right;
			}
		}
		
	}
	
	public Node rotetaAdd(Node n, Node root) {
		Stack<Node> stack = new Stack<>();
		Node curr = root, pre = null;
		while(curr != null) {
			stack.push(curr);
			if(n.value < curr.value) {
				pre = curr;
				curr = curr.left;
			}else {
				pre = curr;
				curr = curr.right;
			}
		}
		curr = stack.peek();
		if(curr.value > n.value) {
			curr.left = n;
		}else {
			curr.right = n;
		}
		System.out.println("------");
		this.midOrder(root);
		while(!stack.isEmpty()) {
			pre = stack.pop();
			int l = this.height(pre.left);
			int r = this.height(pre.right);
			if(r - l > 1) {
				Node pre1 = null;
				if(!stack.isEmpty()) {
					pre1 = stack.peek();
				}
				if(pre1 == null) {
					Node t1 = pre.right;
					pre.right = t1.left;
					t1.left = pre;
					root = t1;
				}else {
					if(pre1.left == n) {
						pre1.left = pre.right;
						pre.right = pre1.left.left;
						pre1.left.left = pre;
					}else {
						pre1.right = pre.right;
						pre.right = pre1.right.left;
						pre1.right.left = pre;
					}
				}
			}
		}
		return root;
	}
}