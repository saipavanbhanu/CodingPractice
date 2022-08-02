package leetcode.heap;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach1642 {
	class Solution {
		public int furthestBuilding(int[] h, int b, int l) {

			PriorityQueue<Integer> pq = new PriorityQueue<>();
			int i = 0;
			for (; i < h.length - 1; i++) {
				int d = h[i + 1] - h[i];
				if (d > 0) {
					pq.offer(d);
				}
				if (pq.size() > l) {
					b = b - pq.poll();
				}
				if (b < 0) {
					return i;
				}
			}
			return h.length - 1;
		}
	}

}
