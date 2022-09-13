package leetcode.tree.bt;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {

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
		List<String> result;

		public List<String> binaryTreePaths(TreeNode root) {
			result = new ArrayList<>();
			if (root == null) {
				return result;
			}
			StringBuilder sb = new StringBuilder();
			binaryTreePaths(root, sb);
			return result;
		}

		void binaryTreePaths(TreeNode node, StringBuilder sb) {
			if (node == null) {
				return;
			}
			if (node != null && node.left == null && node.right == null) {
				sb.append(node.val);
				result.add(sb.toString());
				sb.append("->");
				delete(sb);
			} else {
				sb.append(node.val).append("->");
				binaryTreePaths(node.left, sb);
				binaryTreePaths(node.right, sb);
				delete(sb);
			}
		}

		void delete(StringBuilder sb) {
			do {
				sb.deleteCharAt(sb.length() - 1); // removing the last character
			} while ((sb.length() - 1) >= 0 && sb.charAt(sb.length() - 1) != '>');
		}
	}
}
