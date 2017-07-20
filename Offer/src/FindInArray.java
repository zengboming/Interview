
public class FindInArray {
	public boolean Find(int target, int [][] array) {
		for (int i = 0; i < array.length; i++) {
			int line = array[0].length;
			if (line == 0) {
				return false;
			}
			if (array[i][0] <= target && array[i][line - 1] >= target) {
				if(binarySearch(array[i], 0, line, target)) {
					return true;
				}
			}
		}
		return false;
    }
	
	private boolean binarySearch(int[] array, int left, int right, int target) {
		if (left > right) {
			return false;
		}
		int mid = (left + right) / 2;
		if (array[mid] > target) {
			return binarySearch(array, left, mid - 1, target);
		} else if (array[mid] < target) {
			return binarySearch(array, mid + 1, right, target);
		} else {
			return true;
		}
	}
	
	public boolean Find2(int target, int [][] array) {
		int row = array.length;
		int line = array[0].length;
		int i, j;
		for (i = row - 1, j = 0; i >= 0 && j < line; ) {
			if (array[i][j] > target) {
				i--;
			} else if (array[i][j] < target) {
				j++;
			} else {
				return true;
			}
		}
		return false;
	}
}
