package leetcode.graph.dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

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
	    	boolean visited[][] = new boolean[n][n];
	    	Deque<int[]> q = new ArrayDeque<>(n);
	    	//Set<Node> visited = new HashSet<>(n);
	        
	    	for(int i = 0; i < n; i++) {
	    		for(int j = 0; j < n; j++) {
	    			//Node node = new Node(i,j);
	    			if(visited[i][j] == false && grid[i][j] == 1 ) {
	    				visited[i][j] = true;
	    				q.add(new int[] {i,j});
                        dfs(i, j, visited, grid, q);
                        //System.out.println("after dfs");
	    				return bfs(visited, grid, q);
	    			}
	    		}
	    	}
	        return 0;
	    }
	    
	    private boolean isValid(int i, int j, int [][] grid) {
	    	int n = grid.length;
	    	return !( i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == 0 );
	    }
	    
	    private boolean isValidInQueue(int i, int j, int [][] grid) {
	    	int n = grid.length;
	    	return !( i < 0 || i >= n || j < 0 || j >= n );
	    }
	    
	    private void dfs(int i, int j, boolean[][] visited, int[][] grid, Deque<int[]> q) {
	    	//visited.add(node);
            //System.out.println("Inside dfs");
	    	//Node directNode = null;
	    	int x = -1, y = -1;
	    	
	    	x = i; y = j-1;
	    	if(isValid( x, y, grid) && visited[x][y] == false ) {
	    		visited[x][y] = true;
	    		q.add(new int[] {x,y});
	    		dfs(x, y, visited, grid, q);
	    	}
	    	
	    	x = i; y = j+1;
	    	if(isValid( x, y, grid) && visited[x][y] == false ) {
	    		visited[x][y] = true;
	    		q.add(new int[] {x,y});
	    		dfs(x, y, visited, grid, q);
	    	}
	    	
	    	x = i+1; y = j;
	    	if(isValid( x, y, grid) && visited[x][y] == false ) {
	    		visited[x][y] = true;
	    		q.add(new int[] {x,y});
	    		dfs(x, y, visited, grid, q);
	    	}
	    	
	    	x = i-1; y = j;
	    	if(isValid( x, y, grid) && visited[x][y] == false ) {
	    		visited[x][y] = true;
	    		q.add(new int[] {x,y});
	    		dfs(x, y, visited, grid, q);
	    	}
	    	
	    }
	    private boolean reached2ndIsland(int i, int j, int[][] grid) {
	    	return grid[i][j] == 1;
	    }
	    
	    private int bfs(boolean[][] visited, int[][] grid, Deque<int[]> q) {
	    	int count = 0;
	    	
            while(!q.isEmpty()){
                int size = q.size();
                //System.out.println(q);
                for(int i = 0; i < size; i++) {
                    int[] node = q.pollFirst();

                    //Node directNode = null;
                    //directNode = new Node(node.i, node.j-1);
                    int x = -1, y = -1;
                    
                    x = node[0]; y = node[1]-1;
                    if(isValidInQueue( x, y, grid) && visited[x][y] == false) {
                        visited[x][y] = true;
                        q.add(new int[] {x, y});
                        if(reached2ndIsland(x, y, grid)) {
                            return count;
                        }
                    }
                    
                    
                    x = node[0]; y = node[1]+1;
                    if(isValidInQueue( x, y, grid) && visited[x][y] == false) {
                        visited[x][y] = true;
                        q.add(new int[] {x, y});
                        if(reached2ndIsland(x, y, grid)) {
                            return count;
                        }
                    }
                    x = node[0]-1; y = node[1];
                    if(isValidInQueue( x, y, grid) && visited[x][y] == false) {
                        visited[x][y] = true;
                        q.add(new int[] {x, y});
                        if(reached2ndIsland(x, y, grid)) {
                            return count;
                        }
                    }
                    x = node[0]+1; y = node[1];
                    if(isValidInQueue( x, y, grid) && visited[x][y] == false) {
                        visited[x][y] = true;
                        q.add(new int[] {x, y});
                        if(reached2ndIsland(x, y, grid)) {
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
