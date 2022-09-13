package leetcode.hashing;

public class NumPairsDivisibleBy60 {
	class Solution {
		public int numPairsDivisibleBy60(int[] time) {
			int n = time.length;
			int count = 0;
			int hash[] = new int[60];
			for (int i = 0; i < n; i++) {
				int remainder = time[i] % 60;
				if (remainder != 0)
					count = count + hash[60 - remainder];
				else
					count = count + hash[0];
				hash[remainder] += 1;
			}
			return count;
		}
	}
}
