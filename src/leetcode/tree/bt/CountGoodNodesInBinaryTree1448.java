package leetcode.tree.bt;

public class CountGoodNodesInBinaryTree1448 {

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
		public int goodNodes(TreeNode root) {
			if (root == null)
				return 0;
			else if (root.left == null && root.right == null) {
				return 1;
			}
			int count = 1;
			count += dfs(root.left, root.val);
			count += dfs(root.right, root.val);
			return count;
		}

		int dfs(TreeNode node, int max) {
			if (node == null) {
				return 0;
			}
			int count = 0;
			if (node.val >= max) {
				count++;
				max = node.val;
			}
			count += dfs(node.left, max);
			count += dfs(node.right, max);
			return count;
		}
	}
}
