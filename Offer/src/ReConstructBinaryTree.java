
public class ReConstructBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		int length = pre.length;
		TreeNode root = function(pre, 0, length - 1,in, 0, length - 1);
        return root;
    }
	
	private TreeNode function(int[] pre, int left, int right, int[] in, int start,int end) {
		if (left > right || start > end) {
			return null;
		}
		
		TreeNode root = new TreeNode(pre[left]);
		for (int i = start; i <= end; i++) {
			if (pre[left] == in[i]) {
				root.left = function(pre, left + 1, right - end + i, in, start, i - 1);
				root.right = function(pre, left + 1 + i - start, right, in, i + 1, end);
			}
		}
		return root;
	}	
}
