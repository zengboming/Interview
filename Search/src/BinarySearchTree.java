
public class BinarySearchTree {

	public class Node {
		public Node left;
		public Node right;
		public int value;
		public Node(int value) {
			this.value = value;
			left  = null;
			right = null;
		}
	}
	
	private Node root;
	private int size;
	
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public int getSize() {
		return size;
	}
	
	public Node get(int value) {
		Node node = root;
		while (node != null) {
			if (node.value == value) {
				return node;
			} else if (node.value > value) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}
	
	//递归算法
	public Node getRecursion(Node root, int value) {
		if (root == null) {
			return null;
		}
		if (root.value > value) {
			return getRecursion(root.left, value);
		} else if (root.value < value) {
			return getRecursion(root.right, value);
		} else {
			return root;
		}
	}
	
	public void put(int value) {
		root = put(root, value);
	}
	
	//返回的是根结点
	private Node put(Node node, int value) {
		//结点为空
		if (node == null) {
			System.out.println("put node value = " + value);
			node = new Node(value);
			size ++;
			return node;
		}
		
		if (node.value < value) {
			node.right = put(node.right, value);
		} else if (node.value > value) {
			node.left = put(node.left, value);
		} else {
			node.value = value;
		}
		return node;
	}
	
	//先序序列 根左右
	public void getFontOrder() {
		getFontOrder(root);
	}
	private void getFontOrder(Node root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.value + " ");
		getFontOrder(root.left);
		getFontOrder(root.right);
	}
	
	//中序序列 左根右
	public void getMiddleOrder() {
		getMiddleOrder(root);
	}
	
	private void getMiddleOrder(Node root) {
		if (root == null) {
			return;
		}
		
		getMiddleOrder(root.left);
		System.out.print(root.value + " ");
		getMiddleOrder(root.right);
	}
	
	//后序序列 左友根
	public void getBehindOrder() {
		getBehindOrder(root);
	}
	
	private void getBehindOrder(Node root) {
		if (root == null) {
			return;
		}
		
		getBehindOrder(root.left);
		getBehindOrder(root.right);
		System.out.print(root.value + " ");
	}
}
