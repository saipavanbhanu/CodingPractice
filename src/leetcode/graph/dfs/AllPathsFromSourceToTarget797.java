package leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget797 {
	class Solution {
	    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	        List<List<Integer>> result = new ArrayList<>();
	        List<Integer> path = new ArrayList<>();
	        dfs(0, graph, result, path);
	        return result;
	    }
	    
	    private void dfs(int node, int[][] graph, List<List<Integer>> result, List<Integer> path){
	        path.add(node);
	        
	        if(node == graph.length-1){
	            result.add(new ArrayList<>(path));
	            path.remove(path.size()-1);
	            return;
	        }
	        
	        for(int edgeVertex : graph[node]){
	            dfs(edgeVertex, graph, result, path);
	        }
	        
	        path.remove(path.size()-1);
	    }
	}
}
