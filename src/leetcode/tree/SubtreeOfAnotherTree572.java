package leetcode.tree;

public class SubtreeOfAnotherTree572 {

	static class TreeNode {
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
		boolean found;

		public boolean isSubtree(TreeNode root, TreeNode subRoot) {
			found = false;
			dfs(root, subRoot);
			return found;
		}

		void dfs(TreeNode root, TreeNode subRoot) {
			if (root == null) {
				return;
			}
			if (root.val == subRoot.val) {
				found = isEqual(root, subRoot);
				if (found == true) {

					return;
				} else {
					// continue dfs
					dfs(root.left, subRoot);
					if (found == false)
						dfs(root.right, subRoot);
				}
			} else {
				dfs(root.left, subRoot);
				if (found == false)
					dfs(root.right, subRoot);
			}
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
