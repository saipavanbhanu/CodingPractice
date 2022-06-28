package leetcode.graph;
import java.util.Arrays;

public class NumberOfIslands {
	class Solution {
	    private void printMatrix(boolean visited[][], int R, int C){
	        for(int i = 0; i < R; i++){
	            System.out.println(Arrays.toString(visited[i]));
	        }
	    }
	    public int numIslands(char[][] grid) {
	        final int R = grid.length;
	        final int C = grid[0].length;
	        boolean visited[][] = new boolean[R][C];
	        int count = 0;
	        for(int i = 0; i < R; i++){
	            for(int j = 0; j < C; j++){
	                if(grid[i][j] == '1' && visited[i][j] == false){
	                    //System.out.println("dfs:"+i+","+j);
	                    visited[i][j] = true;
	                    numIslandsUtil(i, j, grid, visited, R, C);
	                    //printMatrix(visited, R, C);
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
	    
	    private void numIslandsUtil(int i, int j, char[][] grid, boolean visited[][], final int R, final int C){
	        //System.out.println("uti:"+i+","+j);
	        if(i-1 >= 0 && grid[i-1][j] == '1' && visited[i-1][j] == false){
	            //System.out.println("ins:"+i+","+j);
	            visited[i-1][j] = true;
	            numIslandsUtil(i-1, j, grid, visited, R, C);
	        }
	        if(j-1 >= 0 && grid[i][j-1] == '1' && visited[i][j-1] == false){
	            //System.out.println("ins:"+i+","+j);
	            visited[i][j-1] = true;
	            numIslandsUtil(i, j-1, grid, visited, R, C);
	        }
	        if(j+1 < C && grid[i][j+1] == '1' && visited[i][j+1] == false){
	            //System.out.println("ins:"+i+","+j);
	            visited[i][j+1] = true;
	            numIslandsUtil(i, j+1, grid, visited, R, C);
	        }
	        if(i+1 < R && grid[i+1][j] == '1' && visited[i+1][j] == false){
	            //System.out.println("ins:"+i+","+j);
	            visited[i+1][j] = true;
	            numIslandsUtil(i+1, j, grid, visited, R, C);
	        }
	        
	    }
	}
	
}
