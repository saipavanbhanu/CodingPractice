package geeksforgeeks.dp;

public class LongestCommonSubsequence {
	// Drivers code
	public static void main(String args[]) {
		String X = "ABCD";
		String Y = "AGCED";
		int m = X.length();
		int n = Y.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println("Length of LCS is " + lcs(X, Y, m, n, dp));
	}
	
	//Top down approach
	private static Integer lcs(final String x, final String y, final int m, final int n, int[][] dp) {
		// TODO Auto-generated method stub
		if (m == 0 || n == 0) {
			return 0;
		}
		if (dp[m][n] == -1) {
			if (x.charAt(m - 1) == y.charAt(n - 1)) {
				return 1 + lcs(x, y, m - 1, n - 1, dp);
			} else {
				return Math.max(lcs(x, y, m, n - 1, dp), lcs(x, y, m - 1, n, dp));
			}
		}

		return dp[m][n];
	}
}
