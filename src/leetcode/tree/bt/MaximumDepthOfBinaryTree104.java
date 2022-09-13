package leetcode.tree.bt;

public class MaximumDepthOfBinaryTree104 {
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
		int max = 0;

		public int maxDepth(TreeNode root) {
			depth(root, 0);
			return max;
		}

		void depth(TreeNode node, int depth) {
			if (node != null) {
				depth++;
				max = Math.max(max, depth);
				depth(node.left, depth);
				depth(node.right, depth);
			}
		}
	}
}
