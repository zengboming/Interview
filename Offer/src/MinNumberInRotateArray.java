
public class MinNumberInRotateArray {
	 public int minNumberInRotateArray(int [] array) {
		 if (array.length == 0) {
			 return 0;
		 }
		 int i = 0; 
		 for (; i < array.length - 1; i++) {
			 if (array[i] > array[i + 1]) {
				 break;
			 }
		 }
		 return array[i+1];
	 }
}
