import java.awt.RenderingHints.Key;

public class Sort {

	public void InsertSort(int[] a) {
		int length = a.length;
		for (int i = 1; i < length; i++ ) {
			if (a[i] < a[i-1]) {
				int j = i-1;
				int temp = a[i];
				while (j >= 0 && temp < a[j]) {
					a[j+1] = a[j];
					j--;
				}
				a[j+1] = temp;
			}
		}
	}
	
	public void ShellSort(int[] a) {
		int length = a.length;
		int n = length/2;
		while (n >= 1) {
			for (int i = n; i < length ; i++) {
				//插入排序
				if (a[i] < a[i-n]) {
					int temp = a[i];
					int j = i-n;
					while (j >= 0 && temp < a[j]) {
						a[j+n] = a[j];
						j -= n;
					}
					a[j+n] = temp;
				}
			}
			n /= 2;
		}
	}
	
	public void SimpleSelectSort(int[] a) {
		int length = a.length;
		for (int i = 0; i < length ; i++) {
			int pos = i;
			for (int j = i + 1; j < length; j++) {
				if (a[j] < a[pos]) {
					pos = j;
				}
			}
			if (pos != i) {
				int temp = a[pos];
				a[pos] = a[i];
				a[i] = temp;
			}
		}
	}
	
	//二元选择排序：每次确定两个数（最大和最小）
	public void DoubleSelectSort(int[] a) {
		int length = a.length;
		for (int i = 0; i < length/2 ; i++) {
			int min = i;
			int max = i;
			for (int j = i + 1; j <= length - i - 1; j++) {
				if (a[j] < a[min]) {
					min = j;
					continue;
				}
				if (a[j] > a[max]) {
					max = j;
				}
			}
			if (min != i) {
				int temp = a[min];
				a[min] = a[i];
				a[i] = temp;
			}
			if (max != i) {
				int temp = a[max];
				a[max] = a[length - i - 1];
				a[length - i - 1] = temp;
			} else { //max == i 的情况，此时 a[i] 已经改变了
				int temp = a[min];
				a[min] = a[length - i - 1];
				a[length - i - 1] = temp;
			}
		}
	}
	
	public void BubbleSort(int[] a) {
		int length = a.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (a[i] > a[j]) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
	}
	
	public void FastSort(int[] a, int low, int high) {
		if (low >= high) {
			return;
		}
		int begin = low;
		int end = high;
		int pos = a[begin];
		while (begin < end) {
			while (begin < end && pos <= a[end]) {
				end--;
			}
			int temp = a[end];
			a[end] = a[begin];
			a[begin] = temp;
			
			while(begin < end && pos >= a[begin]) {
				begin++;
			}
			temp = a[begin];
			a[begin] = a[end];
			a[end] = temp;
		}
		FastSort(a, low, begin -1 );
		FastSort(a, begin + 1, high);
	}
	
	public void MergeSort(int[] a, int left, int right) {
		if (left < right) {
			int middle = (left + right)/2;
			MergeSort(a, left, middle);
			MergeSort(a, middle + 1, right);
			merge(left, middle, right, a);
		}
	}
	
	private void merge(int left, int middle, int right, int[] a) {
		int[] b = new int[right - left + 1]; 
		int k = 0;
		int low = left;
		int rig = middle + 1;
		while (low <= middle && rig <= right) {
			if (a[low] < a[rig]) {
				b[k++] = a[low++];
			} else {
				b[k++] = a[rig++];
			}
		}
		
		//将剩余的加入数组
		while (low <= middle) {
			b[k++] = a[low++];
		}
		
		while (rig <= right) {
			b[k++] = a[rig++];
		}
		
		//将临时数组b的数据存回a
		k = 0;
		while (left <= right) {
			a[left++] = b[k++];
		}
	}
}
