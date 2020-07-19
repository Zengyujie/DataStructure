package tenAlgorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		knight();
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
		int p = 4;
		int n = 3;
		int[] v = {1500,3000,2000};
		int[] w = {1,4,3};
		int matrix[][] = new int[n + 1][p + 1];
		int path[][] = new int[n + 1][p + 1];
		for(int i = 0; i < n + 1; i++){
			matrix[i][0] = 0;
		}
		for(int i = 0; i < p + 1; i++){
			matrix[0][p] = 0;
		}
		for(int i = 1; i < n + 1; i++){
			for(int j = 1; j < p + 1; j++){
				if(w[i - 1] > j){
					matrix[i][j] = matrix[i - 1][j];
				}else if(w[i - 1] <= j){
					int temp = matrix[i - 1][j - w[i - 1]] + v[i - 1];
					if(temp > matrix[i - 1][j])
					{
						matrix[i][j] = temp;
						path[i][j] = 1;
					}else{
						matrix[i][j] = matrix[i - 1][j];
					}
				}
			}
			System.out.println(Arrays.toString(matrix[i]));
		}
		int i = path.length - 1;
		int j = path[0].length - 1;
		while(i > 0 && j > 0){
			if(path[i][j] == 1){
				System.out.println(i);
				j = j - w[i - 1];
			}
			i--;
		}
		
	}
	
	
	public static void stringCmp(){
		
		String s1 = "123";
		String s2 = "456123";
		int i = 0, j = 0;
		while(i < s1.length() && j < s2.length()){
			if(s1.charAt(i) == s2.charAt(j)){
				i++;
				j++;
			}else{
				j = j - (i - 1);
				i = 0;
			}
		}
		System.out.println(i == s1.length());
		System.out.println(i);
		
	}
	
	public static void kmp(){
		String s1 = "bbcabcdababcdabcdabde";
		String s2 = "abcdabd";
		
		// a b c d a b d
		// 0 0 0 0 1 2 0
		
		/*
		另一种找发：
		next[0] = 0;
		for(int i = 1, j = 0; i < s2.length(); i++){
			while(j > 0&& s2.charAt(j) != s2.charAt(i)){
				j = next[j - 1];
			}
			if(s2.charAt(i) == s2.charAt(j)){
				j++;
			}
			next[i] = j;
		}
		
		*/
		
		int[] next = new int[s2.length()];
		Arrays.fill(next, 0);
		for(int i = 1; i < next.length; i++){
			if(s2.charAt(next[i - 1]) == s2.charAt(i)){//前缀和后缀的末字符相同
				next[i] = next[i - 1] + 1;//匹配的后缀个数加一，同时值表示待匹配的下一个位置
			}else{
				int j = next[i - 1];//此时保证两个指针的前一个一定是匹配的
				while(j > 0){
					if(s2.charAt(next[j]) != s2.charAt(i)){
						j = next[j];
					}else{
						next[i] = next[j] + 1;
						break;
					}
				}
				if(j == 0)
					next[i] = 0;
			}
		}
		System.out.println(Arrays.toString(next));
		int n1 = 0, n2 = 0;
		while(n1 < s1.length() && n2 < s2.length()){
			if(s1.charAt(n1) == s2.charAt(n2)){
				n1++;
				n2++;
			}else{
				if(n2 != 0){
					n1 = n1 - next[n2];
					n2 = next[n2 - 1];
				}else{
					n1++;
					n2 = 0;
				}
				
			}
		}
		
		System.out.println(n1 - n2);
		
	}
	
	
	//骑士周游列国问题
	
	private static int X;//行数
	private static int Y;//列数
	
	//根据当前位置计算还能走哪些位置，并将它们放入一个集合中，判断八个位置
	public static ArrayList<Point> next(Point curPoint){
		ArrayList<Point> ps = new ArrayList<>();
		Point p1 = new Point();
		if((p1.x = curPoint.x + 1) <= X && (p1.y = curPoint.y + 2) <= Y){
			ps.add(new Point(p1));
		}
		if((p1.x = curPoint.x + 2) <= X && (p1.y = curPoint.y + 1) <= Y){
			ps.add(new Point(p1));
		}
		if((p1.x = curPoint.x + 2) <= X && (p1.y = curPoint.y - 1) >= 0){
			ps.add(new Point(p1));
		}
		if((p1.x = curPoint.x + 1) <= X && (p1.y = curPoint.y - 2) >= 0){
			ps.add(new Point(p1));
		}
		if((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0){
			ps.add(new Point(p1));
		}
		if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0){
			ps.add(new Point(p1));
		}
		if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) <= Y){
			ps.add(new Point(p1));
		}
		if((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) <= Y){
			ps.add(new Point(p1));
		}
		return ps;
	}
	
	public static void sort(ArrayList<Point> ps){
		ps.sort((p1, p2)->{
			int count1 = next(p1).size();
			int count2 = next(p2).size();
			return Integer.compare(count1, count2);
		});
	}
	
	//判断棋盘各个位置是否被访问过
	private static boolean visited[];
	//标记是否期盼的所有位置都被访问
	private static boolean finished;
	
	public static void knight(){
		
	}
	
	//step表示马当前走第几步，初始位置为1
	public static void chess(int[][] chessboard, int row, int column, int step){
		chessboard[row][column] = step;
		visited[row * X + column] = true;
		ArrayList<Point> ps = next(new Point(row, column));
		sort(ps);//贪心算法优化
		while(!ps.isEmpty()){
			Point p = ps.remove(0);
			if(visited[p.x * X + p.y]){
				chess(chessboard, p.x, p.y, step + 1);
			}
		}
		//判断是否完成任务，否则回溯
		if(step < X * Y && !finished){
			chessboard[row][column] = 0;
			visited[row * X + column] = false;
		}else{//
			finished = true;
		}
	}

}


