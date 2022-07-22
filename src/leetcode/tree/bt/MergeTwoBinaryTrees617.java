package leetcode.tree.bt;

import leetcode.tree.bt.InvertBinaryTree226.TreeNode;

public class MergeTwoBinaryTrees617 {
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
		public TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
			if (node1 != null && node2 != null) {
				TreeNode node = new TreeNode(node1.val + node2.val);
				node.left = mergeTrees(node1.left, node2.left);
				node.right = mergeTrees(node1.right, node2.right);
				return node;
			} else if (node1 == null) {
				return node2;
			} else if (node2 == null) {
				return node1;
			} else {
				return null;
			}
		}
	}
}
