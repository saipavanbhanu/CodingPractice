package leetcode.tree.bt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {

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
		public List<List<Integer>> levelOrder(TreeNode root) {

			if (root == null) {
				return new ArrayList<>();
			}
			List<List<Integer>> result = new ArrayList<>();
			Queue<TreeNode> q = new ArrayDeque<>();
			q.add(root);

			while (!q.isEmpty()) {

				int size = q.size();
				List<Integer> levelNodes = new ArrayList<>(size);
				while (size > 0) {
					TreeNode node = q.remove();
					levelNodes.add(node.val);
					if (node.left != null) {
						q.add(node.left);
					}
					if (node.right != null) {
						q.add(node.right);
					}
					size--;
				}
				result.add(levelNodes);
			}

			return result;

		}
	}

}
