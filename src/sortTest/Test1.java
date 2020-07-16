package sortTest;

import java.util.Arrays;

public class Test1 {
	
/*
排序的分类：
内部排序：将需要排序的内容加载到内存中进行排序

外部排序：数据量过大，无法完全加载到内存中，需要借助外部存储进行排序


常见内部排序分类：

插入排序：希尔排序，直接插入排序
选择排序：简单选择排序，堆排序
交换排序：冒泡排序，快速排序
归并排序：
基数排序(桶排序)：

时间频度：一条语句语句执行的次数


*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {9,8,7,6,5,4,3,2,1,0,10};
		merge(num);
	}
	
	
	public static void bubble(int num[]) {
		for(int i = 0; i < num.length - 1; i++) {
			boolean flag = true;
			for(int j = 0; j < num.length - i - 1; j++) {
				if(num[j] > num[j + 1]) {
					int t = num[j + 1];
					num[j + 1] = num[j];
					num[j] = t;
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
		System.out.println(Arrays.toString(num));
	}
	
	
	public static void choose(int num[]) {
		for(int i = 0; i < num.length - 1; i++) {
			int t = i;
			for(int j = i + 1; j < num.length; j++) {
				if(num[j] < num[t]) {
					t = j;
				}
			}
			int m = num[i];
			num[i] = num[t];
			num[t] = m;
		}
		System.out.println(Arrays.toString(num));
	}
	
	
	public static void insert(int num[]) {
		for(int i = 1; i < num.length; i++) {
			int t = num[i];
			int j = i - 1;
			for(;j >= 0 && num[j] > t; j--) {
				num[j + 1] = num[j];
				
			}
			num[j + 1] = t;
		}
		System.out.println(Arrays.toString(num));
	}
	
	public static void shell(int num[]) {
		int gap = num.length / 2;
		while(gap != 0) {
			for(int i = gap; i < num.length; i++) {
				int t = num[i];
				int j = i - gap;
				for(;j >= 0 && num[j] > t; j = j - gap) {
					num[j + gap] = num[j];
				}
				num[j + gap] = t;
			}
			gap = gap / 2;
		}
		System.out.println(Arrays.toString(num));
	}
	
	public static void quick(int num[]) {
		loopQ(num, 0, num.length - 1);
		System.out.println(Arrays.toString(num));
	}
	
	public static void loopQ(int[] num, int left, int right) {
		if(left >= right)
			return;
		int po = getMiddle(num, left, right);
		loopQ(num, left, po - 1);
		loopQ(num, po + 1, right);
	}
	
	public static int getMiddle(int[] num, int left, int right) {
		int temp = left;
		int t = 0;
		while(left < right) {
			while(left < right && num[right] > num[temp]) {
				right--;
			}
			
			while(left < right && num[left] <= num[temp]) {
				left++;
			}
			
			t = num[left];
			num[left] = num[right];
			num[right] = t;
		}
		t = num[temp];
		num[temp] = num[left];
		num[left] = t;
		return left;
	}
	
	public static void merge(int num[]) {
		divide(num, 0, num.length - 1);
		System.out.println(Arrays.toString(num));
	}
	
	public static void divide(int num[], int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			divide(num, left, mid);
			divide(num, mid + 1, right);
			merge(num, left, mid, mid + 1, right);
		}
	}
	
	public static void merge(int num[], int left1, int right1, int left2, int right2) {
		int temp[] = new int[right2 - left1 + 1];
		int j = left1, k = left2;
		for(int i = 0; i < temp.length; i++) {
			if(j <= right1 && k <= right2) {
				if(num[j] < num[k]) {
					temp[i] = num[j++];
				}else {
					temp[i] = num[k++];
				}
			}else {
				if(j > right1) {
					while(k <= right2) {
						temp[i++] = num[k++];
					}
					break;
				}
				if(k > right2) {
					while(j <= right1) {
						temp[i++] = num[j++];
					}
					break;
				}
			}
		}
		for(int i = 0; i < temp.length; i++) {
			num[left1++] = temp[i];
		}
	}
	
	
}
