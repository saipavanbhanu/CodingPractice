package geeksforgeeks.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class LargestRegionOf1s
{
 public static void main(String[] args) throws IOException
 {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int T = Integer.parseInt(br.readLine().trim());
     while(T-->0)
     {
         String[] s = br.readLine().trim().split(" ");
         int n = Integer.parseInt(s[0]);
         int m = Integer.parseInt(s[1]);
         int[][] grid = new int[n][m];
         for(int i = 0; i < n; i++){
             String[] S = br.readLine().trim().split(" ");
             for(int j = 0; j < m; j++){
                 grid[i][j] = Integer.parseInt(S[j]);
             }
         }
         Solution5 obj = new Solution5();
         int ans = obj.findMaxArea(grid);
         System.out.println(ans);
     }
 }
}// } Driver Code Ends


class Solution5{
 int maxArea = -1, count = 1;
 
 private void DFS(int[][] grid, int i, int j, boolean[][] visited){
     final int ROWS = visited.length;
		final int COLUMNS = visited[0].length;
		//System.out.print("(" + i + "," + j + ") ");
		visited[i][j] = true;

		if (i - 1 >= 0 && j - 1 >= 0 && visited[i - 1][j - 1] == false && grid[i - 1][j - 1] == 1) {
			DFS(grid, i - 1, j - 1, visited);
			count++;
		}
		if (i - 1 >= 0 && j >= 0 && visited[i - 1][j] == false && grid[i - 1][j] == 1) {
			DFS(grid, i - 1, j, visited);
			count++;
		}
		if (i - 1 >= 0 && j + 1 < COLUMNS && visited[i - 1][j + 1] == false && grid[i - 1][j + 1] == 1) {
			DFS(grid, i - 1, j + 1, visited);
			count++;
		}
		if (j - 1 >= 0 && visited[i][j - 1] == false && grid[i][j - 1] == 1) {
			DFS(grid, i, j - 1, visited);
			count++;
		}
		if (j + 1 < COLUMNS && visited[i][j + 1] == false && grid[i][j + 1] == 1) {
			DFS(grid, i, j + 1, visited);
			count++;
		}
		if (i + 1 < ROWS && j - 1 >= 0 && visited[i + 1][j - 1] == false && grid[i + 1][j - 1] == 1) {
			DFS(grid, i + 1, j - 1, visited);
			count++;
		}
		if (i + 1 < ROWS && visited[i + 1][j] == false && grid[i + 1][j] == 1) {
			DFS(grid, i + 1, j, visited);
			count++;
		}
		if (i + 1 < ROWS && j + 1 < COLUMNS && visited[i + 1][j + 1] == false && grid[i + 1][j + 1] == 1) {
			DFS(grid, i + 1, j + 1, visited);
		    count++;
		}
		
 }
 
 //Function to find unit area of the largest region of 1s.
 public int findMaxArea(int[][] grid){
     final int ROWS = grid.length, COLUMNS = grid[0].length;
     boolean visited[][] = new boolean[ROWS][COLUMNS];
     
     for(int i = 0; i < ROWS; i++){
         for(int j = 0; j < COLUMNS; j++){
             if(grid[i][j] == 1 && !visited[i][j]  ){
                 count = 1;
                 DFS(grid, i, j, visited);
                 //System.out.println("count: "+count);
                 if(maxArea < count){
                     maxArea = count;
                 }
             }
         }
     }
     return maxArea;
 }
}