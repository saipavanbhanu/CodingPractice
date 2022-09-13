package leetcode.tree;

public class FlattenBinaryTreetoLinkedList114 {

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
		public void flatten(TreeNode root) {
			if (root == null) {
				return;
			}
			flattenToList(root);
		}

		TreeNode flattenToList(TreeNode node) {
			if (node == null || (node.left == null && node.right == null)) {
				return node;
			}

			TreeNode left = flattenToList(node.left);
			TreeNode right = flattenToList(node.right);

			if (left != null)
				node.right = left;

			if (right != null && left != null) {
				TreeNode iter = node.right;
				while (iter.right != null) {
					iter = iter.right;
				}
				iter.right = right;
			} else if (right != null && left == null) {
				node.right = right;
			}
			node.left = null;
			return node;
		}
	}
}
