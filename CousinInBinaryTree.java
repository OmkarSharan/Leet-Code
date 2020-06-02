package coding.leetCode.mayChalange;

/// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

}

public class CousinInBinaryTree {
	int count = 0;
	public int depth(TreeNode root, int x) {
		if(root == null) return Integer.MIN_VALUE;
		if (root.val == x)
			return 1;
		int left = depth(root.left, x );
		int right = depth(root.right, x);
		return 1+Math.max(left, right);
		//return count;//1+Math;.max(depth(root.left, x ), depth(root.right, x));
	}

	public TreeNode findRootofChild(TreeNode root, int x) {
		if(root == null) return null;
		if(root.left != null && root.left.val == x)
			return root;
		if(root.right != null && root.right.val == x)
			return root;
		TreeNode ptr1= findRootofChild(root.left, x);
		TreeNode ptr2=findRootofChild(root.right,x);
		return ptr1 == null ? ptr2 : ptr1; 
	}
	public boolean isCousins(TreeNode root, int x, int y) {
		TreeNode temp = root;
		int d1 = depth(temp, x);
		int d2 = depth(temp, y);
		if(d1 != d2) return false;
		TreeNode p1 = findRootofChild(root, x);
		TreeNode p2 = findRootofChild(root, y);
		if(p1 != p2) return true;
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(6);
		root.right.right.left.right = new TreeNode(8);
		root.right.right.right.right = new TreeNode(9);
		
		CousinInBinaryTree cousins = new CousinInBinaryTree();
		System.out.println(cousins.isCousins(root, 8, 9));
	}
	


}
