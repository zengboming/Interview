import javax.xml.soap.Node;

public class Main {

	public static void main(String[] args) {
		
//		int a[] = {3, 2, 1, 5, 6, 7, 9};
//		//int result ;
//		//Search search = new Search();
//		//result = search.binarySearch(a, 0, 6, 9);
//		//result = search.insertionSearch(a, 0, 6, 8);
//		BinarySearchTree tree = new BinarySearchTree();
//		for (int i = 0; i < a.length; i++) {
//			tree.put(a[i]);
//		}
//		BinarySearchTree.Node node = tree.get(5);
//		if (tree.get(5) != null) {
//			System.out.println(node.value);
//		}
//
//		tree.getFontOrder();
//		System.out.println();
//		tree.getMiddleOrder();
//		System.out.println();
//		tree.getBehindOrder();
//		System.out.println();
		
		
//		int arr[]= {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};
//		
//		int i;
//		AVLTree tree = new AVLTree();
//		
//		System.out.printf("== �������: ");
//		for(i=0; i<arr.length; i++) {
//			System.out.printf("%d ", arr[i]);
//			tree.insert(arr[i]);
//		 }
//		
//		System.out.printf("\n== ǰ�����: ");
//		tree.preOrder();
//		 
//		System.out.printf("\n== �������: ");
//		tree.inOrder();
//		
//		System.out.printf("\n== �������: ");
//		tree.postOrder();
//		System.out.printf("\n");
//		
//		 
//		System.out.printf("== �߶�: %d\n", tree.getHeight());
//		 
//		i = 8;
//		System.out.printf("\n== ɾ�����ڵ�: %d", i);
//		tree.remove(i);
//		
//		System.out.printf("\n== �߶�: %d", tree.getHeight());
//		System.out.printf("\n== �������: ");
//		tree.inOrder();
//
//		// ���ٶ�����
//		tree.destroy();
		
		int[] a = {1,2,3,3,4,4,6,7,8,10,10};
		Search search = new Search();
		System.out.println(search.binarySearchFirst(a, 0, 10, 6));
		//System.out.println(search.binarySearch(a, 0, 7, 3));
	}
	
}
