package tree;

public class ThreadedBinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TNode n1 = new TNode(1,"n1");
		TNode n2 = new TNode(2,"n2");
		TNode n3 = new TNode(3,"n3");
		TNode n4 = new TNode(4,"n4");
		TNode n5 = new TNode(5,"n5");
		TNode n6 = new TNode(6,"n6");
		n1.setLeft(n2);
		n1.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setLeft(n6);
		TBinaryTree bt = new TBinaryTree(n1);
		bt.threadedNode(n1);
		bt.show();
	}

}

class TBinaryTree{
	
	private TNode root;
	private TNode pre;

	public TBinaryTree(TNode root) {
		super();
		this.root = root;
	}
	
	
	
	public TNode getRoot() {
		return root;
	}



	public void setRoot(TNode root) {
		this.root = root;
	}






	public void threadedNode(TNode node) {
		if(node == null)
			return;
		//线索化左子树
		threadedNode(node.getLeft());
		//线索化当前节点
		if(node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftTag(1);
		}
		
		if(pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightTag(1);
		}
		pre = node;
		//线索化右子树
		threadedNode(node.getRight());
	}
	
	public void show() {
		TNode n = root;
		while(n != null) {
			while(n.getLeftTag() == 0) {
				n = n.getLeft();
			}
			
			System.out.println(n);
			
			while(n.getRightTag() == 1) {
				n = n.getRight();
				System.out.println(n);
			}
			n = n.getRight();
		}
		
	}
	
}


class TNode{
	
	private int no;
	private String name;
	private TNode left;
	private TNode right;
	private int leftTag;//0：指向左子树，1：指向前驱
	private int rightTag;//同上
	public TNode(int no, String name) {
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
	public TNode getLeft() {
		return left;
	}
	public void setLeft(TNode left) {
		this.left = left;
	}
	public TNode getRight() {
		return right;
	}
	public void setRight(TNode right) {
		this.right = right;
	}
	public int getLeftTag() {
		return leftTag;
	}
	public void setLeftTag(int leftTag) {
		this.leftTag = leftTag;
	}
	public int getRightTag() {
		return rightTag;
	}
	public void setRightTag(int rightTag) {
		this.rightTag = rightTag;
	}
	@Override
	public String toString() {
		return "TNode [no=" + no + ", name=" + name + ", left=" + left + ", right=" + right + ", leftTag=" + leftTag
				+ ", rightTag=" + rightTag + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + leftTag;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + no;
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		result = prime * result + rightTag;
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
		TNode other = (TNode) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (leftTag != other.leftTag)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		if (rightTag != other.rightTag)
			return false;
		return true;
	}
	
	
	
	
}