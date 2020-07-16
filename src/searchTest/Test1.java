package searchTest;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {};
		
	}
	
	
	//插值查找算法，拉格朗日插值，对于关键字分布均匀的时候由于二分查找
		//分布不均匀时不一定优于二分
		public static void insertSearch(int num[]) {
			int target = 5;
			int left = 0;
			int right = num.length - 1;
			int mid = 0;
			//防止越界
			if(target < num[left]||target > num[right])
				return;
			while(left < right) {
				mid = left + (right - left)*(target - num[left])/(num[right] - num[left]);
				if(target == num[mid]) {
					System.out.println(mid);
					return;
				}else if(target < num[mid]) {
					left = mid - 1;
				}else {
					right = mid + 1;
				}
			}
			System.out.println(-1);
		}
		
		
		public static void fibSearch(int[] num) {
			
			int target = 5;
			int left = 0;
			int right = num.length - 1;
			int mid = 0;
			//防止越界
			if(target < num[left]||target > num[right])
				return;
			while(left < right) {
				mid = (int) (left + 0.618 * (right - left));
				if(target == num[mid]) {
					System.out.println(mid);
					return;
				}else if(target < num[mid]) {
					left = mid - 1;
				}else {
					right = mid + 1;
				}
			}
			System.out.println(-1);
			
		}

}
