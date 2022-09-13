package leetcode.arrays;

import java.util.*;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] numsClone = nums.clone();
		Arrays.sort(nums);
		int start = 0, end = nums.length - 1;
		while (start < end) {
			if (nums[start] + nums[end] == target) {
				return indices(nums[start], nums[end], numsClone);
			} else if (nums[start] + nums[end] < target) {
				start++;
			} else {
				end--;
			}
		}
		return null;
	}

	private int[] indices(int x, int y, int[] numsClone) {
		int xIndex = -1, yIndex = -1;
		int i = -1;

		if (x != y) {
			for (i = 0; i < numsClone.length; i++) {
				if (numsClone[i] == x) {
					xIndex = i;
					break;
				}
			}
			i = 0;
			for (; i < numsClone.length; i++) {
				if (numsClone[i] == y) {
					yIndex = i;
					break;
				}
			}
			return new int[] { xIndex, yIndex };
		} else {
			for (i = 0; i < numsClone.length; i++) {
				if (numsClone[i] == x) {
					xIndex = i;
					break;
				}
			}
			i++;
			for (; i < numsClone.length; i++) {
				if (numsClone[i] == y) {
					yIndex = i;
					break;
				}
			}
			return new int[] { xIndex, yIndex };
		}
	}
}