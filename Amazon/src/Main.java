import java.util.Scanner;

public class Main {

	    static int max = 0;
	    static int sum = 0;
	    static int num0 = 0;
	    
	    public static void main(String[] args) {
	    	Scanner in  = new Scanner(System.in);
	    	int k = in.nextInt();
	    	//int k = 3;
	    	String string = "1001001001";
	    	System.out.println(findDifferentWays(string.length(), k, string));
	    	
	    }
	    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	    static int findDifferentWays(int size, int allowedChanges, String str)      
	    {
	        // WRITE YOUR CODE HERE
	        char[] array = str.toCharArray();
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] == '0') {
	                num0++;
	            }
	        }
	        if (allowedChanges >= num0) {
	            return 1;
	        }
	        
	        combine(0, allowedChanges, array);
	        return sum;
	    }
	    
	    //在所有的0中选k个变为1
	    static void combine(int index, int k, char[] array) {
	        if (k == 1) {
	            for (int i = index; i < array.length; i++) {
	                if (array[i] == '0') {
	                    array[i] = '1';
	                    int maxSize = getMaxSize(array);//获取最大长度
	                    if (maxSize > max) {
	                        max = maxSize;
	                        sum = 1;
	                    } else if (maxSize == max) {
	                        sum++;
	                    }
	                    array[i] = '0';
	                }
	            }
	        } else {
	            for (int i = index; i <= array.length - k; i++) {
	                if (array[i] == '0') {
	                    array[i] = '1';
	                    combine(i + 1, k - 1, array);
	                    array[i] = '0';
	                    //j++;
	                }
	            }
	        }
	    }
	    
	    static int getMaxSize(char[] array) {
	        int maxSize = 0;
	        int size = 0;
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] == '1') {
	                size++;
	            } else {
	                if (size > maxSize) {
	                    maxSize = size;
	                }
	                size = 0;
	            }
	        }
	        if (size > maxSize) {
	            maxSize = size;
	        }
	        
	        return maxSize;
	    }

}
