package leetcode.tree.bt;

public class PathSum3 {

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
		int count;
		int iTarget;

		public int pathSum(TreeNode root, int targetSum) {
			count = 0;
			iTarget = targetSum;
			dfs(root, targetSum);
			return count;
		}

		void dfs(TreeNode node, int targetSum) {
			if (node == null) {
				return;
			}
			pathsCount(node, targetSum);
			dfs(node.left, targetSum);
			dfs(node.right, targetSum);
		}

		void pathsCount(TreeNode node, int targetSum) {
			if (node == null) {
				return;
			}

			// include the node
			int target = targetSum - node.val;
			if (target == 0) {
				// System.out.println(node.val+","+targetSum);
				count++;
				pathsCount(node.left, iTarget);
				pathsCount(node.right, iTarget);
			} else {
				pathsCount(node.left, target);
				pathsCount(node.right, target);
			}

			// //not including the node
			// target = targetSum;
			// pathsCount(node.left, target);
			// pathsCount(node.right, target);

		}
	}
}
