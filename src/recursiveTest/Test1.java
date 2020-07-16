package recursiveTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		eightQueue();
	}
	
	
	public static void maze1() {
		int maze[][] = new int[8][7];
		for(int i = 0; i < maze.length; i++) {
			maze[i][0] = 1;
			maze[i][maze[0].length - 1] = -1;
		}
		for(int i = 1; i < maze[0].length - 1; i++) {
			maze[0][i] = 1;
			maze[maze.length - 1][i] = -1;
		}
		maze[3][1] = -1;
		maze[3][2] = -1;
		printMatrix(maze);
		//setWay(maze,1,1);
		System.out.println("------");
		
		printMatrix(maze);
		
		
		
	}
	
	//1表示墙，2表示路可以走，3表示走过但是走不通
	//策略：下-右-上-左
	public static boolean setWay(int[][] map, int i, int j) {
		if(map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j] == 0) {
				map[i][j] = 2;//假设能走通
				if(setWay(map, i + 1, j)) {
					return true;
				}else if(setWay(map, i, j + 1)) {
					return true;
				}else if(setWay(map, i - 1, j)) {
					return  true;
				}else if(setWay(map, i, j - 1)) {
					return true;
				}else {
					map[i][j] = 3;
					return false;
				}
			}else {
				return false;
			}
		}
	}
	
	
	
	
	public static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
	
	public static void eightQueue() {
		ArrayList<int[]> list = new ArrayList<>();
		int[] arr = new int[8];
		loop(arr, list, 0);
		System.out.println(list.size());
	}
	
	public static void loop(int[] arr, List<int[]> list, int curr) {
		if(curr == arr.length) {
			list.add(arr);
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			arr[curr] = i;
			if(check(arr, curr)) {
				loop(Arrays.copyOf(arr, arr.length), list, curr + 1);
			}
		}
	}
	
	
	public static boolean check(int[] arr, int len) {
		if(len == 0) {
			return true;
		}
		for(int i = 0; i <= len; i++) {
			int temp = arr[i];
			int left = i - 1;
			int right = i + 1;
			int t1 = 1;
			while(left >= 0){
				if(arr[left] == temp || Math.abs(arr[left] - temp) == t1)
					return false;
				left--;
				t1++;
			}
			t1 = 1;
			while(right <= len){
				if(arr[right] == temp || Math.abs(arr[right] - temp) == t1)
					return false;
				right++;
				t1++;
			}
		}
		return true;
	}

}
