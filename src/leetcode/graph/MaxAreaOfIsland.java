package leetcode.graph;

public class MaxAreaOfIsland {
	class Solution {
	    int rows, columns;
	    int maxArea, currentArea;
	    boolean visited[][];
	    int [][] grid;
	    public int maxAreaOfIsland(int[][] grid) {
	        this.grid = grid;
	        rows = grid.length;
	        columns = grid[0].length;
	        maxArea = 0;
	        visited = new boolean[rows][columns];
	        for(int i = 0; i < rows; i++){
	            for(int j = 0; j < columns; j++){
	                if(grid[i][j] == 1 && visited[i][j] == false){
	                    currentArea = 0;
	                    visited[i][j] = true;
	                    dfs(i, j);
	                    if(currentArea > maxArea){
	                        maxArea = currentArea;
	                    }
	                }
	            }
	        }
	        return maxArea;
	    }
	    private boolean isOneAndNotVisited(int i, int j){
	        if( i >= 0 && i < rows && j >= 0 && j < columns && grid[i][j] == 1 && visited[i][j] == false){
	            visited[i][j]=true;
	            return true;
	        }
	        return false;
	    }
	    private void dfs(int i, int j){
	        currentArea++;
	        if( isOneAndNotVisited(i-1, j) == true ){
	            dfs(i-1, j);
	        }
	        if(isOneAndNotVisited(i, j+1)){
	            dfs(i, j+1);
	        }
	        if(isOneAndNotVisited(i+1, j)){
	            dfs(i+1, j);
	        }
	        if(isOneAndNotVisited(i, j-1)){
	            dfs(i, j-1);
	        }
	    }
	}
}
