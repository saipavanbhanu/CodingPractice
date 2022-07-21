package leetcode.tree.bt;

public class SubtreeOfAnotherTree572 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {
		public boolean isSubtree(TreeNode root, TreeNode subRoot) {
			if ((root == null && subRoot != null) || (root != null && subRoot == null)) {
				return false;
			}
			if (root.val == subRoot.val) {
				if (isEqual(root, subRoot)) {
					return true;
				}
			}
			return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
		}

		boolean isEqual(TreeNode root, TreeNode subRoot) {
			if (root != null && subRoot != null) {
				return (root.val == subRoot.val) && isEqual(root.left, subRoot.left)
						&& isEqual(root.right, subRoot.right);
			} else if (root == null && subRoot == null) {
				return true;
			}
			return false;
		}
	}
}
