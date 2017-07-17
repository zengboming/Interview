
public class Sort {

	//ֱ�Ӳ�������
	//ʱ�临�Ӷ� o(n2) �o(n2) ��ý�������o(n)
	//�ռ临�Ӷ� o(1)
	//�ȶ�
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
	
	//ϣ������
	//ʱ�临�Ӷ� o(nlogn) ���o(n2) ����o(n1.3)
	//�ռ临�Ӷ� o(1)
	//���ȶ�
	public void ShellSort(int[] a) {
		int length = a.length;
		int n = length/2;
		while (n >= 1) {
			for (int i = n; i < length ; i++) {
				//��������
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
	
	//��ѡ������
	//ʱ�临�Ӷ� o(n2) ���o(n2) ���o(n2)
	//�ռ临�Ӷ� o(1)
	//���ȶ�
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
	
	//��Ԫѡ������ÿ��ȷ����������������С��
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
			} else { //max == i ���������ʱ a[i] �Ѿ��ı���
				int temp = a[min];
				a[min] = a[length - i - 1];
				a[length - i - 1] = temp;
			}
		}
	}
	
	//ð������
	//ʱ�临�Ӷ� o(n2) ���o(n2) ���o(n2) ����ӱ�־λ ����Ϊo(n)
	//�ռ临�Ӷ� o(1)
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
	
	//��������
	//ʱ�临�Ӷ� o(nlogn) 
	//���(ÿһ��ȡ����Ԫ�ؾ�����������С/���� T[n] = n * (n-1) = n^2 + n) o(n2) 
	//���(ÿһ��ȡ����Ԫ�ض��պ�ƽ���������� T[n] = 2T[n/2] + f(n))o(nlogn)
	//�ռ临�Ӷ� ������o(logn) ������o(n) 
	//���ȶ�
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
	
	//�鲢����
	//ʱ�临�Ӷ� o(nlogn) ���o(nlogn) ���o(nlogn)
	//�ռ临�Ӷ� o(n)  ��ʱ������͵ݹ�ʱѹ��ջ������ռ�õĿռ䣺n + logn
	//�ȶ�
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
		
		//��ʣ��ļ�������
		while (low <= middle) {
			b[k++] = a[low++];
		}
		
		while (rig <= right) {
			b[k++] = a[rig++];
		}
		
		//����ʱ����b�����ݴ��a
		k = 0;
		while (left <= right) {
			a[left++] = b[k++];
		}
	}
	
	//������
	//ʱ�临�Ӷ� o(nlogn) ���o(nlogn)  ���o(nlogn)
	//�ռ临�Ӷ� o(1)
	//���ȶ�
	public void HeapSort(int[] a) {
		int length = a.length;
		//������ʼ��
		//���һ����Ҷ�ӽ����(length-1)/2
		for (int i = (length - 1) / 2; i >= 0; i--) {
			AdjustHeap(a, i, length);
		}
		//�����һ�����п�ʼ����
		for (int i = length - 1 ; i > 0; i--){
			//���Ѷ����Ԫ�غͶ������һ��Ԫ��
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			
			AdjustHeap(a, 0, i);
		}
	}
	
	//keyΪ��������Ԫ�ص�λ��
	private void AdjustHeap(int[] a, int key, int length) {
		//���� 
		int child = 2 * key + 1; 
		while (child < length) {
			 //�����Һ���������
			 if (child + 1 < length && a[child] < a[child + 1]) {
				 child++;
			 }
			 //����ϴ�ĺ��Ӵ��ڸ��ڵ㣬��������������key������һ����Ҫ������λ��
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
