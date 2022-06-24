package geeksforgeeks.dp;

public class KnapSack {

	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}

	private static int knapSack(final int w, final int[] weights, final int[] profits, final int n) {
		int dp[][] = new int[n + 1][w + 1];
		// set values in 0th row as 0
		for (int i = 0; i <= w; i++) {
			dp[0][i] = 0;
		}
		// set values in 0th column as 0
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (j - weights[i - 1] >= 0 && j - weights[i - 1] <= w) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + profits[i - 1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][w];
	}

}
