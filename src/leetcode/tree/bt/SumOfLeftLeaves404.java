package leetcode.tree.bt;

public class SumOfLeftLeaves404 {

	public class TreeNode {
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
		int leftSum = 0;

		public int sumOfLeftLeaves(TreeNode root) {
			dfs(root);
			return leftSum;
		}

		void dfs(TreeNode node) {
			if (node == null)
				return;
			else { // node not null
				if (node.left != null && node.left.left == null && node.left.right == null) {
					leftSum += node.left.val;
					dfs(node.right);
					return;
				} else {
					dfs(node.left);
					dfs(node.right);
				}
			}
		}
	}
}
