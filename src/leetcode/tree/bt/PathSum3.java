package leetcode.tree.bt;

import java.util.HashMap;
import java.util.Map;

/*
 * Approach similar to Sub Array sum equal to k in an array. 
 * And even this approach is linear in terms of complexity 
 * https://www.youtube.com/watch?v=MHocw0bP1rA&t=241s&ab_channel=Codebix
 * https://www.youtube.com/watch?v=yyZA4v0x16w&ab_channel=Codebix
 * */

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

		public int pathSum(TreeNode root, int targetSum) {
			if (root == null) {
				return 0;
			}
			count = 0;
			Map<Long, Integer> map = new HashMap<>();
			map.put((long) 0, 1);

			pathSumFromNode(root, 0, targetSum, map);

			return count;
		}

		void pathSumFromNode(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> map) {
			if (node == null) {
				return;
			}
			long sum = node.val + currentSum;
			if (map.containsKey(sum - targetSum) == true) {
				count = count + map.get(sum - targetSum);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);

			pathSumFromNode(node.left, sum, targetSum, map);
			pathSumFromNode(node.right, sum, targetSum, map);

			map.put(sum, map.get(sum) - 1);

		}
	}
}
