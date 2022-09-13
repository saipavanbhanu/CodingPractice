package leetcode.tree.bst;

public class LowestCommonAncestorOfABinarySearchTree235 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (root.val == p.val || root.val == q.val) {
				return root;
			} else if ((root.val < q.val && root.val > p.val) || (root.val < p.val && root.val > q.val)) {
				return root;
			} else if (root.val < p.val && root.val < q.val) {
				return lowestCommonAncestor(root.right, p, q);
			} else if (root.val > p.val && root.val > q.val) {
				return lowestCommonAncestor(root.left, p, q);
			} else
				return null; // this will not happen
		}
	}
}
