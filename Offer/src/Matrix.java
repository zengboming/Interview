
public class Matrix {

	public Matrix(int n) {
		int[][] array = new int[n][n];
		int temp = 1;
		int num = n - 1;
		int i = 0, j = 0;
		while (num > 0) {
			for (int k = 0; k < num; k++) {
				array[i][j++] = temp++;
			}
			
			for (int k = 0; k < num; k++) {
				array[i++][j] = temp++;
			}
			
			for (int k = 0; k < num; k++) {
				array[i][j--] = temp++;
			}
			
			for (int k = 0; k < num; k++) {
				array[i--][j] = temp++;
			}
			
			i++;
			j++;
			num -= 2;
		}
		
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
