
public class Fibonacci {
	public int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		}
		else {
			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
    }
	
	public int Fibonacci2(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		} else {
			int pre = 1;
			int next = 1;
			for (int i = 3; i <= n; i++) {
				int temp = pre;
				pre = next;
				next = temp + next;
			}
			return next;
		}
		
	}
}
 