package leetcode.arrays;

public class FibonacciNumber {
	class Solution {
		public int fib(int n) {
			if (n == 0) {
				return 0;
			} else if (n == 1) {
				return 1;
			} else {
				int prev2 = 0;
				int prev1 = 1;
				int temp = n - 1;
				int sum = 0;
				while (temp != 0) {
					sum = prev2 + prev1;
					prev2 = prev1;
					prev1 = sum;
					temp--;
				}
				return sum;
			}

		}
	}
}
