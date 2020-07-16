package tree;

import java.util.Stack;

public class BaseBinaryTreeTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(1,"n1");
		Node n2 = new Node(2,"n2");
		Node n3 = new Node(3,"n3");
		Node n4 = new Node(4,"n4");
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		BinaryTree bt = new BinaryTree(n1);
		bt.preOrder1();
		System.out.println("-----------");
		bt.midOrder1();
		System.out.println("-----------");
		bt.postOrder1();
	}
	
	
	

}


class Node{
	private int no;
	private String name;
	private Node left;
	private Node right;
	public Node(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String toString() {
		return "Node [no=" + no + ", name=" + name + ", left=" + left + ", right=" + right + "]";
	}
	
	//pre order
	public void preOrder(){
		System.out.println(this);
		if(this.left != null){
			this.left.preOrder();
		}
		if(this.right != null){
			this.right.preOrder();
		}
	}
	
	//mid order
		public void midOrder(){
			
			if(this.left != null){
				this.left.midOrder();
			}
			System.out.println(this);
			if(this.right != null){
				this.right.midOrder();
			}
		}

		//post order
		public void postOrder(){
			
			if(this.left != null){
				this.left.postOrder();
			}
			if(this.right != null){
				this.right.postOrder();
			}
			System.out.println(this);
		}
	
}

class BinaryTree{
	
	private Node root;

	public BinaryTree(Node root) {
		super();
		this.root = root;
	}
	
	public void preOrder(){
		if(this.root != null){
			this.root.preOrder();
		}else{
			System.out.println("null tree");
		}
	}
	
	public void preOrder1(){
		if(this.root != null){
			Node curr = root;
			Stack<Node> s = new Stack<>();
			s.push(curr);
			while(!s.isEmpty()){
				curr = s.pop();
				while(curr != null){
					System.out.println(curr.getNo());
					if(curr.getRight() != null){
						s.push(curr.getRight());
					}
					curr = curr.getLeft();
				}
				if(curr != null && curr.getRight() != null){
					s.push(curr.getRight());
				}
			}
		}else{
			System.out.println("null tree");
		}
	}
	
	public void midOrder(){
		if(this.root != null){
			this.root.midOrder();
		}else{
			System.out.println("null tree");
		}
	}
	
	public void midOrder1(){
		if(this.root != null){
			Node curr = root;
			Stack<Node> s = new Stack<>();
			s.push(curr);
			curr = curr.getLeft();
			while(!s.isEmpty()){
				while(curr != null){
					s.push(curr);
					curr = curr.getLeft();
				}
				curr = s.pop();
				System.out.println(curr.getNo());
				curr = curr.getRight();
				if(curr != null){
					s.push(curr);
					curr = curr.getLeft();
				}
			}
		}else{
			System.out.println("null tree");
		}
	}
	
	public void postOrder(){
		if(this.root != null){
			this.root.postOrder();
		}else{
			System.out.println("null tree");
		}
	}
	
	public void postOrder1(){
		if(this.root != null){
			Node curr = root;
			Stack<Node> s = new Stack<>();
			s.push(curr);
			curr = curr.getLeft();
			while(!s.isEmpty()){
				while(curr != null){
					s.push(curr);
					curr = curr.getLeft();
				}
				curr = s.peek();
				curr = curr.getRight();
				if(curr != null){
					s.push(curr);
					curr = curr.getLeft();
				}else{
					System.out.println(s.pop().getNo());
					curr = s.peek().getRight();
				}
			}
		}else{
			System.out.println("null tree");
		}
	}
	
}
