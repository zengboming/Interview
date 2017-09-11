
public class Search {
	
	//顺序查找 o(n)
	public int sequenceSearch(int[] a, int value) {
		int length = a.length;
		for (int i = 0; i < length; i++) {
			if (a[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	//二分查找
	public int binarySearch(int[] a, int left, int right, int value) {
		if (left > right) {
			return -1;
		}
		int temp = (right + left)/2;
		if (a[temp] == value ) {
			return temp;
		} else if (a[temp] < value) {
			return binarySearch(a, temp + 1, right, value);
		} else {
			return binarySearch(a, left, temp - 1, value);
		}
	}
	
	public int binarySearchFirst(int[] a, int left, int right, int value) {
		if (left > right) {
			return -1;
		}
		
		//找到first的下标，当left <= right 时停止循环。
		while (left < right) {
			int temp = (left + right) / 2;
			
			//如果比value小则搜索(temp + 1 , right)区域
			//如果比value大则搜索(left , temp - 1)区域
			//如果和value相等搜索(left , temp)区域
			if (a[temp] < value) {
				left = temp + 1;
			} else if (a[temp] > value) { 
				right = temp - 1;
			} else {
				right = temp;
			}
		}
		//当left <= right时 跳出循环
		//当left == right时 left就是所求下标
		//当left <  right时 无解
		if (left == right) {
			return left;
		} else {
			return -1;
		}
	}
	
	//插值查找
	public int insertionSearch(int[] a, int left, int right, int value) {
		if (left > right) {
			return -1;
		} 
		
		int temp = left + (value - a[left]) / (a[right] - a[left]) * (right - left);
		//temp可能超出数组范围
		if (temp > right) {
			temp = right;
		} else if (temp < left) {
			temp = left;
		}
		
		if (a[temp] == value ) {
			return temp;
		} else if (a[temp] < value) {
			return binarySearch(a, temp + 1, right, value);
		} else {
			return binarySearch(a, left, temp - 1, value);
		}
	}
	
}
