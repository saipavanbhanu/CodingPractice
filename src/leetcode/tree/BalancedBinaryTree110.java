package leetcode.tree;

public class BalancedBinaryTree110 {

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
		boolean balanced;

		public boolean isBalanced(TreeNode root) {
			balanced = true;

			height(root);

			return balanced;
		}

		int height(TreeNode node) {
			if (node == null) {
				return 0;
			}

			if (balanced == true) {
				int lh = height(node.left);
				if (balanced == false) {
					return 0;
				}
				int rh = height(node.right);
				if (balanced == false) {
					return 0;
				}
				if (Math.abs(lh - rh) <= 1) {
					balanced = true;
				} else {
					balanced = false;
				}
				return Math.max(lh, rh) + 1;
			} else {
				return 0;
			}

		}
	}
}
