package leetcode.graph.dfs;

public class HouseRobber3 {

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
		public int rob(TreeNode root) {
			int[] value = dfs(root);
			return Math.max(value[0], value[1]);
		}

		private int[] dfs(TreeNode node) {
			if (node == null) {
				return new int[] { 0, 0 };
			}

			int[] left = dfs(node.left);
			int[] right = dfs(node.right);

			int withNode = node.val + left[1] + right[1];
			int withoutNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

			return new int[] { withNode, withoutNode };
		}

	}
}
