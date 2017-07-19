import javax.swing.text.Highlighter.Highlight;

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
