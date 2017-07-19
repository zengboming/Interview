import javax.xml.soap.Node;

public class Main {

	public static void main(String[] args) {
		
		int a[] = {3, 2, 1, 5, 6, 7, 9};
		//int result ;
		//Search search = new Search();
		//result = search.binarySearch(a, 0, 6, 9);
		//result = search.insertionSearch(a, 0, 6, 8);
		BinarySearchTree tree = new BinarySearchTree();
		BinarySearchTree.Node root = tree.getRoot();
		for (int i = 0; i < a.length; i++) {
			root = tree.put(root, a[i]);
		}
//		BinarySearchTree.Node node = tree.get(5);
//		if (node != null) {
//			System.out.println(node.value);
//		}
		if (root == null) {
			System.out.println("root is null");
		}
		tree.getFontOrder(root);
		System.out.println();
		tree.getMiddleOrder(root);
		System.out.println();
		tree.getBehindOrder(root);
		System.out.println();
		
		
		
	}
	
}
