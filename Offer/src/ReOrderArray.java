
public class ReOrderArray {
	public void reOrderArray(int [] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
        	if (array[i] % 2 == 0) {
        		int j = i;
        		while (j < length && array[j] % 2 == 0) {
        			j++;
        		}
        		if (j < length) {
        			int temp = array[j];
        			while (j > i) {
        				array[j] = array[j - 1];
        				j--;
        			}
        			array[i] = temp;
        		}
        	}
        }
    }
}
