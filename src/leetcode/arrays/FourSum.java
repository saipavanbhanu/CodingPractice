package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {

	class Solution {
		public List<List<Integer>> fourSum(int[] nums, int target) {
			Arrays.sort(nums);
			int n = nums.length;
			int max = nums[n - 1];
			List<List<Integer>> result = new ArrayList(n);
			for (int i = 0; i < n - 3; i++) {
				for (int j = i + 1; j < n - 2; j++) {
					long diff = (long) target - (long) (nums[i] + nums[j]);
					if (diff < (long) Integer.MIN_VALUE) {
						while (j + 1 < n - 2 && nums[j] == nums[j + 1])
							j++;
						continue;
					} else {
						int start = j + 1, end = n - 1;
						while (start < end) {
							int sum = nums[start] + nums[end];
							if (sum == diff) {
								result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
								while (start + 1 < end && nums[start] == nums[start + 1])
									start++;
								while (end - 1 > start && nums[end] == nums[end - 1])
									end--;
								start++;
								end--;
							} else if (sum < diff) {
								start++;
							} else {
								end--;
							}
						}
						while (j + 1 < n - 2 && nums[j] == nums[j + 1])
							j++;
					}

				}
				while (i + 1 < n - 3 && nums[i] == nums[i + 1])
					i++;
			}

			return result;
		}
	}
}