package leetcode.graph.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
 * step1: do the dfs to figure out the island and add all the nodes corresponding to island in visited.
 * step2: start from the visited and do a bfs to figure out the shortest distance from one island to another
*/

public class ShortestBridge934 {

	class Solution {
	    static class Node{
	        int i,j;
	        Node(int i, int j){
	            this.i = i;
	            this.j = j;
	        }
			@Override
			public int hashCode() {
				return Objects.hash(i, j);
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Node other = (Node) obj;
				return i == other.i && j == other.j;
			}
	        @Override
			public String toString() {
				// TODO Auto-generated method stub
				return "("+i+","+j+")";
			}
        }
	    public int shortestBridge(int[][] grid) {
	    	int n = grid.length;
	    	Set<Node> visited = new HashSet<>(n);
	        
	    	for(int i = 0; i < n; i++) {
	    		for(int j = 0; j < n; j++) {
	    			Node node = new Node(i,j);
	    			if(!visited.contains(node) && grid[i][j] == 1 ) {
	    				visited.add(node);
                        dfs(node, visited, grid);
                        //System.out.println("after dfs");
	    				return bfs(visited, grid);
	    			}
	    		}
	    	}
	        return 0;
	    }
	    
	    private boolean isValid(Node node, int [][] grid) {
	    	int n = grid.length;
	    	return !( node.i < 0 || node.i >= n || node.j < 0 || node.j >= n || grid[node.i][node.j] == 0 );
	    }
	    
	    private boolean isValidInQueue(Node node, int [][] grid) {
	    	int n = grid.length;
	    	return !( node.i < 0 || node.i >= n || node.j < 0 || node.j >= n );
	    }
	    
	    private void dfs(Node node, Set<Node> visited, int[][] grid) {
	    	//visited.add(node);
            //System.out.println("Inside dfs");
	    	Node directNode = null;
	    	directNode = new Node(node.i, node.j-1);
	    	if(isValid( directNode, grid) && !visited.contains(directNode) ) {
	    		visited.add(directNode);
	    		dfs(directNode, visited, grid);
	    	}
	    	directNode = new Node(node.i, node.j+1);
	    	if(isValid( directNode, grid) && !visited.contains(directNode)) {
	    		visited.add(directNode);
	    		dfs(directNode, visited, grid);
	    	}
	    	directNode = new Node(node.i-1, node.j);
	    	if(isValid( directNode, grid) && !visited.contains(directNode)) {
	    		visited.add(directNode);
	    		dfs(directNode, visited, grid);
	    	}
	    	directNode = new Node(node.i+1, node.j);
	    	if(isValid( directNode, grid) && !visited.contains(directNode)) {
	    		visited.add(directNode);
	    		dfs(directNode, visited, grid);
	    	}
	    }
	    private boolean reached2ndIsland(Node node, int[][] grid) {
	    	return grid[node.i][node.j] == 1;
	    }
	    private int bfs(Set<Node> visited, int[][] grid) {
	    	int count = 0;
	    	//System.out.println("after dfs: "+visited);
            Deque<Node> q = new ArrayDeque<>(visited);
	    	
            while(!q.isEmpty()){
                int size = q.size();
                //System.out.println(q);
                for(int i = 0; i < size; i++) {
                    Node node = q.pollFirst();

                    Node directNode = null;
                    directNode = new Node(node.i, node.j-1);
                    if(isValidInQueue( directNode, grid) && !visited.contains(directNode)) {
                        visited.add(directNode);
                        q.add(directNode);
                        if(reached2ndIsland(directNode, grid)) {
                            return count;
                        }
                    }
                    directNode = new Node(node.i, node.j+1);
                    if(isValidInQueue( directNode, grid) && !visited.contains(directNode)) {
                        visited.add(directNode);
                        q.add(directNode);
                        if(reached2ndIsland(directNode, grid)) {
                            return count;
                        }
                    }
                    directNode = new Node(node.i-1, node.j);
                    if(isValidInQueue( directNode, grid) && !visited.contains(directNode)) {
                        visited.add(directNode);
                        q.add(directNode);
                        if(reached2ndIsland(directNode, grid)) {
                            return count;
                        }
                    }
                    directNode = new Node(node.i+1, node.j);
                    if(isValidInQueue( directNode, grid) && !visited.contains(directNode)) {
                        visited.add(directNode);
                        q.add(directNode);
                        if(reached2ndIsland(directNode, grid)) {
                            return count;
                        }
                    }
	    	    }
                count++;
            }
	    	
	    	return count;
	    }
	}
	
}
