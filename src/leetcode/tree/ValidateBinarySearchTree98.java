package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidateBinarySearchTree98 {

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
		int prev;

		public boolean isValidBST(TreeNode root) {
			// iterative inorder traversal
			if (root == null) {
				return true;
			}

			boolean isBst = true;
			TreeNode prev = null;
			Deque<TreeNode> stack = new ArrayDeque<>(10000);
			TreeNode node = root;
			do {
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
				node = stack.pop();
				if (prev == null) {
					prev = node;
				} else {
					if (prev.val < node.val) {
						// System.out.println(prev.val+" "+node.val);
						isBst = true;
						prev = node;
					} else {
						isBst = false;
						return isBst;
					}
				}
				node = node.right;
			} while (!stack.isEmpty() || node != null);

			return isBst;
		}
	}
}
