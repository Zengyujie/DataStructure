package tree;

public class ArrBinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7};
		ArrBinaryTree abt = new ArrBinaryTree(arr);
		abt.preOrder(0);
	}

}

class ArrBinaryTree{
	
	private int[] arr;

	public ArrBinaryTree(int[] arr) {
		super();
		this.arr = arr;
	}
	
	
	public void preOrder(int index) {
		if(index < arr.length) {
			System.out.println(arr[index]);
			if(this.getLeftChild(index) != -1)
				preOrder(this.getLeftChild(index));
			if(this.getRightChild(index) != -1)
				preOrder(this.getRightChild(index));
		}
	}
	
	public int getLeftChild(int index) {
		int left = (index + 1) * 2 - 1;
		if(left > arr.length - 1) {
			return -1;
		}else {
			return left;
		}
	}
	
	public int getRightChild(int index) {
		int right = (index + 1) * 2;
		if(right > arr.length - 1) {
			return -1;
		}else {
			return right;
		}
	}
	
	
}