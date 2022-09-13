package leetcode.tree.bt;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView199 {

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
		List<Integer> result;

		public List<Integer> rightSideView(TreeNode root) {
			result = new ArrayList<>();
			dfs(root, 0);
			return result;
		}

		void dfs(TreeNode node, int index) {
			if (node == null) {
				return;
			} else {
				if (index == result.size()) {
					result.add(node.val);
				}
				dfs(node.right, index + 1);
				dfs(node.left, index + 1);
			}
		}

	}
}
