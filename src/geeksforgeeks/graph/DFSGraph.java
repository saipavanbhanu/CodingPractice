package geeksforgeeks.graph;

import java.util.LinkedList;

/* 	DFS - starting from all vertices of the graph
	we can have a vertex count => whenever we visit a vertex, we increment the count 
	=> whenever the count is V we will return from the function; 
*/

public class DFSGraph {

	private final int V; // No. of vertices

	// Array of lists for
	// Adjacency List Representation
	private LinkedList<Integer> adj[];
	boolean visited[];

	// Constructor
	DFSGraph(int v) {
		V = v;
		visited = new boolean[V];
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list.
	}

	// Driver Code
	public static void main(String args[]) {
		DFSGraph g = new DFSGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.DFS();
	}

	private void DFS() {

		for (int i = 0; i < V; i++) {
			if (visited[i] != true)
				DFSUtil(i);
		}
	}

	private void DFSUtil(int i) {

		if (visited[i] != true) {
			visited[i] = true;
			System.out.print(i + " ");
			for (Integer vertex : adj[i]) {
				if (visited[vertex] != true) {
					DFSUtil(vertex);
				}
			}
		}

	}
}
