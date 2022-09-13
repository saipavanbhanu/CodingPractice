package geeksforgeeks.dp;

//https://www.geeksforgeeks.org/edit-distance-dp-5/

public class EditDistance {

	// Driver Code
	public static void main(String args[]) {
		String str1 = "sunday";
		int m = str1.length();
		String str2 = "saturday";
		int n = str2.length();
		int dp[][] = new int[m + 1][n + 1];

		// copying -1 value to entire array
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				dp[i][j] = -1;
			}
		}

		dp[m][n] = editDistDP(str1, str2, m, n, dp);
		// printDP(dp, m + 1, n + 1);
		System.out.println(dp[m][n]);
	}

	private static int editDistDP(String str1, String str2, int m, int n, int dp[][]) {
		if (m == 0) {
			return n;
		} else if (n == 0) {
			return m;
		}

		if (str1.charAt(m - 1) == str2.charAt(n - 1)) { // character at m == n
			if (dp[m - 1][n - 1] == -1) {
				dp[m - 1][n - 1] = editDistDP(str1, str2, m - 1, n - 1, dp);
				return dp[m - 1][n - 1];
			} else {
				return dp[m - 1][n - 1];
			}
		} else {
			return 1 + Math.min(editDistDP(str1, str2, m, n - 1, dp),
					Math.min(editDistDP(str1, str2, m - 1, n, dp), editDistDP(str1, str2, m - 1, n - 1, dp)));
		}
	}

	private static void printDP(int dp[][], int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(String.format("%2d", dp[i][j]));
			}
			System.out.println();
		}
	}
}
