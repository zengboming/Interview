import BinarySearchTree.Node;

public class AVLTree {

	private class AVLNode {
		public int value;
		public AVLNode left;
		public AVLNode right;
		public int height;
		
		public AVLNode(int value) {
			this.value = value;
			left = null;
			right = null;
			height = 1;
		}
	}
	
	public AVLNode root;
	
	public AVLTree() {
		root = null;
	}
	
	public int getHeight(AVLNode node) {
		if (node != null) {
			return node.height; 
		}
		return 0;
	}
	
	public int max(int a, int b) {
		return a > b ? a : b; 
	}
	
	private AVLNode leftLeftRotation(AVLNode k2) {
		AVLNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		
		k2.height = max(getHeight(k2.left), getHeight(k2.right));
		k1.height = max(getHeight(k1.left), getHeight(k1.right));
		return k1;
	}
	
	private AVLNode rightRightRotation(AVLNode k1) {
		AVLNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		
		k2.height = max(getHeight(k2.left), getHeight(k2.right));
		k1.height = max(getHeight(k1.left), getHeight(k1.right));
		return k2;
	}
	
	private AVLNode leftRightRotation(AVLNode k3) {
		k3.left = rightRightRotation(k3.left);
		return leftLeftRotation(k3);
	}
	
	private AVLNode rightLeftRotation(AVLNode k1) {
		k1.right = leftLeftRotation(k1.right);
		return rightRightRotation(k1);
	}
	
	public void insert(int value) {
		root = insert(root, value);
	}
	
	private AVLNode insert(AVLNode node, int value) {
		if (node == null) {
			node = new AVLNode(value);
			return node;
		}
		
		if (value > node.value) {
			node.right = insert(node.right, value);
			if (getHeight(node.right) - getHeight(node.left) > 1) {
				//RL
				if (value < node.right.value) {
					node = rightLeftRotation(node);
				} else { //RR
					node = rightRightRotation(node);
				}
			}
		} else {
			node.left = insert(node.left, value);
			if (getHeight(node.left) - getHeight(node.right) > 1) {
				//LL
				if (value < node.left.value) {
					node = leftLeftRotation(node);
				} else {
					node = leftRightRotation(node);
				}
			}
		}
		node.height = max(getHeight(node.left), getHeight(node.right));
		
		return node;
	}
	
	
}
