package geeksforgeeks.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NoOfIslands {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			String[] s = br.readLine().trim().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			char[][] grid = new char[n][m];
			for (int i = 0; i < n; i++) {
				String[] S = br.readLine().trim().split(" ");
				for (int j = 0; j < m; j++) {
					grid[i][j] = S[j].charAt(0);
				}
			}
			Solution obj = new Solution();
			int ans = obj.numIslands(grid);
			System.out.println(ans);
		}
	}
}// } Driver Code Ends

class Solution {
	// Function to find the number of islands.
	public int numIslands(char[][] grid) {
		// Code here
		final int ROWS = grid.length;
		final int COLUMNS = grid[0].length;
		int islandsCount = 0;
		boolean visited[][] = new boolean[ROWS][COLUMNS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				if (visited[i][j] == false && grid[i][j] == '1') {
					DFS(i, j, visited, grid);
					//System.out.println("DFS " + i + " " + j + "\nRecursion\n");
					islandsCount++;
				}
			}
		}

		return islandsCount;
	}

	private void DFS(int i, int j, boolean[][] visited, char[][] grid) {
		final int ROWS = visited.length;
		final int COLUMNS = visited[0].length;
		//System.out.print("(" + i + "," + j + ") ");
		visited[i][j] = true;

		if (i - 1 >= 0 && j - 1 >= 0 && visited[i - 1][j - 1] == false && grid[i - 1][j - 1] == '1') {
			DFS(i - 1, j - 1, visited, grid);
		}
		if (i - 1 >= 0 && j >= 0 && visited[i - 1][j] == false && grid[i - 1][j] == '1') {
			DFS(i - 1, j, visited, grid);
		}
		if (i - 1 >= 0 && j + 1 < COLUMNS && visited[i - 1][j + 1] == false && grid[i - 1][j + 1] == '1') {
			DFS(i - 1, j + 1, visited, grid);
		}
		if (j - 1 >= 0 && visited[i][j - 1] == false && grid[i][j - 1] == '1') {
			DFS(i, j - 1, visited, grid);
		}
		if (j + 1 < COLUMNS && visited[i][j + 1] == false && grid[i][j + 1] == '1') {
			DFS(i, j + 1, visited, grid);
		}
		if (i + 1 < ROWS && j - 1 >= 0 && visited[i + 1][j - 1] == false && grid[i + 1][j - 1] == '1') {
			DFS(i + 1, j - 1, visited, grid);
		}
		if (i + 1 < ROWS && visited[i + 1][j] == false && grid[i + 1][j] == '1') {
			DFS(i + 1, j, visited, grid);
		}
		if (i + 1 < ROWS && j + 1 < COLUMNS && visited[i + 1][j + 1] == false && grid[i + 1][j + 1] == '1') {
			DFS(i + 1, j + 1, visited, grid);
		}

	}
}