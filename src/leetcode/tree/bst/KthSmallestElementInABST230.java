package leetcode.tree.bst;

public class KthSmallestElementInABST230 {

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
		int count = 0;
		int element = -1;

		public int kthSmallest(TreeNode root, int k) {
			inorder(root, k);
			return element;
		}

		void inorder(TreeNode node, int k) {
			if (node == null) {
				return;
			}

			inorder(node.left, k);

			count++;
			if (count == k) {
				element = node.val;
				return;
			} else if (element != -1) {
				return;
			}
			inorder(node.right, k);

		}
	}

}
