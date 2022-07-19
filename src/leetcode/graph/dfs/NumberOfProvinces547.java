package leetcode.graph.dfs;

public class NumberOfProvinces547 {
	class Solution {
	    int n;
	    boolean visited[];
	    int [][] isConnected;
	    public int findCircleNum(int[][] isConnected) {
	        this.n = isConnected.length;
	        this.isConnected = isConnected;
	        visited = new boolean[n];
	        int count = 0;
	        
	        for(int i = 0; i < n; i++){
	            if(visited[i] == false){
	                visited[i] = true;
	                dfs(i);
	                count++;
	            }
	        }
	        
	        return count;
	    }
	    
	    private void dfs(int index){
	        for(int i = 0; i < n; i++){
	            if(isConnected[index][i] == 1 && visited[i] == false){
	                visited[i] = true;
	                dfs(i);
	            }
	        }
	    }
	}
}
