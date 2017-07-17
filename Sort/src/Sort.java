
public class Sort {

	//直接插入排序：
	//时间复杂度 o(n2) 最坏o(n2) 最好近乎有序o(n)
	//空间复杂度 o(1)
	//稳定
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
	
	//希尔排序
	//时间复杂度 o(nlogn) 最差o(n2) 最优o(n1.3)
	//空间复杂度 o(1)
	//不稳定
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
	
	//简单选择排序
	//时间复杂度 o(n2) 最差o(n2) 最好o(n2)
	//空间复杂度 o(1)
	//不稳定
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
	
	//冒泡排序
	//时间复杂度 o(n2) 最差o(n2) 最好o(n2) 如果加标志位 最优为o(n)
	//空间复杂度 o(1)
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
	
	//快速排序
	//时间复杂度 o(nlogn) 
	//最差(每一次取到的元素就是数组中最小/最大的 T[n] = n * (n-1) = n^2 + n) o(n2) 
	//最好(每一次取到的元素都刚好平分整个数组 T[n] = 2T[n/2] + f(n))o(nlogn)
	//空间复杂度 最好情况o(logn) 最差情况o(n) 
	//不稳定
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
	
	//归并排序
	//时间复杂度 o(nlogn) 最差o(nlogn) 最好o(nlogn)
	//空间复杂度 o(n)  临时的数组和递归时压入栈的数据占用的空间：n + logn
	//稳定
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
	
	//堆排序
	//时间复杂度 o(nlogn) 最差o(nlogn)  最好o(nlogn)
	//空间复杂度 o(1)
	//不稳定
	public void HeapSort(int[] a) {
		int length = a.length;
		//构建初始堆
		//最后一个非叶子结点是(length-1)/2
		for (int i = (length - 1) / 2; i >= 0; i--) {
			AdjustHeap(a, i, length);
		}
		//从最后一个序列开始调整
		for (int i = length - 1 ; i > 0; i--){
			//将堆顶最大元素和堆中最后一个元素
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			
			AdjustHeap(a, 0, i);
		}
	}
	
	//key为待调整的元素的位置
	private void AdjustHeap(int[] a, int key, int length) {
		//左孩子 
		int child = 2 * key + 1; 
		while (child < length) {
			 //找左右孩子中最大的
			 if (child + 1 < length && a[child] < a[child + 1]) {
				 child++;
			 }
			 //如果较大的孩子大于父节点，交换，重新设置key，即下一个需要调整的位置
			 if (a[child] > a[key]) {
				 int temp = a[key];
				 a[key] = a[child];
				 a[child] = temp;
				 key = child;
				 child = 2 * key + 1;
			 } else {
				 break;
			 }	 
		 }
	}
	
}
