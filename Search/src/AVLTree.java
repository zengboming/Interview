import org.omg.CORBA.PUBLIC_MEMBER;

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
	
	public int getHeight() {
		if (root == null) {
			return 0;
		}
		
		return getHeight(root);
	}
	
	private int getHeight(AVLNode node) {
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
	
	public AVLNode remove(int value) {
		return remove(root, value);
	}
	
	private AVLNode remove(AVLNode node, int value) {
		if (node == null) {
			return null;
		}
		
		//删除结点在左子树
		if (value < node.value) {
			node.left = remove(node.left, value);
			
			if (getHeight(node.right) - getHeight(node.left) > 1) {
				AVLNode rNode = node.right;
				//RL
				if (getHeight(rNode.left) > getHeight(rNode.right)) {
					node = rightLeftRotation(node);
				} else {   //RR
					node = rightRightRotation(node);
				}
			}
		} else if (value > node.value) {
			node.right = remove(node.right, value);
			
			if (getHeight(node.left) - getHeight(node.right) > 1) {
				AVLNode rNode = node.left;
				//LR
				if (getHeight(rNode.right) > getHeight(rNode.left)) {
					node = leftRightRotation(node);
				} else { //LL
					node = leftLeftRotation(node);
				}
			}
		} else {	//要删除的结点
			if ((node.left != null) && (node.right != null)) {
				//如果左子树更高，将左子树中最大的结点替换node，并删除最大结点
				//采用这种方式的好处是：删除"tree的左子树中最大节点"之后，AVL树仍然是平衡的。
				if (getHeight(node.left) > getHeight(node.right)) {
					AVLNode max = getMax(node.left);
					node.value = max.value;
					node.left = remove(node.left, max.value);
				} else {
					//如果右子树高，将左子树中最小的结点替换node，并删除最小结点
					//采用这种方式的好处是：删除"tree的右子树中最小节点"之后，AVL树仍然是平衡的。
					AVLNode min = getMin(node.right);
					node.value = min.value;
					node.right = remove(node.right, min.value);
				}
			} else if (node.left != null) {
				return node.left;
			} else if (node.right != null) {
				return node.right;
			} else {
				return null;
			}
		}
		return node;
	}
	
	public AVLNode getMax(AVLNode tree) {
		if (tree == null) {
			return null;
		}
		while(tree.right != null) {
			tree = tree.right;
		}
		return tree;
	}
	
	public AVLNode getMin(AVLNode tree) {
		if (tree == null) {
			return null;
		}
		while(tree.left != null) {
			tree = tree.left;
		}
		return tree;
	}
	
	public AVLNode get(int value) {		
		AVLNode node = root;
		while (node != null) {
			if (value > node.value) {
				node = node.right;
			} else if (value < node.value) {
				node = node.left;
			} else {
				return node;
			}
		}
		
		return null;
	}
	
	
}
