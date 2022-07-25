package leetcode.tree.bst;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeIterator173 {

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

	class BSTIterator {
		Deque<TreeNode> stack;
		TreeNode node;

		public BSTIterator(TreeNode root) {
			// iterative inorder traversal
			stack = new ArrayDeque<>();
			TreeNode node = root;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}

		public int next() {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			int value = node.val;
			node = node.right;
			return value;
		}

		public boolean hasNext() {
			return (!stack.isEmpty() || node != null);
		}
	}

	/**
	 * Your BSTIterator object will be instantiated and called as such: BSTIterator
	 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
	 * obj.hasNext();
	 */
}
