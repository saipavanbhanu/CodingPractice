package leetcode.tree.bt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class AllNodesDistanceKInBinaryTree863 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		Map<Integer, TreeNode> parentMap;
		List<Integer> result;

		public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
			if (root == null) {
				return new ArrayList<>();
			} else {
				// result = new ArrayList<>();
				parentMap = new HashMap<>();
				parentMap.put(root.val, null);
				generate(root);
				Queue<TreeNode> q = new ArrayDeque<>();
				q.add(target);
				Set<Integer> set = new HashSet<>(501);
				set.add(target.val);
				int times = k;
				while (times > 0) {
					int size = q.size();
					while (size > 0) {
						TreeNode node = q.remove();
						set.add(node.val);

						if (node.left != null && set.contains(node.left.val) == false) {
							q.add(node.left);
						}
						if (node.right != null && set.contains(node.right.val) == false) {
							q.add(node.right);
						}
						TreeNode parent = parentMap.get(node.val);
						if (parent != null && set.contains(parent.val) == false) {
							q.add(parent);
						}
						size--;
					}
					times--;
				}

				return q.stream().map(node -> node.val).collect(Collectors.toList());
			}

		}

		void generate(TreeNode node) {
			if (node == null) {
				return;
			} else {
				if (node.left != null) {
					parentMap.put(node.left.val, node);
				}
				if (node.right != null) {
					parentMap.put(node.right.val, node);
				}
				generate(node.left);
				generate(node.right);
			}
		}
	}
}
