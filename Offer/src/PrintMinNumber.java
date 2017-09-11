import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
	public String PrintMinNumber(int[] numbers) {
		Integer[] array = new Integer[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			array[i] = numbers[i];
		}
		
		Arrays.sort(array, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == o2) {
					return 0;
				}
				
				String c1 = Integer.toString(o1);
				String c2 = Integer.toString(o2);
				int length1 = c1.length();
				int length2 = c2.length();
				char temp;
				if (length1 == length2) {
					return o1 - o2;
				} else if (length1 > length2) {
					//长度不等时，将短的增长，空位补a[n-1]
					temp = c2.charAt(length2 - 1);
					while (c2.length() != length1) {
						c2 += temp;		
					}
				} else {
					temp = c1.charAt(length1 - 1);
					while (c1.length() != length2) {
						c1 += temp;					
					}
				}
				return c1.compareTo(c2);
			}	
		});
		
		String string = "";
		for (int i = 0; i < array.length; i++) {
			string += Integer.toString(array[i]);
		}
		return string;
    }
}
