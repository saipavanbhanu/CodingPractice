package leetcode.tree.bt;

public class PathSum112 {

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
		public boolean hasPathSum(TreeNode node, int targetSum) {
			if (node != null) {
				if (node.left == null && node.right == null) {
					if (targetSum == node.val)
						return true;
					else {
						// continue searching
						return false;
					}
				} else {

					if (hasPathSum(node.left, targetSum - node.val)) {
						return true;
					} else {
						return hasPathSum(node.right, targetSum - node.val);
					}

				}
			} else {
				return false;
			}
		}
	}
}
