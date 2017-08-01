
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
        	a[i] = in.nextInt();
        }
        
        long result = 1;
        long r1 = 1;
        long r2 = 1;
        int m = 3;
        Arrays.sort(a);
        for (int i = n-1, j = 0; i >= j && m != 0; i--) {
        	r1 = a[i] * a[i - 1];
        	r2 = a[j] * a[j + 1];
        	if (r1 <= r2 && m>=2) {
        		result *= r2;
        		i++;
        		m -= 2;
        	} else {
        		result *= a[i];
        		m--;
        	}
        }
        System.out.println(result);
    }

}
