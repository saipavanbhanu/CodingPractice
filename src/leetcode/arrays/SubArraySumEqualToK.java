package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/

public class SubArraySumEqualToK {

	class Solution {
		public int subarraySum(int[] nums, int k) {
			int n = nums.length;
			int count = 0;
			int sum = 0;
			Map<Integer, Integer> map = new HashMap<>(n);
			for (int i = 0; i < n; i++) {
				sum = sum + nums[i];
				if (sum == k) {
					count++;
				}
				if (map.containsKey(sum - k)) {
					count = count + map.get(sum - k);
				}
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
			return count;
		}
	}

}
