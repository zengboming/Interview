
public class NumberOf1Between1AndN {

	public int NumberOf1Between1AndN_Solution(int n) {
		int num = 0;
	    for (int i = 1; i <= n; i++) {
	    	num += get1(i);
	    }
	    return num;
    }
	
	static int get1(int n) {
		String string = Integer.toString(n);
		char[] array = string.toCharArray();
		int num = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '1') {
				num++;
			}
		}
		return num;
	}
}
