package leetcode.arrays;

public class FindPivotIndex {
	class Solution {
		public int pivotIndex(int[] nums) {
			if (nums == null || nums.length == 0) {
				return -1;
			}
			int right = 0, left = 0;
			for (int i = 0; i < nums.length; i++) {
				right = right + nums[i];
			}
			for (int i = 0; i < nums.length; i++) {
				right = right - nums[i];
				if (left == right) {
					return i;
				} else {
					left = left + nums[i];
				}
			}
			return -1;
		}
	}
}
