package tree;

import java.util.Collections;
import java.util.TreeSet;

public class HaffmanTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,2,7,5};
		haffman(arr);
	}
	
	public static void haffman(int[] arr) {
		TreeSet<Node> set = new TreeSet<>((n1, n2)->{
			return Integer.compare(n1.getNo(), n2.getNo());
		});
		for(int i = 0; i < arr.length; i++) {
			set.add(new Node(arr[i], "test"));
		}
		while(set.size() > 1) {
			Node n1 = set.pollFirst();
			Node n2 = set.pollFirst();
			Node n3 = new Node(n1.getNo() + n2.getNo(), "test");
			n3.setLeft(n1);
			n3.setRight(n2);
			set.add(n3);
		}
		set.pollFirst().preOrder();
		
		
	}

}


