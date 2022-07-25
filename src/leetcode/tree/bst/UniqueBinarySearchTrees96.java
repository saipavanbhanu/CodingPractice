package leetcode.tree.bst;

/*
 * https://www.youtube.com/watch?v=Ox0TenN3Zpg&ab_channel=NeetCode
 * */

public class UniqueBinarySearchTrees96 {

	class Solution {
		public int numTrees(int n) {
			int[] dp = new int[n + 1];
			for (int i = 0; i < n + 1; i++) {
				dp[i] = 1;
			}

			for (int nodes = 2; nodes < n + 1; nodes++) {
				int total = 0;
				for (int root = 1; root < nodes + 1; root++) {
					int left = root - 1;
					int right = nodes - root;
					total = total + dp[left] * dp[right];
				}
				dp[nodes] = total;
			}
			return dp[n];
		}
	}
}
