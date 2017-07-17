
public class Main {
	public static void main(String args[]) {
		Sort sort = new Sort();
		int a[] = {3,1,5,7,2,4,9,6,10,8};  
		//sort.InsertSort(a);
		//sort.ShellSort(a);
		//sort.SimpleSelectSort(a);
		//sort.DoubleSelectSort(a);
		//sort.BubbleSort(a);
		//sort.FastSort(a, 0, 9);
		//sort.MergeSort(a, 0, 9);
		sort.HeapSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}
