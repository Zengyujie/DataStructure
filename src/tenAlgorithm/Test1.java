package tenAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//算法一：二分查找
	public static int binarySearch(int[] arr, int target){
		return Arrays.binarySearch(arr, target);
	}
	
	
	//算法二：分治算法
	//1，分解：将原问题分解成若干个规模小，相互独立，与原问题形式相同的子问题
	//2，解决：若子问题规模较小则直接解决，否则递归解决各个子问题
	//3，合并：将各个子问题的解合并为原问题的解
	
	public static int hanno(int tar){
		if(tar == 1)
			return 1;
		else
			return hanno(tar - 1) * 2 + 1;
		
	}
	
	
	
	//算法三：动态规划算法
	//核心思想：将大问题划分为小问题
	//与分治类似，区别是下一个子阶段求解是建立在上一个子阶段求解的基础上
	//即，经分解的子问题往往不是相互独立的
	//动态规划可以通过填表的方式来逐步推进，得到最优解
	
	/*
	 * 背包问题：01背包(每件物品最多用一次)和无限背包(可以无限制使用)
	 * 
	 * 
	 */
	public static void packagePro(){
		int packageNum = 4;
		
	}
	
	

}
