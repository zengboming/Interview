
public class Main {

	public static void main(String[] args) {
		
		int a[] = {1, 2, 3, 5, 9, 9, 9};
		int result ;
		Search search = new Search();
		//result = search.binarySearch(a, 0, 6, 9);
		result = search.InsertionSearch(a, 0, 6, 9);
		System.out.println(result);
		
	}
	
}
