package leetcode.tree;

/*Calculated the diameter using the post order traversal ( bottom up approach ). 
max - variable to track the max diameter so far. and finally returning the max;*/

public class DiameterOfBinaryTree543 {
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
		int max;

		public int diameterOfBinaryTree(TreeNode root) {
			max = 0;
			dfs(root);
			return max;
		}

		// post order traversal //bottom up approach
		int dfs(TreeNode node) {
			if (node == null)
				return 0;

			int lh = dfs(node.left);
			int rh = dfs(node.right);

			max = Math.max(max, lh + rh);

			// return the height
			return Math.max(lh, rh) + 1;
		}
	}
}
