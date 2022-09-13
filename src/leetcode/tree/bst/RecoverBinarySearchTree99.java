package leetcode.tree.bst;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecoverBinarySearchTree99 {

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
		TreeNode prev1, curr1, prev2, curr2, iprev;

		public void recoverTree(TreeNode root) {
			// iterative inorder traversal
			if (root == null) {
				return;
			}
			prev1 = curr1 = prev2 = curr2 = iprev = null;
			Deque<TreeNode> stack = new ArrayDeque<>();
			TreeNode node = root;
			do {
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
				node = stack.pop();
				if (iprev == null) {
					iprev = node;
				} else {
					if (iprev.val < node.val) {
						iprev = node;
					} else {
						if (prev1 == null) {
							// first violation
							prev1 = iprev;
							curr1 = node;
						} else {
							prev2 = iprev;
							curr2 = node;
						}
					}
				}
				node = node.right;
			} while (!stack.isEmpty() || node != null);

			if (prev2 == null) {
				// only one violation i.e., adjacent nodes are swapped;
				int temp = prev1.val;
				prev1.val = curr1.val;
				curr1.val = temp;
			} else {
				int temp = prev1.val;
				prev1.val = curr2.val;
				curr2.val = temp;
			}
		}

	}
}
