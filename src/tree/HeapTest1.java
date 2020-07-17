package tree;

import java.util.Arrays;

public class HeapTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,6,5,8,9};
		heapSort(nums);
		System.out.println(Arrays.toString(nums));
		
		
	}
	
	public static void heapSort(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			buildHeap(arr, arr.length - 1 - i);
			int t1 = arr[0];
			arr[0] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = t1;
		}
		
	}
	
	public static void buildHeap(int[] nums, int tail) {
		for(int i = (tail - 1)/ 2; i >= 0; i--) {
			int temp = i;
			int rc = (temp + 1) * 2 - 1;
			if(rc < tail && nums[rc] < nums[rc + 1]) {
				rc++;
			}
			while(rc <= tail && nums[temp] < nums[rc]) {
				
				int tt = nums[temp];
				nums[temp] = nums[rc];
				nums[rc] = tt;
				temp = rc;
				rc = (temp + 1) * 2 - 1;
				if(rc < tail && nums[rc] < nums[rc + 1]) {
					rc++;
				}
			}
		}
	}

}
