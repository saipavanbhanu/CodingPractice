package leetcode.heap;

import java.util.Random;

public class KthLargestElementInAnArray215 {
	class Solution {
		public int findKthLargest(int[] nums, int k) {
			shuffle(nums);
			return quickSelect(nums, 0, nums.length - 1, nums.length - k);
		}

		int quickSelect(int[] nums, int l, int r, int k) {
			int pivot = nums[r];
			int p = l;
			int i = -1;
			for (i = l; i < r; i++) {
				if (nums[i] <= pivot) {
					swap(nums, p, i);
					p++;
				}
			}
			swap(nums, p, r);
			if (p < k) {
				return quickSelect(nums, p + 1, r, k);
			} else if (p > k) {
				return quickSelect(nums, l, p - 1, k);
			} else {
				return nums[p];
			}
		}

		void swap(int[] nums, int i, int j) {
			if (i != j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}

		private void shuffle(int a[]) {
			final Random random = new Random();
			for (int ind = 1; ind < a.length; ind++) {
				final int r = random.nextInt(ind + 1);
				swap(a, ind, r);
			}
		}
	}
}
