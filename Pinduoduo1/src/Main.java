
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.next();
        String num2 = in.next();
        System.out.println(multiply(num1, num2));
       
    }
    
    static String multiply(String num1, String num2) {
    	char a1[] = num1.toCharArray();
    	char a2[] = num2.toCharArray();
    	int len1 = a1.length;
    	int len2 = a2.length;
    	
    	int result[] = new int[len1 + len2];
    	int array1[] = new int[len1];
    	int array2[] = new int[len2];
    	
    	for (int i = 0; i < len1; i++) {
    		array1[i] = a1[i] - '0';
    	}
    	for (int i = 0; i < len2; i++) {
    		array2[i] = a2[i] - '0';
    	}
    	
    	for (int i = 0; i < len1; i++) {
    		for (int j = 0; j < len2; j++) {
    			result[i + j] += array1[i] * array2[j];
    		}
    	}
    	
    	int length = result.length;
    	for (int i = length - 1; i > 0; i--) {
    		result[i - 1] += result[i] / 10;
    		result[i] = result[i] % 10;
    	}
    	
    	String str = "";
    	
    	for (int i = 0; i < length - 1; i++) {
    		str += "" + result[i];
    	}
    	
    	return str;
    }
}