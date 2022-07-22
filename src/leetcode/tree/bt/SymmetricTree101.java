package leetcode.tree.bt;

public class SymmetricTree101 {

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
		public boolean isSymmetric(TreeNode root) {
			if (root == null) {
				return true;
			}

			return isSymmetric(root.left, root.right);
		}

		boolean isSymmetric(TreeNode node1, TreeNode node2) {
			if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
				return false;
			} else if (node1 == null && node2 == null) {
				return true;
			} else {
				if (node1.val == node2.val) {
					return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
				} else {
					return false;
				}
			}
		}
	}
}
