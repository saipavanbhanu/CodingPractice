package leetcode.tree;

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
		public int diameterOfBinaryTree(TreeNode root) {
			if (root == null) {
				return 0;
			}

			int leftHeight = height(root.left);
			int rightHeight = height(root.right);
			int usingHeight = leftHeight + rightHeight + 1;

			int leftDiameter = diameterOfBinaryTree(root.left);
			int rightDiameter = diameterOfBinaryTree(root.right);
			int usingDiameter = Math.max(leftDiameter, rightDiameter);

			return Math.max(usingHeight - 1, usingDiameter);
		}

		int height(TreeNode node) {
			if (node == null)
				return 0;
			return Math.max(height(node.left), height(node.right)) + 1;
		}
	}
}
