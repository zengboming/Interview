import javax.xml.soap.Node;

public class Main {

	public static void main(String[] args) {
		
		int a[] = {3, 2, 1, 5, 6, 7, 9};
		//int result ;
		//Search search = new Search();
		//result = search.binarySearch(a, 0, 6, 9);
		//result = search.insertionSearch(a, 0, 6, 8);
		BinarySearchTree tree = new BinarySearchTree();
		for (int i = 0; i < a.length; i++) {
			tree.put(a[i]);
		}
		BinarySearchTree.Node node = tree.get(5);
		if (tree.get(5) != null) {
			System.out.println(node.value);
		}

		tree.getFontOrder();
		System.out.println();
		tree.getMiddleOrder();
		System.out.println();
		tree.getBehindOrder();
		System.out.println();
		
		
		
	}
	
}
