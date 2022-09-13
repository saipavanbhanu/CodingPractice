package leetcode.graph.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class IsGraphBipartite785 {
	class Solution {
	    public boolean isBipartite(int[][] graph) {
	        //0 to n-1
	        int n = graph.length;
	        int[] color = new int[n];
	        for(int i = 0; i < n; i++){
	            color[i] = -1; //unvisited
	        }
	        Queue<Integer> q = new ArrayDeque<>();
	        for(int i = 0; i < n; i++){
	            if(color[i] == -1)
	               q.add(i);    
	            color[i] = 1;
	        
	            while(!q.isEmpty()){
	                int vertex = q.remove();
	                for(int edge : graph[vertex]){

	                    if(color[edge] == -1){ //unvisited
	                        color[edge] = 1 - color[vertex];
	                        q.add(edge);
	                    }else if(color[edge] == color[vertex]){
	                        return false;
	                    }else{//colors are different just continue;

	                    }
	                }
	            }    
	        }
	        
	        return true;
	    }
	}
}
