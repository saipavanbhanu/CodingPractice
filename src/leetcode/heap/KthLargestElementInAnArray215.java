package leetcode.heap;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray215 {
	class Solution {
		public int findKthLargest(int[] nums, int k) {

			PriorityQueue<Integer> pq = new PriorityQueue<>(k);

			// maintain a heap of size of k ( k - largest elements)
			for (int i = 0; i < nums.length; i++) {
				if (pq.size() < k) {
					pq.add(nums[i]);
				} else {
					pq.add(nums[i]);
					pq.poll();
				}
			}

			// int size = pq.size();
			// while(size-1 > 0){
			// pq.poll();
			// size--;
			// }
			int result = pq.poll();
			pq = null;
			return result;
		}
	}
}
