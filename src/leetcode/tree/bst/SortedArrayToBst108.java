package leetcode.tree.bst;

public class SortedArrayToBst108 {

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
		public TreeNode sortedArrayToBST(int[] nums) {
			return arrayToBst(0, nums.length - 1, nums);
		}

		TreeNode arrayToBst(int start, int end, int[] nums) {
			if (start <= end) {
				int mid = (start + end) / 2;
				TreeNode node = new TreeNode(nums[mid], null, null);
				node.left = arrayToBst(start, mid - 1, nums);
				node.right = arrayToBst(mid + 1, end, nums);
				return node;
			}
			return null;
		}
	}
}
